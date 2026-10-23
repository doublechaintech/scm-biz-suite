import { existsSync, realpathSync, statSync } from "node:fs";
import { basename, dirname, isAbsolute, relative, resolve, sep } from "node:path";

export type ReadGuardBashMode = "allow" | "literal" | "block";

export interface ReadGuardConfig {
	/** Base directory for relative protected paths. Defaults to the agent working directory. */
	workspaceRoot?: string;
	/** Directories or files the agent must not read. */
	paths: readonly string[];
	/** Guidance returned to the model when an access is blocked. */
	message: string;
	/** How to handle shell commands, which cannot be parsed perfectly. Default: literal. */
	bashMode?: ReadGuardBashMode;
}

export interface ReadGuardRequest {
	toolName: string;
	input: unknown;
	cwd?: string;
}

export interface ReadGuardDecision {
	toolName: string;
	requestedPath: string;
	protectedPath?: string;
	reason: string;
}

interface ProtectedPath {
	configured: string;
	absolute: string;
	canonical: string;
}

function record(value: unknown): Record<string, unknown> | undefined {
	return typeof value === "object" && value !== null ? (value as Record<string, unknown>) : undefined;
}

function canonicalPath(path: string): string {
	const absolute = resolve(path);
	let cursor = absolute;
	const missing: string[] = [];

	while (!existsSync(cursor)) {
		const parent = dirname(cursor);
		if (parent === cursor) return absolute;
		missing.unshift(basename(cursor));
		cursor = parent;
	}

	try {
		return resolve(realpathSync.native(cursor), ...missing);
	} catch {
		return absolute;
	}
}

function containsPath(parent: string, candidate: string): boolean {
	const remainder = relative(parent, candidate);
	return (
		remainder === "" ||
		(remainder !== ".." && !remainder.startsWith(`..${sep}`) && !isAbsolute(remainder))
	);
}

function isKnownDirectory(path: string): boolean {
	try {
		return statSync(path).isDirectory();
	} catch {
		return false;
	}
}

function escapeRegex(value: string): string {
	return value.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
}

function containsShellPath(command: string, path: string): boolean {
	if (!path || path === ".") return false;
	const escaped = escapeRegex(path.replaceAll("\\", "/"));
	const boundary = new RegExp(`(^|[\\s"'=;:(){}\\[\\],|&])${escaped}(?=$|[/\\s"'=;:(){}\\[\\],|&])`);
	return boundary.test(command.replaceAll("\\", "/"));
}

function pathInputs(input: unknown): string[] {
	const candidate = record(input);
	if (!candidate) return [];
	const paths: string[] = [];
	for (const key of ["path", "filePath", "file_path", "directory"] as const) {
		const value = candidate[key];
		if (typeof value === "string") paths.push(value);
	}
	for (const key of ["paths", "files", "file_paths"] as const) {
		const value = candidate[key];
		if (!Array.isArray(value)) continue;
		for (const item of value) {
			if (typeof item === "string") paths.push(item);
			else {
				const nested = record(item);
				if (typeof nested?.path === "string") paths.push(nested.path);
			}
		}
	}
	return paths;
}

function commandInput(input: unknown): string | undefined {
	const candidate = record(input);
	if (!candidate) return undefined;
	for (const key of ["command", "cmd"] as const) {
		const value = candidate[key];
		if (typeof value === "string") return value;
	}
	for (const key of ["commands"] as const) {
		const value = candidate[key];
		if (Array.isArray(value) && value.every((item) => typeof item === "string")) {
			return value.join("\n");
		}
	}
	return undefined;
}

function normalizedToolName(toolName: string): string {
	switch (toolName.toLowerCase()) {
		case "read_file":
		case "readfile":
		case "read_files":
		case "read_many_files":
		case "fs_read":
		case "view":
			return "read";
		case "list":
		case "list_directory":
		case "list_files":
			return "ls";
		case "glob":
			return "find";
		case "search":
		case "search_files":
		case "grep_search":
		case "rg":
			return "grep";
		case "shell":
		case "terminal":
		case "exec_command":
		case "execute_bash":
		case "run_commands":
		case "run_shell_command":
		case "powershell":
			return "bash";
		default:
			return toolName.toLowerCase();
	}
}

