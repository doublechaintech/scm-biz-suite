import { existsSync, readFileSync } from "node:fs";
import { resolve } from "node:path";

import { parseReadGuardConfig, ReadGuard, type ReadGuardConfig } from "../read-guard.ts";
import { LifecycleSession } from "../session.ts";

export const WORKSPACE_SOURCE_FILE = ".agent-context-kit.md";
export const WORKSPACE_CONFIG_FILE = ".agent-context-kit.json";

interface WorkspaceConfig {
	readGuard?: unknown;
}

export interface WorkspaceRuntimeOptions {
	directory: string;
	sourceFile?: string;
	readGuard?: ReadGuardConfig;
}

interface SessionState {
	lifecycle: LifecycleSession;
	loadedSources: Set<string>;
}

function hash(input: string): string {
	let value = 0x811c9dc5;
	for (let index = 0; index < input.length; index += 1) {
		value ^= input.charCodeAt(index);
		value = Math.imul(value, 0x01000193);
	}
	return (value >>> 0).toString(16);
}

export function loadWorkspaceReadGuard(
	directory: string,
	explicit?: ReadGuardConfig,
): ReadGuard | undefined {
	if (explicit) return new ReadGuard(explicit, directory);
	const path = resolve(directory, WORKSPACE_CONFIG_FILE);
	if (!existsSync(path)) return undefined;

	let parsed: unknown;
	try {
		parsed = JSON.parse(readFileSync(path, "utf8"));
	} catch (error) {
		throw new Error(
			`Invalid Agent Context Kit config at ${path}: ${error instanceof Error ? error.message : String(error)}`,
		);
	}
	if (typeof parsed !== "object" || parsed === null || Array.isArray(parsed)) {
		throw new Error(`Agent Context Kit config must be a JSON object: ${path}`);
	}
	const config = parsed as WorkspaceConfig;
	return config.readGuard === undefined
		? undefined
		: new ReadGuard(parseReadGuardConfig(config.readGuard, `${path}:readGuard`), directory);
}

/** Per-host-session lifecycle state backed by one trusted workspace file. */
export class WorkspaceLifecycleRuntime {
	readonly directory: string;
	readonly sourcePath: string;
	readonly readGuard: ReadGuard | undefined;
	private readonly sessions = new Map<string, SessionState>();

	constructor(options: WorkspaceRuntimeOptions) {
		this.directory = resolve(options.directory);
		this.sourcePath = resolve(this.directory, options.sourceFile ?? WORKSPACE_SOURCE_FILE);
		this.readGuard = loadWorkspaceReadGuard(this.directory, options.readGuard);
	}

	session(sessionID: string): LifecycleSession {
		return this.state(sessionID).lifecycle;
	}

	loadTrustedSource(sessionID: string): LifecycleSession {
		const state = this.state(sessionID);
		let markdown: string;
		try {
			markdown = readFileSync(this.sourcePath, "utf8");
		} catch (error) {
			if ((error as NodeJS.ErrnoException).code === "ENOENT") return state.lifecycle;
			throw error;
		}
		const version = `${this.sourcePath}:${hash(markdown)}`;
		if (state.loadedSources.has(version)) return state.lifecycle;
		state.loadedSources.add(version);
		const source = `workspace:${this.sourcePath}`;
		state.lifecycle.loadMarkdownSource(source, markdown, "workspace_source_loaded");
		state.lifecycle.applyControlMarkdown(markdown, {
			source,
			trigger: "workspace_trusted_source",
			trusted: true,
		});
		return state.lifecycle;
	}

	private state(sessionID: string): SessionState {
		let state = this.sessions.get(sessionID);
		if (!state) {
			state = { lifecycle: new LifecycleSession(), loadedSources: new Set() };
			this.sessions.set(sessionID, state);
		}
		return state;
	}
}
