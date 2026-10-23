import type { ReadGuardConfig } from "../read-guard.ts";
import type { LifecycleMessage } from "../types.ts";
import { WorkspaceLifecycleRuntime } from "./workspace-runtime.ts";

interface OpenCodeMessage extends LifecycleMessage {
	role?: unknown;
	content?: unknown;
}

interface OpenCodeContextEvent {
	readonly sessionID: string;
	system: Array<{ type: string; text: string; [key: string]: unknown }>;
	messages: OpenCodeMessage[];
}

interface OpenCodeToolEvent {
	readonly tool: string;
	readonly input: unknown;
}

interface OpenCodeV2Context {
	location: { directory: string };
	options?: Record<string, unknown>;
	session: {
		hook(name: "context", callback: (event: OpenCodeContextEvent) => void | Promise<void>): Promise<unknown>;
	};
	tool: {
		hook(name: "execute.before", callback: (event: OpenCodeToolEvent) => void | Promise<void>): Promise<unknown>;
	};
}

interface OpenCodeV1Input {
	directory: string;
}

interface OpenCodeEnvelope {
	info: Record<string, unknown>;
	parts: unknown[];
}

export interface OpenCodeAdapterOptions {
	directory?: string;
	sourceFile?: string;
	readGuard?: ReadGuardConfig;
}

function sessionIDFrom(messages: readonly OpenCodeEnvelope[]): string {
	for (let index = messages.length - 1; index >= 0; index -= 1) {
		const value = messages[index]?.info.sessionID;
		if (typeof value === "string") return value;
	}
	return "opencode:unknown-session";
}

function lifecycleMessages(messages: readonly OpenCodeEnvelope[]): OpenCodeMessage[] {
	return messages.map((message) => ({
		...message.info,
		role: message.info.role,
		content: message.parts,
		timestamp:
			typeof message.info.time === "object" && message.info.time !== null
				? (message.info.time as { created?: unknown }).created
				: undefined,
	}));
}

function replaceEnvelopeParts(
	messages: readonly OpenCodeEnvelope[],
	built: readonly OpenCodeMessage[],
): OpenCodeEnvelope[] {
	return messages.map((message, index) => {
		const replacement = built[index]?.content;
		return Array.isArray(replacement) && replacement !== message.parts
			? { ...message, parts: replacement }
			: message;
	});
}

function activeSystemBlock(rendered: string): string {
	return `<agent_context_lifecycle_blocks>\n${rendered}\n</agent_context_lifecycle_blocks>`;
}

function createV1Hooks(runtime: WorkspaceLifecycleRuntime) {
	return {
		async "tool.execute.before"(
			input: { tool: string; sessionID: string },
			output: { args: unknown },
		): Promise<void> {
			const decision = runtime.readGuard?.evaluate({
				toolName: input.tool,
				input: output.args,
				cwd: runtime.directory,
			});
			if (decision) throw new Error(decision.reason);
		},
		async "experimental.chat.messages.transform"(
			_input: {},
			output: { messages: OpenCodeEnvelope[] },
		): Promise<void> {
			const sessionID = sessionIDFrom(output.messages);
			const lifecycle = runtime.loadTrustedSource(sessionID);
			const built = lifecycle.buildContextView(lifecycleMessages(output.messages));
			output.messages = replaceEnvelopeParts(output.messages, built.messages);
		},
		async "experimental.chat.system.transform"(
			input: { sessionID?: string },
			output: { system: string[] },
		): Promise<void> {
			const lifecycle = runtime.loadTrustedSource(input.sessionID ?? "opencode:unknown-session");
			const rendered = lifecycle.renderActiveBlocks();
			if (rendered) output.system.push(activeSystemBlock(rendered));
		},
	};
}

export function createOpenCodePlugin(options: OpenCodeAdapterOptions = {}) {
	return {
		id: "teaql.agent-context-kit",
		async setup(ctx: OpenCodeV2Context): Promise<void> {
			const runtime = new WorkspaceLifecycleRuntime({
				directory: options.directory ?? ctx.location.directory,
				...(options.sourceFile === undefined ? {} : { sourceFile: options.sourceFile }),
				...(options.readGuard === undefined ? {} : { readGuard: options.readGuard }),
			});
			await ctx.session.hook("context", (event) => {
				const lifecycle = runtime.loadTrustedSource(event.sessionID);
				const built = lifecycle.buildContextView(event.messages);
				event.messages.splice(0, event.messages.length, ...built.messages);
				const rendered = lifecycle.renderActiveBlocks();
				if (rendered) event.system.push({ type: "text", text: activeSystemBlock(rendered) });
			});
			await ctx.tool.hook("execute.before", (event) => {
				const decision = runtime.readGuard?.evaluate({
					toolName: event.tool,
					input: event.input,
					cwd: runtime.directory,
				});
				if (decision) throw new Error(decision.reason);
			});
		},
		async server(input: OpenCodeV1Input) {
			const runtime = new WorkspaceLifecycleRuntime({
				directory: options.directory ?? input.directory,
				...(options.sourceFile === undefined ? {} : { sourceFile: options.sourceFile }),
				...(options.readGuard === undefined ? {} : { readGuard: options.readGuard }),
			});
			return createV1Hooks(runtime);
		},
	};
}

export const openCodePlugin = createOpenCodePlugin();
export default openCodePlugin;
