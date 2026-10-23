import { mkdirSync, readFileSync, renameSync, writeFileSync } from "node:fs";
import { dirname } from "node:path";

import { LifecycleSession } from "../session.ts";
import type { LifecycleMessage, LifecycleSnapshot } from "../types.ts";

const ACTIVE_WRAPPER = "agent_context_lifecycle_blocks";

export interface GeminiCliMessage {
	role: "user" | "model" | "system";
	content: string;
}

export interface GeminiCliRequest {
	model: string;
	messages: GeminiCliMessage[];
	config?: Record<string, unknown>;
	toolConfig?: Record<string, unknown>;
	[key: string]: unknown;
}

export interface GeminiBeforeModelInput {
	session_id: string;
	transcript_path: string;
	cwd: string;
	hook_event_name: "BeforeModel" | string;
	timestamp: string;
	llm_request: GeminiCliRequest;
}

export interface GeminiBeforeModelOutput {
	hookSpecificOutput: {
		hookEventName: "BeforeModel";
		llm_request: GeminiCliRequest;
	};
	suppressOutput: true;
}

export interface GeminiStateStore {
	load(input: GeminiBeforeModelInput): LifecycleSnapshot | undefined;
	save(input: GeminiBeforeModelInput, snapshot: LifecycleSnapshot): void;
}

/** Store hook state next to Gemini CLI's own per-session transcript. */
export class FileGeminiStateStore implements GeminiStateStore {
	path(input: GeminiBeforeModelInput): string {
		return `${input.transcript_path}.agent-context-kit-v1.json`;
	}

	load(input: GeminiBeforeModelInput): LifecycleSnapshot | undefined {
		try {
			return JSON.parse(readFileSync(this.path(input), "utf8")) as LifecycleSnapshot;
		} catch (error) {
			if ((error as NodeJS.ErrnoException).code === "ENOENT") return undefined;
			throw error;
		}
	}

	save(input: GeminiBeforeModelInput, snapshot: LifecycleSnapshot): void {
		const target = this.path(input);
		mkdirSync(dirname(target), { recursive: true });
		const temporary = `${target}.${process.pid}.tmp`;
		writeFileSync(temporary, `${JSON.stringify(snapshot)}\n`, { encoding: "utf8", mode: 0o600 });
		renameSync(temporary, target);
	}
}

function lifecycleRole(role: GeminiCliMessage["role"]): "user" | "assistant" | "system" {
	return role === "model" ? "assistant" : role;
}

function geminiRole(role: unknown): GeminiCliMessage["role"] {
	return role === "assistant" ? "model" : role as GeminiCliMessage["role"];
}

function activeMessage(rendered: string): GeminiCliMessage {
	return {
		role: "system",
		content: `<${ACTIVE_WRAPPER}>\n${rendered}\n</${ACTIVE_WRAPPER}>`,
	};
}

/**
 * Gemini CLI BeforeModel bridge.
 *
 * The stable hook API exposes text only. Consequently this adapter is exact for
 * text messages, while non-text tool payloads remain outside the hook contract.
 */
export class GeminiCliLifecycleAdapter {
	private readonly store: GeminiStateStore;

	constructor(store: GeminiStateStore = new FileGeminiStateStore()) {
		this.store = store;
	}

	handleBeforeModel(input: GeminiBeforeModelInput): GeminiBeforeModelOutput {
		if (input.hook_event_name !== "BeforeModel") {
			throw new Error(`Expected BeforeModel hook input, received ${input.hook_event_name}`);
		}
		if (!input.llm_request || !Array.isArray(input.llm_request.messages)) {
			throw new Error("BeforeModel input is missing llm_request.messages");
		}

		const session = new LifecycleSession();
		const snapshot = this.store.load(input);
		if (snapshot) session.restore(snapshot);

		const stripped = input.llm_request.messages.map((message, index) => {
			if (message.role !== "system") return { ...message };
			const parsed = session.loadMarkdownSource(
				`gemini-cli:system:${index}`,
				message.content,
				"gemini_before_model_system_context",
			);
			return { ...message, content: parsed.ordinaryMarkdown };
		});
		const lifecycleMessages: LifecycleMessage[] = stripped.map((message) => ({
			...message,
			role: lifecycleRole(message.role),
		}));
		const built = session.buildContextView(lifecycleMessages, {
			isTrustedDiscardSource: (message, index) =>
				message.role === "system"
					? {
						source: `gemini-cli:system:${index}`,
						trigger: "gemini_before_model_system_context",
						trusted: true,
					}
					: undefined,
		});
		const messages = built.messages.map((message) => ({
			role: geminiRole(message.role),
			content: String(message.content ?? ""),
		}));
		const rendered = session.renderActiveBlocks();
		if (rendered) messages.push(activeMessage(rendered));

		this.store.save(input, session.snapshot());
		return {
			hookSpecificOutput: {
				hookEventName: "BeforeModel",
				llm_request: { ...input.llm_request, messages },
			},
			suppressOutput: true,
		};
	}
}

export const geminiCliLifecycleConstants = { activeWrapper: ACTIVE_WRAPPER } as const;
