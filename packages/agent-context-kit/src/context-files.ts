import { closeSync, constants, fstatSync, lstatSync, openSync, readdirSync, readSync, realpathSync, statSync } from "node:fs";
import { basename, isAbsolute, matchesGlob, relative, resolve, sep } from "node:path";

import { checkContextAccess, type ContextAccessDecision } from "./context-access.ts";

export type ContextDenial = Exclude<ContextAccessDecision, { status: "allow" }>;
export interface ContextSkipped {
	status: ContextDenial["status"];
	markerPath?: string;
	source?: "project_marker_data";
	reason?: string;
	guidance?: string;
}
export interface ContextSearchOptions {
	path?: string;
	pattern: string;
	limit?: number;
	signal?: AbortSignal;
}
export interface ContextGrepOptions extends ContextSearchOptions {
	glob?: string;
	literal?: boolean;
	ignoreCase?: boolean;
	context?: number;
}
export interface ContextMatch {
	path: string;
	line: number;
	text: string;
	context: Array<{ line: number; text: string }>;
}

const MAX_RESULTS = 1000;
const MAX_FILE_BYTES = 2 * 1024 * 1024;
const MAX_TEXT = 32 * 1024;
const MAX_SKIPPED = 5;

function limit(value: number | undefined, fallback = 100): number {
	return Number.isFinite(value) ? Math.max(1, Math.min(MAX_RESULTS, Math.floor(value!))) : fallback;
}

function glob(path: string, pattern: string): boolean {
	return matchesGlob(path, pattern) || (!pattern.includes("/") && matchesGlob(basename(path), pattern));
}

function failure(path: string): ContextDenial {
	return { status: "policyError", path, reason: "Unable to access context file; content must not be returned." };
}

export class ContextAccessDenied extends Error {
	readonly decision: ContextDenial;
	constructor(decision: ContextDenial) {
		super(decision.status);
		this.decision = decision;
	}
}

/** Local context-only filesystem. No result cache, shell, ignore-rule overrides or target-source logging. */
export class ContextFiles {
	readonly root: string;
	constructor(projectRoot: string) {
		if (!isAbsolute(projectRoot)) throw new Error("Project root must be absolute");
		this.root = resolve(projectRoot);
	}

	check(path: string): ContextAccessDecision {
		return checkContextAccess(this.root, path);
	}

	require(path: string): Extract<ContextAccessDecision, { status: "allow" }> {
		const decision = this.check(path);
		if (decision.status !== "allow") throw new ContextAccessDenied(decision);
		return decision;
	}

	/** A bounded ordinary-file read; also used by automatic context loading. */
	read(path: string, maxBytes = MAX_FILE_BYTES): Buffer {
		const decision = this.require(path);
		let fd: number | undefined;
		try {
			if (!statSync(decision.path).isFile()) throw new Error("Unsupported context file");
			fd = openSync(decision.path, constants.O_RDONLY | constants.O_NONBLOCK);
			const info = fstatSync(fd);
			if (!info.isFile() || info.size > maxBytes) throw new Error("Unsupported context file");
			const buffer = Buffer.alloc(Math.min(info.size + 1, maxBytes + 1));
			let length = 0;
			while (length < buffer.length) {
				const count = readSync(fd, buffer, length, buffer.length - length, null);
				if (!count) break;
				length += count;
			}
			if (length > maxBytes) throw new Error("Context file too large");
			this.require(path);
			return buffer.subarray(0, length);
		} catch (error) {
			if (error instanceof ContextAccessDenied) throw error;
			throw new ContextAccessDenied(failure(decision.path));
		} finally {
			if (fd !== undefined) closeSync(fd);
		}
	}

	private summary() {
		const skipped: ContextSkipped[] = [];
		const seen = new Set<string>();
		const add = (decision: ContextDenial) => {
			const key = decision.status === "excluded"
				? realpathSync(resolve(decision.markerPath, ".."))
				: decision.status;
			if (seen.has(key) || skipped.length >= MAX_SKIPPED) return;
			seen.add(key);
			// Never report descendant names or counts from excluded subtrees.
			skipped.push(decision.status === "excluded"
				? { status: decision.status, markerPath: decision.markerPath, source: decision.source, reason: decision.reason, guidance: decision.guidance }
				: { status: decision.status });
		};
		return { skipped, add };
	}

