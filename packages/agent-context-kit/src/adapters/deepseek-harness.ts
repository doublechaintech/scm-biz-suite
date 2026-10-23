import { readFileSync } from "node:fs";
import { join } from "node:path";

import { getMessageText, LifecycleSession } from "../session.ts";
import { parseMarkdown } from "../parser.ts";
import type { LifecycleMessage } from "../types.ts";

const SOURCE_FILE = ".agent-context-kit.md";
const CONSUME_EVENT = "agent-context-kit/consume-ephemeral-v1";

interface DeepSeekMessage extends LifecycleMessage {
	role?: unknown;
	content?: unknown;
}

interface DeepSeekEvent {
	type: string;
	seq: number;
	data: unknown;
}

interface ProjectionContext {
	nodes: readonly number[];
	events: readonly DeepSeekEvent[];
	baseSeq: number;
	messages: ReadonlyMap<number, DeepSeekMessage>;
}

interface DeepSeekSession {
	header: { cwd?: string };
	surface: { nodes: readonly number[] };
	deriveMessages(): DeepSeekMessage[];
	append(type: string, data: unknown): unknown;
}

interface DeepSeekAgent {
	session: DeepSeekSession;
}

interface DeepSeekContext {
	sessions: {
		registerMessageProjection(projection: typeof deepSeekEphemeralProjection): unknown;
	};
	systemPrompt: {
		section(section: {
			name: string;
			order: number;
			interpolate: boolean;
			text: (context: { agent?: DeepSeekAgent }) => string;
		}): unknown;
	};
	on(
		event: "agent/pre-step",
		handler: (
			payload: { agent: DeepSeekAgent },
			next: () => Promise<unknown>,
		) => Promise<unknown>,
	): unknown;
}

interface AgentState {
	lifecycle: LifecycleSession;
	loaded: Set<string>;
}

const agentStates = new WeakMap<object, AgentState>();

function stateFor(agent: DeepSeekAgent): AgentState {
	let state = agentStates.get(agent as object);
	if (!state) {
		state = { lifecycle: new LifecycleSession(), loaded: new Set() };
		agentStates.set(agent as object, state);
	}
	return state;
}

function sourceVersion(path: string, markdown: string): string {
	let value = 0x811c9dc5;
	for (let index = 0; index < markdown.length; index += 1) {
		value ^= markdown.charCodeAt(index);
		value = Math.imul(value, 0x01000193);
	}
	return `${path}:${(value >>> 0).toString(16)}`;
}

function loadTrustedSource(agent: DeepSeekAgent): string {
	const cwd = agent.session.header.cwd;
	if (!cwd) return "";
	const path = join(cwd, SOURCE_FILE);
	let markdown: string;
	try {
		markdown = readFileSync(path, "utf8");
	} catch (error) {
		if ((error as NodeJS.ErrnoException).code === "ENOENT") return "";
		throw error;
	}
	const state = stateFor(agent);
	const version = sourceVersion(path, markdown);
	if (!state.loaded.has(version)) {
		state.loaded.add(version);
		state.lifecycle.loadMarkdownSource(`deepseek-harness:${path}`, markdown, "deepseek_source_loaded");
		state.lifecycle.applyControlMarkdown(markdown, {
			source: `deepseek-harness:${path}`,
			trigger: "deepseek_trusted_source",
			trusted: true,
		});
	}
	return state.lifecycle.renderActiveBlocks();
}

function messageFromEvent(event: DeepSeekEvent | undefined): DeepSeekMessage | undefined {
	if (!event || typeof event.data !== "object" || event.data === null) return undefined;
	if (event.type === "user/message") return event.data as DeepSeekMessage;
	const message = (event.data as { message?: unknown }).message;
	return typeof message === "object" && message !== null ? message as DeepSeekMessage : undefined;
}

function isEphemeral(message: DeepSeekMessage): boolean {
	const text = getMessageText(message);
	return text.length > 0 && parseMarkdown(text, "deepseek-harness:message").ephemeral;
}

function byteLength(content: unknown): number {
	const serialized = typeof content === "string" ? content : JSON.stringify(content);
	return new TextEncoder().encode(serialized ?? "").byteLength;
}

function tombstone(message: DeepSeekMessage): DeepSeekMessage {
	const bytes = byteLength(message.content);
	return {
		...message,
		content: [{
			type: "text",
			text: `[EPHEMERAL:Output omitted after consumption;original_bytes=${bytes}]`,
		}],
	};
}

function hasConsumableEphemeral(messages: readonly DeepSeekMessage[]): boolean {
	let latestAssistant = -1;
	for (let index = messages.length - 1; index >= 0; index -= 1) {
		if (messages[index]?.role === "assistant") {
			latestAssistant = index;
			break;
		}
	}
	if (latestAssistant < 0) return false;
	return messages.slice(0, latestAssistant).some(isEphemeral);
}

/** Durable request-local projection interpreted by DeepSeek Harness on replay. */
export const deepSeekEphemeralProjection = {
	type: CONSUME_EVENT,
	project(event: DeepSeekEvent, context: ProjectionContext): Map<number, DeepSeekMessage> {
		if (
			typeof event.data !== "object"
			|| event.data === null
			|| (event.data as { version?: unknown }).version !== 1
		) {
			throw new Error(`${CONSUME_EVENT}: data.version must equal 1`);
		}
		const current = context.nodes.map((seq) => {
			const source = context.events[seq - context.baseSeq];
			return { seq, message: context.messages.get(seq) ?? messageFromEvent(source) };
		});
		let latestAssistant = -1;
		for (let index = current.length - 1; index >= 0; index -= 1) {
			if (current[index]?.message?.role === "assistant") {
				latestAssistant = index;
				break;
			}
		}
		const replacements = new Map<number, DeepSeekMessage>();
		if (latestAssistant < 0) return replacements;
		for (const candidate of current.slice(0, latestAssistant)) {
			if (candidate.message && isEphemeral(candidate.message)) {
				replacements.set(candidate.seq, tombstone(candidate.message));
			}
		}
		return replacements;
	},
};

/** DeepSeek Harness function plugin entry point. */
export const name = "agent-context-kit";
export const inject = ["agents", "sessions", "systemPrompt"];

export function apply(ctx: DeepSeekContext): void {
	ctx.sessions.registerMessageProjection(deepSeekEphemeralProjection);
	ctx.systemPrompt.section({
		name: "agent-context-kit:active-blocks",
		order: 9000,
		interpolate: false,
		text: ({ agent }) => agent ? loadTrustedSource(agent) : "",
	});
	ctx.on("agent/pre-step", async ({ agent }, next) => {
		if (hasConsumableEphemeral(agent.session.deriveMessages())) {
			agent.session.append(CONSUME_EVENT, { version: 1 });
		}
		return next();
	});
}

export const deepSeekHarnessLifecycleConstants = {
	sourceFile: SOURCE_FILE,
	consumeEvent: CONSUME_EVENT,
} as const;
