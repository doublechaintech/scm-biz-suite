import { lstatSync, realpathSync } from "node:fs";
import { resolve } from "node:path";
import { ContextAccessDenied, ContextFiles } from "./context-files.ts";

const AGENTS_NAMES = ["AGENTS.override.md", "AGENTS.md", "AGENTS.MD", "CLAUDE.md", "CLAUDE.MD"];

/** Checked afresh at every provider request; no pre-read files or cached source bodies. */
export function loadContextPolicyFiles(projectRoot: string, additionalPaths: readonly string[] = []) {
	const files = new ContextFiles(projectRoot);
	const context: Array<{ path: string; content: string }> = [];
	const skipped: unknown[] = [];
	const rootDecision = files.check(".");
	if (rootDecision.status !== "allow") return { source: "project_file_data" as const, context, skipped: [rootDecision] };
	const paths: string[] = [];
	for (const name of AGENTS_NAMES) {
		const decision = files.check(name);
		if (decision.status === "excluded" || decision.status === "outOfScope") { skipped.push(decision); break; }
		try {
			if (lstatSync(resolve(files.root, name)).isFile() || lstatSync(resolve(files.root, name)).isSymbolicLink()) {
				paths.push(name); break;
			}
		} catch (error) {
			if ((error as NodeJS.ErrnoException).code !== "ENOENT") { skipped.push(decision); break; }
		}
	}
	paths.push(...additionalPaths);
	let remaining = 64 * 1024;
	const seen = new Set<string>();
	const seenMarkers = new Set<string>();
	for (const path of paths.slice(0, 32)) {
		try {
			const decision = files.require(path);
			if (seen.has(decision.realPath)) continue;
			seen.add(decision.realPath);
			const body = files.read(path, Math.min(32 * 1024, remaining));
			const content = new TextDecoder("utf-8", { fatal: true }).decode(body);
			context.push({ path: decision.path, content });
			remaining -= body.byteLength;
		} catch (error) {
			const denial = error instanceof ContextAccessDenied ? error.decision : { status: "policyError" };
			const key = "markerPath" in denial ? realpathSync(resolve(denial.markerPath, "..")) : denial.status;
			if (seenMarkers.has(key) || skipped.length >= 5) continue;
			seenMarkers.add(key);
			// Explicit configured paths may be denied, but descendant names need not be returned.
			skipped.push("markerPath" in denial ? {
				status: denial.status, markerPath: denial.markerPath, source: denial.source,
				reason: denial.reason, guidance: denial.guidance,
			} : { status: denial.status });
		}
	}
	return { source: "project_file_data" as const, context, skipped };
}
