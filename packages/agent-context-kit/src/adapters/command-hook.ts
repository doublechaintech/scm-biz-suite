import { pathToFileURL } from "node:url";

import { WorkspaceLifecycleRuntime } from "./workspace-runtime.ts";

export type CommandHookHost = "kimi" | "qwen" | "copilot" | "kiro" | "crush";

export interface CommandHookResult {
	stdout: string;
	stderr: string;
	exitCode: number;
}

function record(value: unknown): Record<string, unknown> | undefined {
	return typeof value === "object" && value !== null && !Array.isArray(value)
		? value as Record<string, unknown>
		: undefined;
}

function eventName(input: Record<string, unknown>): string {
	return String(
		input.hook_event_name ?? input.hookEventName ?? input.event ?? input.trigger ?? "",
	);
}

function toolCall(input: Record<string, unknown>): { toolName: string; toolInput: unknown } {
	return {
		toolName: String(input.tool_name ?? input.toolName ?? ""),
		toolInput: input.tool_input ?? input.toolArgs ?? input.toolInput ?? {},
	};
}

function contextText(runtime: WorkspaceLifecycleRuntime, sessionID: string): string {
	const rendered = runtime.loadTrustedSource(sessionID).renderActiveBlocks();
	return rendered
		? `<agent_context_lifecycle_blocks>\n${rendered}\n</agent_context_lifecycle_blocks>`
		: "";
}

export function handleCommandHook(
	host: CommandHookHost,
	value: unknown,
): CommandHookResult {
	const input = record(value);
	if (!input) return { stdout: "", stderr: "Invalid hook payload", exitCode: 2 };
	const directory = typeof input.cwd === "string" ? input.cwd : process.cwd();
	const runtime = new WorkspaceLifecycleRuntime({ directory });
	const event = eventName(input).toLowerCase();
	const sessionID = String(input.session_id ?? input.sessionId ?? `${host}:session`);

	if (event === "userpromptsubmit" || event === "sessionstart" || event === "subagentstart") {
		return { stdout: contextText(runtime, sessionID), stderr: "", exitCode: 0 };
	}
	if (event !== "pretooluse") return { stdout: "", stderr: "", exitCode: 0 };

	const call = toolCall(input);
	const decision = runtime.readGuard?.evaluate({
		toolName: call.toolName,
		input: call.toolInput,
		cwd: directory,
	});
	if (!decision) return { stdout: "", stderr: "", exitCode: 0 };

	if (host === "kiro") return { stdout: "", stderr: decision.reason, exitCode: 2 };
	if (host === "crush") {
		return {
			stdout: JSON.stringify({ version: 1, decision: "deny", reason: decision.reason }),
			stderr: "",
			exitCode: 0,
		};
	}
	if (host === "copilot") {
		return {
			stdout: JSON.stringify({
				permissionDecision: "deny",
				permissionDecisionReason: decision.reason,
			}),
			stderr: "",
			exitCode: 0,
		};
	}
	return {
		stdout: JSON.stringify({
			hookSpecificOutput: {
				hookEventName: "PreToolUse",
				permissionDecision: "deny",
				permissionDecisionReason: decision.reason,
			},
		}),
		stderr: "",
		exitCode: 0,
	};
}

async function main(): Promise<void> {
	const host = process.argv[2] as CommandHookHost | undefined;
	if (!host || !["kimi", "qwen", "copilot", "kiro", "crush"].includes(host)) {
		throw new Error("Expected hook host: kimi, qwen, copilot, kiro, or crush");
	}
	const chunks: Buffer[] = [];
	for await (const chunk of process.stdin) chunks.push(Buffer.from(chunk));
	const result = handleCommandHook(host, JSON.parse(Buffer.concat(chunks).toString("utf8")));
	if (result.stdout) process.stdout.write(result.stdout);
	if (result.stderr) process.stderr.write(`${result.stderr}\n`);
	process.exitCode = result.exitCode;
}

if (process.argv[1] && import.meta.url === pathToFileURL(process.argv[1]).href) {
	main().catch((error) => {
		process.stderr.write(`agent-context-kit: ${error instanceof Error ? error.message : String(error)}\n`);
		// Every supported PreToolUse command-hook host treats exit 2 as deny.
		process.exitCode = 2;
	});
}
