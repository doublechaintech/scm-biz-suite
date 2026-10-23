import { spawn } from "node:child_process";
import { dirname, isAbsolute, relative, resolve, sep } from "node:path";
import { realpathSync, statSync } from "node:fs";
import { StringDecoder } from "node:string_decoder";

import { checkContextAccess } from "./context-access.ts";
import { ContextFiles } from "./context-files.ts";

export type ControlledTaskName = "build" | "test";
export interface ControlledTaskCommand {
	/** Trusted host configuration only; never supplied by a tool call or marker body. */
	executable: string;
	args?: readonly string[];
	timeoutMs?: number;
	maxOutputBytes?: number;
	/** Fixed descriptions keyed by known diagnostic codes; child-provided messages are never echoed. */
	diagnosticSummaries?: Readonly<Record<string, string>>;
	includeAllowedSource?: boolean;
}
export type ControlledTaskCommands = Readonly<Partial<Record<ControlledTaskName, ControlledTaskCommand>>>;
interface DiagnosticRecord {
	path?: string;
	line?: number;
	column?: number;
	code?: string;
	severity: "error" | "warning" | "info";
}
export interface ControlledDiagnostic {
	severity: DiagnosticRecord["severity"];
	code?: string;
	summary: string;
	access: "allow" | "excluded" | "outOfScope" | "policyError" | "noLocation";
	location?: { path: string; line?: number; column?: number };
	source?: Array<{ line: number; text: string }>;
}
export interface ControlledTaskResult {
	task: ControlledTaskName;
	status: "passed" | "failed" | "cancelled" | "timedOut" | "outputLimit" | "executionError";
	exitCode: number | null;
	summary: string;
	diagnostics: ControlledDiagnostic[];
	exclusions: Array<{ markerPath: string; source: "project_marker_data"; reason: string; guidance: string }>;
	tests?: { passed: number; failed: number; skipped: number };
	diagnosticsTruncated: boolean;
	unstructuredOutputSuppressed: true;
}

const DEFAULT_SUMMARIES: Readonly<Record<string, string>> = Object.freeze({
	TS1005: "Required syntax is missing.",
	TS2307: "A referenced module or its type declarations could not be found.",
	TS2322: "A value's type is not assignable to the expected type.",
	TS2339: "The requested property does not exist on this type.",
	TS2345: "An argument's type does not match the parameter type.",
	TEST_FAILURE: "A test failed.",
	BUILD_FAILURE: "A build step failed.",
});
const MAX_DIAGNOSTICS = 64;
const MAX_LINE_BYTES = 64 * 1024;

function integer(value: unknown, minimum = 0): value is number {
	return typeof value === "number" && Number.isSafeInteger(value) && value >= minimum && value <= 1_000_000_000;
}

function bounded(value: number | undefined, fallback: number, maximum: number): number {
	if (value === undefined) return fallback;
	if (!Number.isInteger(value) || value < 1 || value > maximum) throw new Error("Invalid controlled task limit");
	return value;
}

/** Snapshot trusted configuration. There is no project config discovery or shell command parsing. */
export function snapshotTaskCommand(command: ControlledTaskCommand): ControlledTaskCommand {
	if (!command || typeof command.executable !== "string" || !command.executable.trim() || command.executable.includes("\0")) {
		throw new Error("Controlled task requires a fixed executable");
	}
	if (command.args !== undefined && (!Array.isArray(command.args) || command.args.some((arg) => typeof arg !== "string" || arg.includes("\0")))) {
		throw new Error("Controlled task arguments must be fixed strings");
	}
	if (command.includeAllowedSource !== undefined && typeof command.includeAllowedSource !== "boolean") {
		throw new Error("includeAllowedSource must be boolean");
	}
	const summaries: Record<string, string> = Object.create(null);
	if (command.diagnosticSummaries !== undefined) {
		if (typeof command.diagnosticSummaries !== "object" || command.diagnosticSummaries === null || Array.isArray(command.diagnosticSummaries)) {
			throw new Error("Diagnostic summaries must be a trusted code-to-description map");
		}
		for (const [code, summary] of Object.entries(command.diagnosticSummaries)) {
			if (!/^[A-Z0-9_]{1,32}$/.test(code) || typeof summary !== "string" || !summary.trim() || Buffer.byteLength(summary) > 512) {
				throw new Error("Invalid trusted diagnostic summary");
			}
			summaries[code] = summary;
		}
	}
	return Object.freeze({
		executable: command.executable, args: Object.freeze([...(command.args ?? [])]),
		timeoutMs: bounded(command.timeoutMs, 120_000, 900_000),
		maxOutputBytes: bounded(command.maxOutputBytes, 1024 * 1024, 16 * 1024 * 1024),
		diagnosticSummaries: Object.freeze(summaries), includeAllowedSource: command.includeAllowedSource ?? false,
	});
}

