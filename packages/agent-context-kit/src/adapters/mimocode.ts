import type { ReadGuardConfig } from "../read-guard.ts";
import type { LifecycleMessage } from "../types.ts";
import { WorkspaceLifecycleRuntime } from "./workspace-runtime.ts";

interface MiMoPluginInput {
	directory: string;
}

interface MiMoEnvelope {
	info: Record<string, unknown>;
	parts: unknown[];
}

export interface MiMoCodeAdapterOptions {
	directory?: string;
	sourceFile?: string;
	readGuard?: ReadGuardConfig;
}

function sessionIDFrom(messages: readonly MiMoEnvelope[]): string {
	for (let index = messages.length - 1; index >= 0; index -= 1) {
		const value = messages[index]?.info.sessionID;
		if (typeof value === "string") return value;
	}
	return "mimocode:unknown-session";
}

function lifecycleMessages(messages: readonly MiMoEnvelope[]): LifecycleMessage[] {
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
	messages: readonly MiMoEnvelope[],
	built: readonly LifecycleMessage[],
): MiMoEnvelope[] {
	return messages.map((message, index) => {
		const replacement = built[index]?.content;
		return Array.isArray(replacement) && replacement !== message.parts
			? { ...message, parts: replacement }
			: message;
	});
}

export function createMiMoCodePlugin(options: MiMoCodeAdapterOptions = {}) {
	return async function agentContextKitMiMoCode(input: MiMoPluginInput) {
		const runtime = new WorkspaceLifecycleRuntime({
			directory: options.directory ?? input.directory,
			...(options.sourceFile === undefined ? {} : { sourceFile: options.sourceFile }),
			...(options.readGuard === undefined ? {} : { readGuard: options.readGuard }),
		});
		return {
			async "tool.execute.before"(
				hookInput: { tool: string; sessionID: string },
				output: { args: unknown; cancel?: boolean; cancelReason?: string },
			): Promise<void> {
				const decision = runtime.readGuard?.evaluate({
					toolName: hookInput.tool,
					input: output.args,
					cwd: runtime.directory,
				});
				if (!decision) return;
				output.cancel = true;
				output.cancelReason = decision.reason;
			},
			async "experimental.chat.messages.transform"(
				_input: {},
				output: { messages: MiMoEnvelope[] },
			): Promise<void> {
				const sessionID = sessionIDFrom(output.messages);
				const lifecycle = runtime.loadTrustedSource(sessionID);
				const built = lifecycle.buildContextView(lifecycleMessages(output.messages));
				output.messages = replaceEnvelopeParts(output.messages, built.messages);
			},
			async "experimental.chat.system.transform"(
				hookInput: { sessionID?: string },
				output: { system: string[] },
			): Promise<void> {
				const lifecycle = runtime.loadTrustedSource(
					hookInput.sessionID ?? "mimocode:unknown-session",
				);
				const rendered = lifecycle.renderActiveBlocks();
				if (rendered) {
					output.system.push(
						`<agent_context_lifecycle_blocks>\n${rendered}\n</agent_context_lifecycle_blocks>`,
					);
				}
			},
		};
	};
}

const miMoCodePlugin = createMiMoCodePlugin();
export default miMoCodePlugin;
