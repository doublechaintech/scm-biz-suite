import {
	closeSync, constants, fstatSync, lstatSync, mkdirSync, openSync, readSync, realpathSync,
	renameSync, rmSync, writeFileSync,
} from "node:fs";
import { randomUUID } from "node:crypto";
import { dirname, isAbsolute, relative, resolve, sep } from "node:path";

import { contextAccessLimits, contextAccessMarker } from "./context-access.ts";
import { runControlledTask, snapshotTaskCommand, type ControlledTaskCommand, type ControlledTaskResult } from "./controlled-tasks.ts";

export class ContextMarkerError extends Error {
	readonly code: "invalidManifest" | "unsafePath" | "maintenanceFailed";
	constructor(code: ContextMarkerError["code"]) {
		const messages = {
			invalidManifest: "The marker manifest or guidance source is invalid.",
			unsafePath: "Marker maintenance requires stable in-project paths without target symlinks.",
			maintenanceFailed: "Marker maintenance could not complete; verify marker state before continuing.",
		};
		super(messages[code]);
		this.code = code;
	}
}

export interface ContextMarkerEntry {
	marker: string;
	status: "created" | "updated" | "unchanged" | "missing" | "outdated";
}
export interface ContextMarkerReport {
	status: "ok" | "needsUpdate";
	markers: ContextMarkerEntry[];
}
export interface ContextMarkerGenerationReport {
	status: "ok" | "generationFailed" | "maintenanceFailed";
	markers: ContextMarkerEntry[];
	generator?: { status: ControlledTaskResult["status"]; exitCode: number | null };
}
interface MarkerPlan {
	root: string;
	canonicalRoot: string;
	markers: ReadonlyArray<{ directory: string; body: Buffer }>;
	generator?: ControlledTaskCommand;
}

function inside(root: string, path: string) {
	const part = relative(root, path);
	return part === "" || (part !== ".." && !part.startsWith(`..${sep}`) && !isAbsolute(part));
}
function missing(error: unknown) {
	return (error as NodeJS.ErrnoException).code === "ENOENT";
}
function object(value: unknown): value is Record<string, unknown> {
	return typeof value === "object" && value !== null && !Array.isArray(value);
}
function localPath(root: string, value: unknown): string {
	if (typeof value !== "string" || !value || value.includes("\0") || isAbsolute(value)) throw new ContextMarkerError("unsafePath");
	const path = resolve(root, value);
	if (!inside(root, path)) throw new ContextMarkerError("unsafePath");
	return path;
}

function readBounded(path: string, maximum: number): Buffer {
	let fd: number | undefined;
	try {
		if (!lstatSync(path).isFile()) throw new ContextMarkerError("unsafePath");
		fd = openSync(path, constants.O_RDONLY | constants.O_NOFOLLOW | constants.O_NONBLOCK);
		const info = fstatSync(fd);
		if (!info.isFile() || info.size > maximum) throw new ContextMarkerError("invalidManifest");
		const buffer = Buffer.alloc(maximum + 1);
		let length = 0;
		while (length < buffer.length) {
			const count = readSync(fd, buffer, length, buffer.length - length, null);
			if (!count) break;
			length += count;
		}
		if (length > maximum) throw new ContextMarkerError("invalidManifest");
		return buffer.subarray(0, length);
	} finally {
		if (fd !== undefined) closeSync(fd);
	}
}

/** Reject target links and non-directory ancestors before any write, including after generation. */
function validateTargets(plan: MarkerPlan) {
	if (realpathSync(plan.root) !== plan.canonicalRoot) throw new ContextMarkerError("unsafePath");
	for (const { directory } of plan.markers) {
		let cursor = plan.root;
		for (const component of relative(plan.root, directory).split(sep)) {
			cursor = resolve(cursor, component);
			try {
				const info = lstatSync(cursor);
				if (info.isSymbolicLink() || !info.isDirectory()) throw new ContextMarkerError("unsafePath");
			} catch (error) { if (!missing(error)) throw error; }
		}
		try {
			const info = lstatSync(resolve(directory, contextAccessMarker));
			if (!info.isFile() || info.isSymbolicLink()) throw new ContextMarkerError("unsafePath");
		} catch (error) { if (!missing(error)) throw error; }
	}
}

