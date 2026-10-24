import type { ExtensionAPI, ExtensionContext, ToolDefinition } from "@earendil-works/pi-coding-agent";

const STATE = "agent-context-kit-completion-state-v1";
const REPORT = "agent-context-kit-completion-report-v1";
const CHECKS = ["app_build", "app_test"] as const;
const MAX_ROUNDS = 3;
type State = { revision: number; checked: Record<string, number>; rounds: number };

/** Only successful controlled mutations incur work. Prose is never evidence of verification. */
export function createPiCompletionGuard(pi: ExtensionAPI, tools: readonly ToolDefinition<any, any>[]) {
	const available = new Map(tools.map(tool => [tool.name, tool]));
	const enabled = CHECKS.every(name => available.has(name));
	let state: State = { revision: 0, checked: {}, rounds: 0 };
	const save = () => pi.appendEntry(STATE, { ...state, checked: { ...state.checked } });
	const restore = (_event: unknown, ctx: ExtensionContext) => {
		state = { revision: 0, checked: {}, rounds: 0 };
		const entry = ctx.sessionManager.getBranch().slice().reverse().find(entry => entry.type === "custom" && entry.customType === STATE);
		if (entry?.type === "custom") {
			const data = entry.data as State | undefined;
			if (data && Number.isSafeInteger(data.revision) && data.revision >= 0 && Number.isSafeInteger(data.rounds) && data.rounds >= 0 && data.checked && CHECKS.every(name => data.checked[name] === undefined || Number.isSafeInteger(data.checked[name]))) state = { ...data, checked: { ...data.checked } };
		}
	};
	if (enabled) {
		pi.on("session_start", restore);
		pi.on("session_tree", restore);
		pi.on("before_agent_start", event => {
			if (event.messageType === "user") { state.rounds = 0; save(); }
		});
		pi.on("turn_end", async (event, ctx) => {
			if (event.outcome !== "completed" || event.message.role !== "assistant" || event.message.stopReason !== "stop" || ctx.signal?.aborted || !state.revision) return;
			const missing = CHECKS.filter(name => state.checked[name] !== state.revision);
			if (!missing.length) return;
			const draft = (data: unknown) => ({ type: "custom_message" as const, customType: REPORT, content: JSON.stringify(data), display: true });
			if (state.rounds >= MAX_ROUNDS) {
				return { entries: [...event.entries, draft({ status: "VERIFICATION_INCOMPLETE", revision: state.revision, missing, message: "Automatic verification reached its three-round limit. The latest edits remain unverified. Do not claim completion; report the concrete blocker." })] };
			}
			state.rounds++; save();
			const revision = state.revision;
			const results: unknown[] = [];
			try {
				for (const name of missing) {
					if (ctx.signal?.aborted) return;
					ctx.ui.setStatus("completion-check", `Verifying edits: ${name}`);
					try {
						const result = await available.get(name)!.execute(`completion-${revision}-${name}`, {}, ctx.signal, undefined, { ...ctx, tools: [], executeTool: async () => { throw new Error("Nested tools are unavailable during fixed completion verification."); } });
						results.push({ tool: name, result });
					} catch (error) {
						// These are the same host-owned, policy-filtered errors exposed by the tool.
						results.push({ tool: name, isError: true, error: error instanceof Error ? error.message : "Host verification failed." });
					}
					if (ctx.signal?.aborted) return;
					state.checked[name] = revision; save();
				}
			} finally { ctx.ui.setStatus("completion-check", undefined); }
			return { entries: [...event.entries, draft({ source: "host_completion_check", revision, results, instruction: "The host ran the missing verification tools after your edits. Use these actual results. If verification failed, make only justified localized repairs and verify again, or report the concrete blocker. Do not merely promise to run tools. If tests executed zero cases, state that limitation. Do not repeat unchanged failed checks or inspect excluded source." })], continue: true };
		});
	}
	return (tool: ToolDefinition<any, any>): ToolDefinition<any, any> => {
		if (!enabled) return tool;
		return { ...tool, async execute(...args) {
			const revision = state.revision;
			try {
				const result = await tool.execute(...args);
				if (["write", "edit"].includes(tool.name) && (result.details as { status?: string } | undefined)?.status === "ok") { state.revision++; save(); }
				return result;
			} finally {
				if ((CHECKS as readonly string[]).includes(tool.name) && args[1] && typeof args[1] === "object" && Object.keys(args[1]).length === 0 && !args[2]?.aborted) { state.checked[tool.name] = revision; save(); }
			}
		} };
	};
}
