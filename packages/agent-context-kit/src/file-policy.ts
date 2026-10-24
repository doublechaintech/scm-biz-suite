import { lstatSync, realpathSync, statSync } from "node:fs";
import { dirname, isAbsolute, relative, resolve, sep } from "node:path";
import { checkContextAccess, type ContextAccessDecision } from "./context-access.ts";

export type FileOperation = "create" | "overwrite" | "edit" | "delete" | "move";
export interface FilePolicyOptions {
	projectRoot: string;
	/** Explicit trusted host configuration. Empty by default: no agent writes. */
	writeRoots?: readonly string[];
	/** Independent of read exclusion; includes generated libraries and policy manifests. */
	readOnlyPaths?: readonly string[];
}
export type FileMutationDecision =
	| { status: "allow"; paths: string[] }
	| { status: "denied" | "outOfScope" | "policyError"; reason: string };

const CONTROL_NAMES = new Set([
	".git", ".pi", ".opencode", ".agents", ".codex", ".claude", ".agent-context-kit.json",
	".agent-context-kit.md", ".agent-no-read.md", ".agent-no-write.md", "context-markers.json",
	"AGENTS.md", "AGENTS.override.md", "AGENTS.MD", "CLAUDE.md", "CLAUDE.MD",
	"SYSTEM.md", "APPEND_SYSTEM.md",
]);
function contains(root: string, path: string): boolean {
	if (process.platform === "darwin" || process.platform === "win32") { root = root.toLowerCase(); path = path.toLowerCase(); }
	const part = relative(root, path);
	return part === "" || (!isAbsolute(part) && part !== ".." && !part.startsWith(`..${sep}`));
}
function validPath(path: unknown): path is string {
	return typeof path === "string" && !!path.trim() && !path.includes("\0");
}

/** Host-independent policy. Read markers never implicitly grant or revoke write access. */
export class FileAccessPolicy {
	readonly root: string;
	private readonly realRoot: string;
	private readonly writeRoots: readonly string[];
	private readonly readOnlyPaths: readonly string[];
	constructor(options: FilePolicyOptions) {
		if (!validPath(options.projectRoot) || !isAbsolute(options.projectRoot)) throw new Error("Project root must be absolute");
		this.root = resolve(options.projectRoot);
		if (!statSync(this.root).isDirectory()) throw new Error("Project root must be a directory");
		this.realRoot = realpathSync(this.root);
		const paths = (values: readonly string[] = []) => Object.freeze(values.map((value) => {
			if (!validPath(value)) throw new Error("Invalid policy path");
			const path = resolve(this.root, value);
			if (!contains(this.root, path)) throw new Error("Policy paths must remain inside the project");
			return path;
		}));
		this.writeRoots = paths(options.writeRoots);
		this.readOnlyPaths = paths(options.readOnlyPaths);
	}

	checkRead(path: string): ContextAccessDecision {
		return checkContextAccess(this.root, path);
	}

	/** Both move endpoints are validated before any mutation. Directory mutations are unsupported. */
	checkMutation(operation: FileOperation, path: string, destination?: string): FileMutationDecision {
		if (!["create", "overwrite", "edit", "delete", "move"].includes(operation) || !validPath(path) ||
			(operation === "move" ? !validPath(destination) : destination !== undefined)) {
			return { status: "policyError", reason: "Invalid file operation or path." };
		}
		const targets = operation === "move" ? [path, destination!] : [path];
		const checked: string[] = [];
		try {
			if (realpathSync(this.root) !== this.realRoot) throw new Error("Root changed");
			for (const [index, target] of targets.entries()) {
				const absolute = resolve(this.root, target);
				if (!contains(this.root, absolute)) return { status: "outOfScope", reason: "File operation is outside the project." };
				const parts = relative(this.root, absolute).split(sep);
				if (parts.some((part) => [...CONTROL_NAMES].some((name) => name.toLowerCase() === part.toLowerCase())) || this.readOnlyPaths.some((path) => contains(path, absolute))) {
					return { status: "denied", reason: "Generated or control paths are read-only to the agent." };
				}
				if (!this.writeRoots.some((path) => contains(path, absolute))) {
					return { status: "denied", reason: "File is outside the host-approved write roots." };
				}
				// Reject symlink writes, including ancestor links and dangling links. No mkdir side effects.
				let cursor = this.root;
				let exists = true;
				for (const part of parts) {
					cursor = resolve(cursor, part);
					try {
						const info = lstatSync(cursor);
						if (info.isSymbolicLink() || (cursor !== absolute && !info.isDirectory())) throw new Error("Unsupported path");
						if (cursor === absolute && !info.isFile()) throw new Error("Only ordinary files may be mutated");
					} catch (error) {
						if ((error as NodeJS.ErrnoException).code !== "ENOENT" || cursor !== absolute) throw error;
						exists = false;
					}
				}
				if (!contains(this.realRoot, realpathSync(dirname(absolute)))) throw new Error("Invalid parent");
				const mustBeNew = operation === "create" || (operation === "move" && index === 1);
				if (mustBeNew === exists) return { status: "denied", reason: mustBeNew ? "Destination already exists." : "Source file does not exist." };
				if (operation === "edit" || operation === "overwrite" || (operation === "move" && index === 0)) {
					const read = this.checkRead(absolute);
					if (read.status !== "allow") return { status: "denied", reason: "Editing existing content requires read permission." };
				}
				checked.push(absolute);
			}
			return { status: "allow", paths: checked };
		} catch {
			return { status: "policyError", reason: "Unable to validate file operation; no mutation is permitted." };
		}
	}
}
