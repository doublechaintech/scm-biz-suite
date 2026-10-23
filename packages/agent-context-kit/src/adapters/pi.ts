import { existsSync, readFileSync } from "node:fs";
import { resolve } from "node:path";

import { ReadGuard, parseReadGuardConfig, type ReadGuardConfig } from "../read-guard.ts";
import { LifecycleSession, getMessageText } from "../session.ts";
import type {
	AuditEvent,
	ControlSource,
	LifecycleMessage,
	LifecycleSnapshot,
} from "../types.ts";

const AUDIT_ENTRY = "agent-context-kit-audit-v1";
const STATE_ENTRY = "agent-context-kit-state-v1";
const CONTROL_MESSAGE_TYPE = "agent-context-kit-control";
const ACTIVE_MESSAGE_TYPE = "agent-context-kit-active-v1";
const READ_GUARD_ENTRY = "agent-context-kit-read-guard-v1";
const BLOCK_ID = /^[a-z0-9_-]+$/;
const DEFAULT_CONFIG_FILE = ".agent-context-kit.json";

interface PiContext {
	cwd?: string;
	ui?: {
		notify?: (message: string, type?: "info" | "warning" | "error") => void;
		setStatus?: (key: string, text: string | undefined) => void;
	};
	sessionManager?: {
		getBranch?: () => unknown[];
	};
}

interface PiExtensionApi {
	on(event: string, handler: (event: any, context: PiContext) => unknown): void | (() => void);
	appendEntry?<T>(customType: string, data?: T): void;
	registerCommand?(
		name: string,
		options: {
			description?: string;
			handler: (args: string, context: PiContext) => Promise<void> | void;
		},
	): void;
}

interface PiContextFile {
	path: string;
	content: string;
}

interface PiSkill {
	name: string;
	filePath: string;
}

interface PiBeforeAgentStartEvent {
	prompt: string;
	systemPrompt: string;
	systemPromptOptions: {
		contextFiles?: PiContextFile[];
		skills?: PiSkill[];
	};
}

export interface PiAdapterOptions {
	/** Additional trusted discard-message policy. Default: only the adapter control custom message. */
	trustedDiscardSource?: (
		message: LifecycleMessage,
		index: number,
	) => ControlSource | undefined;
	clock?: () => Date;
	readGuard?: ReadGuardConfig;
}

interface PiConfigurationFile {
	readGuard?: unknown;
}

export function loadPiAdapterOptions(
	cwd = process.cwd(),
	environment: NodeJS.ProcessEnv = process.env,
): PiAdapterOptions {
	const explicitPath = environment.AGENT_CONTEXT_KIT_CONFIG;
	const configPath = resolve(cwd, explicitPath ?? DEFAULT_CONFIG_FILE);
	if (!existsSync(configPath)) {
		if (explicitPath) throw new Error(`Agent Context Kit config not found: ${configPath}`);
		return {};
	}

	let parsed: unknown;
	try {
		parsed = JSON.parse(readFileSync(configPath, "utf8"));
	} catch (error) {
		throw new Error(
			`Invalid Agent Context Kit config at ${configPath}: ${error instanceof Error ? error.message : String(error)}`,
		);
	}
	if (typeof parsed !== "object" || parsed === null || Array.isArray(parsed)) {
		throw new Error(`Agent Context Kit config must be a JSON object: ${configPath}`);
	}
	const config = parsed as PiConfigurationFile;
	if (config.readGuard === undefined) return {};
	return { readGuard: parseReadGuardConfig(config.readGuard, `${configPath}:readGuard`) };
}

function xmlDecode(value: string): string {
	return value
		.replaceAll("&quot;", '"')
		.replaceAll("&apos;", "'")
		.replaceAll("&lt;", "<")
		.replaceAll("&gt;", ">")
		.replaceAll("&amp;", "&");
}

function skillBody(markdown: string): string {
	const frontmatter = /^---(?:\r\n|\n|\r)[\s\S]*?(?:\r\n|\n|\r)---(?:\r\n|\n|\r|$)/;
	return markdown.replace(frontmatter, "").trim();
}

function replaceMessageText(message: LifecycleMessage, original: string, replacement: string): LifecycleMessage {
	if (typeof message.content === "string") {
		return message.content === original ? { ...message, content: replacement } : message;
	}
	if (!Array.isArray(message.content)) return message;
	let changed = false;
	const content = message.content.map((part) => {
		if (typeof part !== "object" || part === null) return part;
		const candidate = part as { type?: unknown; text?: unknown };
		if (candidate.type !== "text" || candidate.text !== original) return part;
		changed = true;
		return { ...candidate, text: replacement };
	});
	return changed ? { ...message, content } : message;
}