function loadPlan(projectRoot: string, manifestPath: string): MarkerPlan {
	try {
		if (!isAbsolute(projectRoot)) throw new ContextMarkerError("unsafePath");
		const root = resolve(projectRoot);
		const canonicalRoot = realpathSync(root);
		const manifest = localPath(root, manifestPath);
		if (!inside(canonicalRoot, realpathSync(manifest))) throw new ContextMarkerError("unsafePath");
		const data: unknown = JSON.parse(new TextDecoder("utf-8", { fatal: true }).decode(readBounded(manifest, 64 * 1024)));
		if (!object(data) || data.version !== 1 || !Array.isArray(data.markers) || !data.markers.length || data.markers.length > 64) {
			throw new ContextMarkerError("invalidManifest");
		}
		const sources = [manifest];
		const directories = new Set<string>();
		const markers = data.markers.map((entry: unknown) => {
			if (!object(entry)) throw new ContextMarkerError("invalidManifest");
			const directory = localPath(root, entry.directory);
			if (directory === root || relative(root, directory).split(sep).includes(contextAccessMarker) || directories.has(directory)) {
				throw new ContextMarkerError("invalidManifest");
			}
			directories.add(directory);
			const source = localPath(root, entry.guidanceFile);
			if (!inside(canonicalRoot, realpathSync(source))) throw new ContextMarkerError("unsafePath");
			sources.push(source);
			const markdown = new TextDecoder("utf-8", { fatal: true }).decode(readBounded(source, contextAccessLimits.markerBytes));
			const normalized = markdown.replace(/\r\n?/g, "\n").trim();
			const body = Buffer.from(normalized ? `${normalized}\n` : "");
			if (body.length > contextAccessLimits.markerBytes) throw new ContextMarkerError("invalidManifest");
			return { directory, body };
		});
		// Sources must survive an output-directory rebuild, lexically and through aliases.
		for (const source of sources) {
			const canonicalSource = realpathSync(source);
			for (const directory of directories) {
				const canonicalDirectory = resolve(canonicalRoot, relative(root, directory));
				if (inside(directory, source) || inside(canonicalDirectory, canonicalSource)) throw new ContextMarkerError("invalidManifest");
			}
		}
		let generator: ControlledTaskCommand | undefined;
		if (data.generator !== undefined) {
			if (!object(data.generator) || typeof data.generator.executable !== "string" ||
				(data.generator.args !== undefined && (!Array.isArray(data.generator.args) || data.generator.args.some((arg) => typeof arg !== "string"))) ||
				(data.generator.timeoutMs !== undefined && typeof data.generator.timeoutMs !== "number") ||
				(data.generator.maxOutputBytes !== undefined && typeof data.generator.maxOutputBytes !== "number")) {
				throw new ContextMarkerError("invalidManifest");
			}
			generator = snapshotTaskCommand({
				executable: data.generator.executable,
				...(data.generator.args === undefined ? {} : { args: data.generator.args as string[] }),
				...(data.generator.timeoutMs === undefined ? {} : { timeoutMs: data.generator.timeoutMs }),
				...(data.generator.maxOutputBytes === undefined ? {} : { maxOutputBytes: data.generator.maxOutputBytes }),
			});
		}
		const plan = { root, canonicalRoot, markers, ...(generator ? { generator } : {}) };
		validateTargets(plan);
		return plan;
	} catch (error) {
		if (error instanceof ContextMarkerError) throw error;
		throw new ContextMarkerError("invalidManifest");
	}
}

function applyPlan(plan: MarkerPlan, mode: "apply" | "check"): ContextMarkerReport {
	try {
		validateTargets(plan);
		const markers: ContextMarkerEntry[] = [];
		for (const { directory, body } of plan.markers) {
			const path = resolve(directory, contextAccessMarker);
			let exists = false;
			let equal = false;
			try {
				const info = lstatSync(path);
				exists = true;
				// Never read an oversized old marker just to compare it.
				equal = info.size === body.length && readBounded(path, contextAccessLimits.markerBytes).equals(body);
			} catch (error) { if (!missing(error)) throw error; }
			let status: ContextMarkerEntry["status"] = equal ? "unchanged" : exists ? "outdated" : "missing";
			if (!equal && mode === "apply") {
				mkdirSync(directory, { recursive: true });
				const temporary = resolve(directory, `${contextAccessMarker}.tmp-${randomUUID()}`);
				try {
					writeFileSync(temporary, body, { flag: "wx", mode: 0o644 });
					renameSync(temporary, path);
				} finally { rmSync(temporary, { force: true }); }
				status = exists ? "updated" : "created";
			}
			markers.push({ marker: relative(plan.root, path).split(sep).join("/"), status });
		}
		return { status: markers.some((entry) => entry.status === "missing" || entry.status === "outdated") ? "needsUpdate" : "ok", markers };
	} catch (error) {
		if (error instanceof ContextMarkerError) throw error;
		throw new ContextMarkerError("maintenanceFailed");
	}
}

/** Trusted maintenance entry point; ordinary model file tools still cannot read or mutate markers. */
export function maintainContextMarkers(projectRoot: string, manifestPath: string, mode: "apply" | "check" = "apply"): ContextMarkerReport {
	if (mode !== "apply" && mode !== "check") throw new ContextMarkerError("invalidManifest");
	return applyPlan(loadPlan(projectRoot, manifestPath), mode);
}

/** Host-only callback with snapshotted marker restoration, including rejected operations. */
export async function withContextMarkers<T>(projectRoot: string, manifestPath: string, operation: () => Promise<T>): Promise<{ result: T; markers: ContextMarkerEntry[] }> {
	const plan = loadPlan(projectRoot, manifestPath);
	let markers = applyPlan(plan, "apply").markers;
	let result: T;
	try { result = await operation(); }
	finally { markers = applyPlan(plan, "apply").markers; }
	return { result, markers };
}

/** Snapshot guidance before running a fixed generator, then restore in finally even on failure/cancellation. */
export async function generateWithContextMarkers(projectRoot: string, manifestPath: string, signal?: AbortSignal): Promise<ContextMarkerGenerationReport> {
	const plan = loadPlan(projectRoot, manifestPath);
	if (!plan.generator) throw new ContextMarkerError("invalidManifest");
	let markers = applyPlan(plan, "apply").markers;
	let generator: ContextMarkerGenerationReport["generator"];
	let status: ContextMarkerGenerationReport["status"] = "generationFailed";
	try {
		const outcome = await runControlledTask(plan.root, "build", plan.generator, signal);
		generator = { status: outcome.status, exitCode: outcome.exitCode };
		status = outcome.status === "passed" ? "ok" : "generationFailed";
	} catch {
		generator = { status: "executionError", exitCode: null };
	} finally {
		try { markers = applyPlan(plan, "apply").markers; }
		catch { status = "maintenanceFailed"; markers = []; }
	}
	return { status, markers, ...(generator ? { generator } : {}) };
}