/** Accept only protocol fields; arbitrary messages, excerpts, test names and nested objects are discarded. */
class TaskProtocol {
	readonly diagnostics: DiagnosticRecord[] = [];
	tests: ControlledTaskResult["tests"];
	truncated = false;
	hasErrors = false;
	private decoder = new StringDecoder("utf8");
	private pending = "";
	private droppingLine = false;

	push(chunk: Buffer) {
		const text = this.decoder.write(chunk);
		for (const part of text.match(/[^\n]*\n|[^\n]+$/g) ?? []) {
			if (!this.droppingLine) {
				if (Buffer.byteLength(this.pending) + Buffer.byteLength(part) > MAX_LINE_BYTES) {
					this.pending = ""; this.droppingLine = true;
				} else this.pending += part;
			}
			if (part.endsWith("\n")) {
				if (!this.droppingLine) this.parse(this.pending);
				this.pending = ""; this.droppingLine = false;
			}
		}
	}

	finish() {
		const tail = this.decoder.end();
		if (!this.droppingLine) this.parse(this.pending + tail);
		this.pending = "";
	}

	private parse(line: string) {
		let data: Record<string, unknown>;
		try {
			const value: unknown = JSON.parse(line);
			if (typeof value !== "object" || value === null || Array.isArray(value)) return;
			data = value as Record<string, unknown>;
		} catch { return; }
		if (data.version !== 1) return;
		if (data.type === "testSummary" && integer(data.passed) && integer(data.failed) && integer(data.skipped)) {
			this.tests = { passed: data.passed, failed: data.failed, skipped: data.skipped };
		}
		if (data.type !== "diagnostic") return;
		if (data.severity !== "warning" && data.severity !== "info") this.hasErrors = true;
		if (this.diagnostics.length >= MAX_DIAGNOSTICS) { this.truncated = true; return; }
		this.diagnostics.push({
			severity: data.severity === "warning" || data.severity === "info" ? data.severity : "error",
			...(typeof data.code === "string" && /^[A-Z0-9_]{1,32}$/.test(data.code) ? { code: data.code } : {}),
			...(typeof data.path === "string" && data.path.length <= 4096 && !/[\0\r\n]/.test(data.path) ? { path: data.path } : {}),
			...(integer(data.line, 1) ? { line: data.line } : {}),
			...(integer(data.column, 1) ? { column: data.column } : {}),
		});
	}
}

function renderDiagnostics(root: string, command: ControlledTaskCommand, protocol: TaskProtocol) {
	const files = new ContextFiles(root);
	const summaries = { ...DEFAULT_SUMMARIES, ...command.diagnosticSummaries };
	const exclusions: ControlledTaskResult["exclusions"] = [];
	const seenMarkers = new Set<string>();
	const diagnostics: ControlledDiagnostic[] = protocol.diagnostics.map((record) => {
		const code = record.code && Object.hasOwn(summaries, record.code) ? record.code : undefined;
		const diagnostic: ControlledDiagnostic = {
			severity: record.severity, ...(code ? { code } : {}),
			summary: code ? summaries[code]! : "The command reported a diagnostic; no registered description is available.",
			access: "noLocation",
		};
		if (!record.path) return diagnostic;
		let path = resolve(root, record.path);
		// Compilers may report canonical absolute paths when the configured root is a symlink.
		try {
			const canonicalRoot = realpathSync(root);
			const suffix = relative(canonicalRoot, path);
			const requestedSuffix = relative(root, path);
			const inside = (value: string) => value === "" || (value !== ".." && !value.startsWith(`..${sep}`) && !isAbsolute(value));
			if (isAbsolute(record.path) && !inside(requestedSuffix) && inside(suffix)) path = resolve(root, suffix);
		} catch { /* The policy check below will fail closed. */ }
		const decision = checkContextAccess(root, path);
		diagnostic.access = decision.status === "allow" ? "allow" : decision.status;
		if (decision.status !== "allow" && decision.status !== "excluded") return diagnostic;
		// Retain real file locations only, never echo an arbitrary process string as a location.
		try { if (!statSync(path).isFile()) return diagnostic; } catch { return diagnostic; }
		diagnostic.location = {
			path: relative(root, path).split(sep).join("/"),
			...(record.line ? { line: record.line } : {}), ...(record.column ? { column: record.column } : {}),
		};
		if (decision.status === "excluded") {
			const markerKey = realpathSync(dirname(decision.markerPath));
			if (!seenMarkers.has(markerKey) && exclusions.length < 5) {
				seenMarkers.add(markerKey);
				exclusions.push({ markerPath: decision.markerPath, source: decision.source, reason: decision.reason, guidance: decision.guidance });
			}
			return diagnostic;
		}
		if (command.includeAllowedSource && record.line) {
			try {
				const lines = new TextDecoder("utf-8", { fatal: true }).decode(files.read(path)).split(/\r\n|\n|\r/);
				diagnostic.source = [];
				for (let index = Math.max(0, record.line - 2); index < Math.min(lines.length, record.line + 1); index++) {
					diagnostic.source.push({ line: index + 1, text: lines[index]!.slice(0, 200) });
				}
			} catch {
				// Permission errors, new markers and unsupported files omit source, not the outcome.
				delete diagnostic.source;
			}
		}
		return diagnostic;
	});
	return { diagnostics, exclusions };
}