	private *walk(path: string, skip: (decision: ContextDenial) => void, signal?: AbortSignal): Generator<string> {
		const visited = new Set<string>();
		const visit = function* (files: ContextFiles, path: string): Generator<string> {
			signal?.throwIfAborted();
			const decision = files.check(path);
			if (decision.status !== "allow") { skip(decision); return; }
			try {
				const info = statSync(decision.path);
				if (info.isFile()) { yield decision.path; return; }
				if (!info.isDirectory() || visited.has(decision.realPath)) return;
				visited.add(decision.realPath);
				// Policy is checked before readdir, never after enumerating a protected subtree.
				files.require(decision.path);
				for (const name of readdirSync(decision.path).sort()) {
					yield* visit(files, resolve(decision.path, name));
				}
			} catch (error) {
				if (signal?.aborted) throw error;
				skip(error instanceof ContextAccessDenied ? error.decision : failure(decision.path));
			}
		};
		yield* visit(this, path);
	}

	find(options: ContextSearchOptions) {
		const start = this.check(options.path ?? ".");
		if (start.status !== "allow") return start;
		const { skipped, add } = this.summary();
		const paths: string[] = [];
		let truncated = false;
		for (const path of this.walk(start.path, add, options.signal)) {
			const name = relative(start.path, path).split(sep).join("/") || basename(path);
			if (!glob(name, options.pattern)) continue;
			if (paths.length >= limit(options.limit)) { truncated = true; break; }
			paths.push(path);
		}
		return {
			status: "ok" as const,
			files: paths.filter((path) => {
				const decision = this.check(path);
				if (decision.status === "allow") return true;
				add(decision); return false;
			}).map((path) => relative(this.root, path).split(sep).join("/")),
			skipped, truncated,
		};
	}

	grep(options: ContextGrepOptions) {
		const start = this.check(options.path ?? ".");
		if (start.status !== "allow") return start;
		let expression: RegExp;
		try {
			expression = new RegExp(options.literal ? options.pattern.replace(/[.*+?^${}()|[\]\\]/g, "\\$&") : options.pattern, options.ignoreCase ? "i" : "");
		} catch {
			return { status: "invalidPattern" as const, reason: "Use a valid JavaScript regular expression or literal=true." };
		}
		const { skipped, add } = this.summary();
		const matches: ContextMatch[] = [];
		let remaining = MAX_TEXT;
		let truncated = false;
		const radius = Number.isFinite(options.context) ? Math.max(0, Math.min(10, Math.floor(options.context!))) : 0;
		outer: for (const path of this.walk(start.path, add, options.signal)) {
			const name = relative(start.path, path).split(sep).join("/") || basename(path);
			if (options.glob && !glob(name, options.glob)) continue;
			let body: Buffer;
			try { body = this.read(path); } catch (error) {
				add(error instanceof ContextAccessDenied ? error.decision : failure(path)); continue;
			}
			if (body.includes(0)) continue;
			const lines = body.toString("utf8").split(/\r\n|\n|\r/);
			for (let index = 0; index < lines.length; index++) {
				options.signal?.throwIfAborted();
				if (!expression.test(lines[index]!)) continue;
				if (matches.length >= limit(options.limit) || remaining <= 0) { truncated = true; break outer; }
				const clip = (text: string) => {
					const result = text.slice(0, Math.min(500, remaining));
					remaining -= result.length;
					return result;
				};
				const text = clip(lines[index]!);
				const context: ContextMatch["context"] = [];
				for (let i = Math.max(0, index - radius); i <= Math.min(lines.length - 1, index + radius) && remaining > 0; i++) {
					if (i !== index) context.push({ line: i + 1, text: clip(lines[i]!) });
				}
				matches.push({ path: relative(this.root, path).split(sep).join("/"), line: index + 1, text, context });
			}
		}
		return {
			status: "ok" as const,
			matches: matches.filter((match) => {
				const decision = this.check(match.path);
				if (decision.status === "allow") return true;
				add(decision); return false;
			}),
			skipped, truncated,
		};
	}

	list(path = ".", requestedLimit?: number) {
		const start = this.check(path);
		if (start.status !== "allow") return start;
		try {
			if (!statSync(start.path).isDirectory()) return failure(start.path);
			const names = readdirSync(start.path).sort();
			const entries = names.slice(0, limit(requestedLimit)).map((name) => {
				const target = resolve(start.path, name);
				const decision = this.check(target);
				if (decision.status !== "allow") return { name, ...decision };
				return { name, status: "allow" as const, kind: lstatSync(target).isSymbolicLink() ? "symlink" : statSync(target).isDirectory() ? "directory" : "file" };
			});
			this.require(path);
			return { status: "ok" as const, entries, truncated: names.length > entries.length };
		} catch (error) {
			return error instanceof ContextAccessDenied ? error.decision : failure(start.path);
		}
	}
}
