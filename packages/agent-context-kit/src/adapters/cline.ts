import type { ReadGuardConfig } from "../read-guard.ts";
import type { LifecycleMessage } from "../types.ts";
import { WorkspaceLifecycleRuntime } from "./workspace-runtime.ts";

interface ClinePluginContext {
	workspaceInfo?: { rootPath?: string };
}

interface ClinePluginApi {
	registerMessageBuilder(builder: {
		name: string;
		build(messages: LifecycleMessage[]): LifecycleMessage[];
	}): void;
}

export interface ClineAdapterOptions {
	directory?: string;
	sourceFile?: string;
	readGuard?: ReadGuardConfig;
}

function activeBlockMessage(rendered: string): LifecycleMessage {
	return {
		role: "user",
		content: [{
			type: "text",
			text: `<agent_context_lifecycle_blocks>\n${rendered}\n</agent_context_lifecycle_blocks>`,
		}],
		metadata: { kind: "agent-context-kit-active-blocks" },
	};
}

export function createClinePlugin(options: ClineAdapterOptions = {}) {
	let runtime: WorkspaceLifecycleRuntime | undefined;
	const getRuntime = () => {
		if (!runtime) {
			runtime = new WorkspaceLifecycleRuntime({
				directory: options.directory ?? process.cwd(),
				...(options.sourceFile === undefined ? {} : { sourceFile: options.sourceFile }),
				...(options.readGuard === undefined ? {} : { readGuard: options.readGuard }),
			});
		}
		return runtime;
	};

	return {
		name: "agent-context-kit",
		manifest: { capabilities: ["messageBuilders", "hooks"] },
		setup(api: ClinePluginApi, context: ClinePluginContext) {
			runtime = new WorkspaceLifecycleRuntime({
				directory: options.directory ?? context.workspaceInfo?.rootPath ?? process.cwd(),
				...(options.sourceFile === undefined ? {} : { sourceFile: options.sourceFile }),
				...(options.readGuard === undefined ? {} : { readGuard: options.readGuard }),
			});
			api.registerMessageBuilder({
				name: "agent-context-kit-request-view",
				build(messages) {
					const lifecycle = getRuntime().loadTrustedSource("cline:session");
					const built = lifecycle.buildContextView(messages);
					const rendered = lifecycle.renderActiveBlocks();
					return rendered ? [...built.messages, activeBlockMessage(rendered)] : built.messages;
				},
			});
		},
		hooks: {
			beforeTool({ toolCall, input }: { toolCall: { toolName: string }; input: unknown }) {
				const current = getRuntime();
				const decision = current.readGuard?.evaluate({
					toolName: toolCall.toolName,
					input,
					cwd: current.directory,
				});
				return decision ? { skip: true, reason: decision.reason } : undefined;
			},
		},
	};
}

export const clinePlugin = createClinePlugin();
export default clinePlugin;