function latestSnapshot(entries: unknown[]): LifecycleSnapshot | undefined {
	for (let index = entries.length - 1; index >= 0; index -= 1) {
		const entry = entries[index];
		if (typeof entry !== "object" || entry === null) continue;
		const candidate = entry as { type?: unknown; customType?: unknown; data?: unknown };
		if (candidate.type !== "custom" || candidate.customType !== STATE_ENTRY) continue;
		if (typeof candidate.data !== "object" || candidate.data === null) return undefined;
		return candidate.data as LifecycleSnapshot;
	}
	return undefined;
}

function defaultTrustedDiscardSource(message: LifecycleMessage): ControlSource | undefined {
	if (message.role !== "custom" || message.customType !== CONTROL_MESSAGE_TYPE) return undefined;
	return {
		source: `pi:custom:${CONTROL_MESSAGE_TYPE}`,
		trigger: "trusted_custom_message",
		trusted: true,
	};
}

function injectActiveMessage(messages: LifecycleMessage[], renderedBlocks: string): LifecycleMessage[] {
	if (!renderedBlocks) return messages;
	const content = `<agent_context_lifecycle_blocks>\n${renderedBlocks}\n</agent_context_lifecycle_blocks>`;
	const activeMessage = {
		role: "custom",
		customType: ACTIVE_MESSAGE_TYPE,
		content,
		display: false,
		timestamp: Date.now(),
	};
	let insertAt = 0;
	while (messages[insertAt]?.role === "system") insertAt += 1;
	return [...messages.slice(0, insertAt), activeMessage, ...messages.slice(insertAt)];
}

