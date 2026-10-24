import { realpathSync, statSync } from "node:fs";
import { createHash } from "node:crypto";
import { resolve } from "node:path";
import type { ExtensionAPI } from "@earendil-works/pi-coding-agent";
import { contextPolicyFeedback, contextPolicyInstruction, isContextPolicyBlock, isContextToolFailure } from "../policy-feedback.ts";
import { checkContextAccess } from "../context-access.ts";

const FILE_TOOLS = new Set(["read", "grep", "find", "ls", "write", "edit"]);
const MEMORY_TYPE = "agent-context-kit-policy-denials-v1";

/** Counts are feedback only, never an authorization cache. Every tool still rechecks the filesystem policy. */
export function registerPiPolicyFeedback(pi: ExtensionAPI, projectRoot: string): void {
	const attempts = new Map<string, { count: number; policy: boolean; path?: string; fingerprint?: string; tool: string; code: unknown }>();
	const fingerprint = (path: string) => { try { const info = statSync(path); return `${info.dev}:${info.ino}:${info.size}:${info.mtimeMs}`; } catch { return "unavailable"; } };
	const canonical = (path: string) => { try { return realpathSync(path); } catch { return resolve(path); } };
	pi.on("session_start", () => { attempts.clear(); });
	pi.on("tool_result", (event) => {
		// Never interpret returned file text or marker guidance as a host policy decision.
		if (!FILE_TOOLS.has(event.toolName)) return undefined;
		if (!isContextToolFailure(event.details)) {
			// A successful corrected operation clears only its request/file reminders.
			for (const [key, record] of attempts) if (!record.policy && record.tool === event.toolName && (!record.path || (typeof event.input?.path === "string" && record.path === canonical(resolve(projectRoot, event.input?.path))))) attempts.delete(key);
			return undefined;
		}
		const feedback = contextPolicyFeedback(event.details) as Record<string, unknown>;
		const policy = isContextPolicyBlock(event.details);
		let scope = "outside-project";
		let path: string | undefined;
		if (typeof feedback.blockedDirectory === "string") {
			scope = canonical(feedback.blockedDirectory);
		} else if (!policy) {
			const target = typeof feedback.path === "string" ? feedback.path : typeof event.input?.path === "string" ? event.input?.path : undefined;
			if (target) { path = canonical(resolve(projectRoot, target)); scope = `file:${path}`; }
			else scope = `request:${event.toolName}:${createHash("sha256").update(JSON.stringify(event.input ?? {})).digest("hex").slice(0, 16)}`;
		}
		const previous = attempts.get(scope);
		const stamp = path ? fingerprint(path) : undefined;
		const count = (previous && (!path || previous.fingerprint === stamp) ? previous.count : 0) + 1;
		if (!attempts.has(scope) && attempts.size >= 128) attempts.delete(attempts.keys().next().value!);
		attempts.set(scope, { count, policy, ...(path ? { path, fingerprint: stamp! } : {}), tool: event.toolName, code: feedback.code });
		feedback.attemptsForScope = count;
		if (count > 1) {
			feedback.previouslyBlocked = true;
			feedback.message = policy ? "Repeated policy denial for the same scope. Stop retrying this directory or its descendants. Continue with permitted documentation or report the blocker; do not attempt a workaround." : "Repeated failure for the same unchanged file/request. Stop reading it again. For compiler errors call app_build; for test results call app_test when registered. Otherwise correct the input or report the blocker. Binary executables are not diagnostic logs.";
			// First result already supplied project guidance; repeated denials stay small.
			delete feedback.guidance;
		}
		return { isError: true, details: feedback, content: [{ type: "text" as const, text: JSON.stringify(feedback) }] };
	});
	pi.on("context_with_system", (event) => {
		for (const [scope, record] of attempts) {
			try {
				if (record.policy && scope !== "outside-project" && checkContextAccess(realpathSync(projectRoot), scope).status === "allow") attempts.delete(scope);
				if (!record.policy && record.path && fingerprint(record.path) !== record.fingerprint) attempts.delete(scope);
			} catch { /* Keep the denial reminder when the policy root is temporarily unavailable. */ }
		}
		if (!attempts.size) return undefined;
		return { messages: [...event.messages.filter((message) => !(message.role === "custom" && message.customType === MEMORY_TYPE)), {
			role: "custom" as const, customType: MEMORY_TYPE, display: false, timestamp: Date.now(),
			content: JSON.stringify({ source: "host_policy", instruction: contextPolicyInstruction,
				blockedScopes: [...attempts].slice(-16).map(([scope, record]) => ({ scope, attempts: record.count, code: record.code, retryable: false })) }),
		}] };
	});
}
