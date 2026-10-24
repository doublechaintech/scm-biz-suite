import { realpathSync } from "node:fs";
import { resolve } from "node:path";
import type { ExtensionAPI } from "@earendil-works/pi-coding-agent";
import { contextPolicyFeedback, contextPolicyInstruction, isContextPolicyBlock } from "../policy-feedback.ts";
import { checkContextAccess } from "../context-access.ts";

const FILE_TOOLS = new Set(["read", "grep", "find", "ls", "write", "edit"]);
const MEMORY_TYPE = "agent-context-kit-policy-denials-v1";

/** Counts are feedback only, never an authorization cache. Every tool still rechecks the filesystem policy. */
export function registerPiPolicyFeedback(pi: ExtensionAPI, projectRoot: string): void {
	const attempts = new Map<string, number>();
	pi.on("session_start", () => { attempts.clear(); });
	pi.on("tool_result", (event) => {
		// Never interpret returned file text or marker guidance as a host policy decision.
		if (!FILE_TOOLS.has(event.toolName) || !isContextPolicyBlock(event.details)) return undefined;
		const feedback = contextPolicyFeedback(event.details) as Record<string, unknown>;
		let scope = "outside-project";
		if (typeof feedback.blockedDirectory === "string") {
			try { scope = realpathSync(feedback.blockedDirectory); }
			catch { scope = resolve(feedback.blockedDirectory); }
		}
		const count = (attempts.get(scope) ?? 0) + 1;
		if (!attempts.has(scope) && attempts.size >= 128) attempts.delete(attempts.keys().next().value!);
		attempts.set(scope, count);
		feedback.attemptsForScope = count;
		if (count > 1) {
			feedback.previouslyBlocked = true;
			feedback.message = "Repeated policy denial for the same scope. Stop retrying this directory or its descendants. Continue with permitted documentation or report the blocker; do not attempt a workaround.";
			// First result already supplied project guidance; repeated denials stay small.
			delete feedback.guidance;
		}
		return { isError: true, details: feedback, content: [{ type: "text" as const, text: JSON.stringify(feedback) }] };
	});
	pi.on("context_with_system", (event) => {
		for (const scope of attempts.keys()) {
			try {
				if (scope !== "outside-project" && checkContextAccess(realpathSync(projectRoot), scope).status === "allow") attempts.delete(scope);
			} catch { /* Keep the denial reminder when the policy root is temporarily unavailable. */ }
		}
		if (!attempts.size) return undefined;
		return { messages: [...event.messages.filter((message) => !(message.role === "custom" && message.customType === MEMORY_TYPE)), {
			role: "custom" as const, customType: MEMORY_TYPE, display: false, timestamp: Date.now(),
			content: JSON.stringify({ source: "host_policy", instruction: contextPolicyInstruction,
				blockedScopes: [...attempts].slice(-16).map(([scope, count]) => ({ scope, attempts: count, retryable: false })) }),
		}] };
	});
}