/** Runs a fixed trusted command with full project access; raw output never leaves this boundary. */
export async function runControlledTask(
	projectRoot: string,
	task: ControlledTaskName,
	configuration: ControlledTaskCommand,
	signal?: AbortSignal,
): Promise<ControlledTaskResult> {
	if (!isAbsolute(projectRoot)) throw new Error("Project root must be absolute");
	if (task !== "build" && task !== "test") throw new Error("Unknown controlled task");
	const root = resolve(projectRoot);
	const command = snapshotTaskCommand(configuration);
	const protocol = new TaskProtocol();
	let outcome: ControlledTaskResult["status"] | undefined;
	let exitCode: number | null = null;
	if (signal?.aborted) outcome = "cancelled";
	else await new Promise<void>((done) => {
		let child: ReturnType<typeof spawn>;
		let timer: ReturnType<typeof setTimeout>;
		let killTimer: ReturnType<typeof setTimeout> | undefined;
		let bytes = 0;
		let finished = false;
		const kill = (force = false) => {
			if (!child?.pid) return;
			try {
				if (process.platform !== "win32") process.kill(-child.pid, force ? "SIGKILL" : "SIGTERM");
				else child.kill(force ? "SIGKILL" : "SIGTERM");
			} catch { /* The process group may already have exited. */ }
		};
		const stop = (status: ControlledTaskResult["status"]) => {
			outcome ??= status;
			kill();
			killTimer ??= setTimeout(() => kill(true), 250);
		};
		const abort = () => stop("cancelled");
		const finish = () => {
			if (finished) return;
			finished = true;
			clearTimeout(timer);
			// Also terminate any descendants left holding pipes by a cancelled command.
			if (killTimer) { clearTimeout(killTimer); kill(true); }
			signal?.removeEventListener("abort", abort);
			protocol.finish();
			done();
		};
		try {
			// Node's test-runner transport flag must not turn a nested fixed test command into an IPC child.
			const { NODE_TEST_CONTEXT: _testContext, ...environment } = process.env;
			child = spawn(command.executable, [...command.args!], {
				env: environment,
				cwd: root, shell: false, detached: process.platform !== "win32", stdio: ["ignore", "pipe", "pipe"], windowsHide: true,
			});
		} catch { outcome = "executionError"; finish(); return; }
		child.once("error", () => { outcome ??= "executionError"; finish(); });
		child.once("close", (code) => { exitCode = code; finish(); });
		const consume = (chunk: Buffer, diagnostics: boolean) => {
			bytes += chunk.length;
			if (bytes > command.maxOutputBytes!) { stop("outputLimit"); return; }
			if (!outcome && diagnostics) protocol.push(chunk);
		};
		child.stdout?.on("data", (chunk: Buffer) => consume(chunk, true));
		child.stderr?.on("data", (chunk: Buffer) => consume(chunk, false));
		timer = setTimeout(() => stop("timedOut"), command.timeoutMs);
		signal?.addEventListener("abort", abort, { once: true });
		if (signal?.aborted) abort();
	});
	outcome ??= exitCode === 0 && !protocol.hasErrors && !protocol.tests?.failed ? "passed" : "failed";
	const summaries: Record<ControlledTaskResult["status"], string> = {
		passed: "The configured command completed successfully.", failed: "The configured command failed.",
		cancelled: "The configured command was cancelled.", timedOut: "The configured command exceeded its time limit.",
		outputLimit: "The configured command exceeded its output limit.", executionError: "The configured command could not be executed.",
	};
	return {
		task, status: outcome, exitCode, summary: summaries[outcome], ...renderDiagnostics(root, command, protocol),
		...(protocol.tests ? { tests: protocol.tests } : {}), diagnosticsTruncated: protocol.truncated, unstructuredOutputSuppressed: true,
	};
}