export function parseReadGuardConfig(value: unknown, source = "readGuard"): ReadGuardConfig {
	const candidate = record(value);
	if (!candidate) throw new Error(`${source} must be an object`);
	if (!Array.isArray(candidate.paths) || candidate.paths.length === 0) {
		throw new Error(`${source}.paths must be a non-empty string array`);
	}
	const paths = candidate.paths.map((path, index) => {
		if (typeof path !== "string" || path.trim().length === 0) {
			throw new Error(`${source}.paths[${index}] must be a non-empty string`);
		}
		return path;
	});
	if (typeof candidate.message !== "string" || candidate.message.trim().length === 0) {
		throw new Error(`${source}.message must be a non-empty string`);
	}
	if (
		candidate.workspaceRoot !== undefined &&
		typeof candidate.workspaceRoot !== "string"
	) {
		throw new Error(`${source}.workspaceRoot must be a string`);
	}
	if (
		candidate.bashMode !== undefined &&
		candidate.bashMode !== "allow" &&
		candidate.bashMode !== "literal" &&
		candidate.bashMode !== "block"
	) {
		throw new Error(`${source}.bashMode must be allow, literal, or block`);
	}

	return {
		paths,
		message: candidate.message,
		...(candidate.workspaceRoot === undefined
			? {}
			: { workspaceRoot: candidate.workspaceRoot }),
		...(candidate.bashMode === undefined ? {} : { bashMode: candidate.bashMode }),
	};
}

/**
 * Deterministic guard for Pi's built-in read-oriented tools.
 *
 * The guard is also useful outside Pi: adapters can pass their tool name and
 * input to `evaluate` and return the resulting reason to the model.
 */
export class ReadGuard {
	readonly workspaceRoot: string;
	readonly message: string;
	readonly bashMode: ReadGuardBashMode;
	private readonly protectedPaths: ProtectedPath[];

	constructor(config: ReadGuardConfig, defaultWorkspaceRoot = process.cwd()) {
		const parsed = parseReadGuardConfig(config);
		this.workspaceRoot = canonicalPath(
			parsed.workspaceRoot === undefined
				? defaultWorkspaceRoot
				: resolve(defaultWorkspaceRoot, parsed.workspaceRoot),
		);
		this.message = parsed.message.trim();
		this.bashMode = parsed.bashMode ?? "literal";
		this.protectedPaths = parsed.paths.map((configured) => {
			const absolute = resolve(this.workspaceRoot, configured);
			return { configured, absolute, canonical: canonicalPath(absolute) };
		});
	}

	evaluate(request: ReadGuardRequest): ReadGuardDecision | undefined {
		const cwd = canonicalPath(request.cwd ?? this.workspaceRoot);
		const toolName = normalizedToolName(request.toolName);
		if (toolName === "bash") return this.evaluateBash({ ...request, toolName }, cwd);

		const requestedPaths = pathInputs(request.input);
		if (requestedPaths.length === 0) requestedPaths.push(".");
		const recursiveTool = toolName === "find" || toolName === "grep";
		if (
			toolName !== "read" &&
			toolName !== "grep" &&
			toolName !== "find" &&
			toolName !== "ls"
		) {
			return undefined;
		}

		for (const requested of requestedPaths) {
			const candidate = canonicalPath(resolve(cwd, requested));
			const recursive = recursiveTool && isKnownDirectory(candidate);
			const matched = this.protectedPaths.find(
				(path) =>
					containsPath(path.canonical, candidate) ||
					(recursive && containsPath(candidate, path.canonical)),
			);
			if (!matched) continue;

			const relationship = containsPath(matched.canonical, candidate)
				? "targets"
				: "would recursively traverse";
			return {
				toolName: request.toolName,
				requestedPath: requested,
				protectedPath: matched.configured,
				reason: `Read blocked by agent-context-kit: ${request.toolName} ${relationship} protected path "${matched.configured}". ${this.message} Do not retry this protected path.`,
			};
		}
		return undefined;
	}

	private evaluateBash(request: ReadGuardRequest, cwd: string): ReadGuardDecision | undefined {
		if (this.bashMode === "allow") return undefined;
		const command = commandInput(request.input);
		if (typeof command !== "string") return undefined;

		if (this.bashMode === "block") {
			return {
				toolName: "bash",
				requestedPath: command,
				reason: `Shell command blocked by agent-context-kit while strict read protection is active. ${this.message} Use a scoped read, grep, find, or ls call instead.`,
			};
		}

		const cwdMatch = this.protectedPaths.find((path) => containsPath(path.canonical, cwd));
		if (cwdMatch) {
			return {
				toolName: "bash",
				requestedPath: command,
				protectedPath: cwdMatch.configured,
				reason: `Shell command blocked by agent-context-kit because its working directory is inside protected path "${cwdMatch.configured}". ${this.message} Leave this directory and do not retry the protected path.`,
			};
		}

		const matched = this.protectedPaths.find((path) => {
			const spellings = new Set([
				path.absolute,
				path.canonical,
				relative(cwd, path.absolute),
				relative(cwd, path.canonical),
			]);
			for (const spelling of [...spellings]) {
				if (spelling && !isAbsolute(spelling)) spellings.add(`./${spelling}`);
			}
			return [...spellings].some((spelling) => containsShellPath(command, spelling));
		});
		if (!matched) return undefined;

		return {
			toolName: "bash",
			requestedPath: command,
			protectedPath: matched.configured,
			reason: `Shell command blocked by agent-context-kit because it references protected path "${matched.configured}". ${this.message} Do not retry this protected path.`,
		};
	}
}