function rewriteExpandedSkills(
	prompt: string,
	trustedSkills: ReadonlyMap<string, string>,
	invokedSkillNames: ReadonlySet<string>,
	load: (source: string, markdown: string) => string,
): string {
	const wrapper = /<skill name="([^"]+)" location="([^"]+)">\n([\s\S]*?)\n<\/skill>/g;
	return prompt.replace(wrapper, (full, name: string, encodedLocation: string, body: string) => {
		const location = xmlDecode(encodedLocation);
		if (trustedSkills.get(location) !== name || !invokedSkillNames.has(name)) return full;
		let trustedBody: string;
		try {
			trustedBody = skillBody(readFileSync(location, "utf8"));
		} catch {
			return full;
		}
		if (!trustedBody || !body.endsWith(trustedBody)) return full;
		const ordinary = load(`pi:skill:${location}`, trustedBody);
		return full.replace(trustedBody, ordinary);
	});
}

/**
 * Stateful Pi bridge. The default export below creates one instance per Pi
 * extension runtime, while tests and embedding hosts can instantiate it
 * directly and call its trusted control method.
 */
export class PiLifecycleAdapter {
	private readonly pi: PiExtensionApi;
	private readonly options: PiAdapterOptions;
	private readonly readGuard: ReadGuard | undefined;
	private session: LifecycleSession;
	private readonly promptRewrites = new Map<string, string>();
	private readonly pendingSkillNames = new Set<string>();
	private persistedAuditCount = 0;

	constructor(pi: PiExtensionApi, options: PiAdapterOptions = {}) {
		this.pi = pi;
		this.options = options;
		this.readGuard = options.readGuard ? new ReadGuard(options.readGuard) : undefined;
		this.session = this.createSession();
		this.register();
	}

	get state(): LifecycleSession {
		return this.session;
	}

	loadTrustedMarkdown(source: string, markdown: string, trigger = "trusted_source_loaded"): string {
		const parsed = this.session.loadMarkdownSource(source, markdown, trigger);
		this.persistState();
		return parsed.ordinaryMarkdown;
	}

	acceptTrustedControl(markdown: string, source = "pi:trusted-workflow", trigger = "workflow_control"): void {
		this.session.applyControlMarkdown(markdown, { source, trigger, trusted: true });
		this.persistState();
	}

	private createSession(): LifecycleSession {
		return new LifecycleSession({
			...(this.options.clock ? { clock: this.options.clock } : {}),
			onAudit: (event: AuditEvent) => this.pi.appendEntry?.(AUDIT_ENTRY, event),
		});
	}

	private register(): void {
		this.pi.on("session_start", (_event, context) => {
			this.session = this.createSession();
			this.promptRewrites.clear();
			this.pendingSkillNames.clear();
			const entries = context.sessionManager?.getBranch?.() ?? [];
			const snapshot = latestSnapshot(entries);
			if (snapshot) this.session.restore(snapshot);
			this.persistedAuditCount = this.session.audit.length;
			context.ui?.setStatus?.("agent-context-kit", "context lifecycle active");
		});

		this.pi.on("session_shutdown", (_event, context) => {
			context.ui?.setStatus?.("agent-context-kit", undefined);
		});

		this.pi.on("input", (event: { text?: unknown }) => {
			if (typeof event.text !== "string") return;
			const invocation = /^\/skill:([a-z0-9-]+)(?:\s|$)/.exec(event.text);
			if (invocation?.[1]) this.pendingSkillNames.add(invocation[1]);
		});

		this.pi.on("tool_call", (event: { toolName: string; input: unknown }, context) => {
			const decision = this.readGuard?.evaluate({
				toolName: event.toolName,
				input: event.input,
				...(context.cwd === undefined ? {} : { cwd: context.cwd }),
			});
			if (!decision) return undefined;
			this.pi.appendEntry?.(READ_GUARD_ENTRY, {
				...decision,
				timestamp: new Date().toISOString(),
			});
			context.ui?.notify?.(
				`Blocked ${decision.toolName} access to ${decision.protectedPath ?? "protected paths"}`,
				"warning",
			);
			return { block: true, reason: decision.reason };
		});

		this.pi.on("before_agent_start", (rawEvent) => {
			const event = rawEvent as PiBeforeAgentStartEvent;
			let systemPrompt = event.systemPrompt;
			for (const contextFile of event.systemPromptOptions.contextFiles ?? []) {
				const original = contextFile.content;
				const ordinary = this.loadTrustedMarkdown(
					`pi:context:${contextFile.path}`,
					original,
					"pi_context_file_loaded",
				);
				if (original !== ordinary && original.length > 0) {
					systemPrompt = systemPrompt.replaceAll(original, ordinary);
				}
			}

			const trustedSkills = new Map(
				(event.systemPromptOptions.skills ?? []).map((skill) => [skill.filePath, skill.name]),
			);
			const rewritten = rewriteExpandedSkills(
				event.prompt,
				trustedSkills,
				this.pendingSkillNames,
				(source, markdown) => this.loadTrustedMarkdown(source, markdown, "pi_skill_expanded"),
			);
			this.pendingSkillNames.clear();
			if (rewritten !== event.prompt) this.promptRewrites.set(event.prompt, rewritten);
			return systemPrompt === event.systemPrompt ? undefined : { systemPrompt };
		});

		this.pi.on("context", (event: { messages: LifecycleMessage[] }) => {
			let messages = event.messages.map((message) => {
				const text = getMessageText(message);
				const replacement = this.promptRewrites.get(text);
				return replacement === undefined ? message : replaceMessageText(message, text, replacement);
			});
			const built = this.session.buildContextView(messages, {
				isTrustedDiscardSource: (message, index) =>
					this.options.trustedDiscardSource?.(message, index) ?? defaultTrustedDiscardSource(message),
			});
			messages = injectActiveMessage(built.messages, this.session.renderActiveBlocks());
			this.persistState();
			return { messages };
		});

		this.pi.registerCommand?.("context-discard", {
			description: "Discard an active agent-context-kit block by exact block ID",
			handler: (args, context) => {
				const id = args.trim();
				if (!BLOCK_ID.test(id)) {
					context.ui?.notify?.("Block ID must match [a-z0-9_-]+", "error");
					return;
				}
				this.acceptTrustedControl(
					`<!--DISCARD_BLOCK:${id}-->`,
					"pi:command:context-discard",
					"trusted_command",
				);
				context.ui?.notify?.(`Discard processed for ${id}`, "info");
			},
		});
	}

	private persistState(): void {
		if (this.persistedAuditCount === this.session.audit.length) return;
		this.persistedAuditCount = this.session.audit.length;
		this.pi.appendEntry?.(STATE_ENTRY, this.session.snapshot());
	}
}

export default function agentContextKitPiExtension(pi: PiExtensionApi): void {
	new PiLifecycleAdapter(pi, loadPiAdapterOptions());
}

export const piLifecycleConstants = {
	auditEntry: AUDIT_ENTRY,
	stateEntry: STATE_ENTRY,
	controlMessageType: CONTROL_MESSAGE_TYPE,
	activeMessageType: ACTIVE_MESSAGE_TYPE,
	readGuardEntry: READ_GUARD_ENTRY,
} as const;
