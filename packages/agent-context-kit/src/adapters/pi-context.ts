import { resolve } from "node:path";

import {
	createAgentSession,
	createFindToolDefinition,
	createGrepToolDefinition,
	createLsToolDefinition,
	createReadToolDefinition,
	DefaultResourceLoader,
	SettingsManager,
	type CreateAgentSessionOptions,
	type ExtensionAPI,
	type ToolDefinition,
	type ReadToolInput,
	type GrepToolInput,
	type FindToolInput,
	type LsToolInput,
} from "@earendil-works/pi-coding-agent";

import { loadContextPolicyFiles } from "../context-loading.ts";
export { loadContextPolicyFiles } from "../context-loading.ts";

import { ContextAccessDenied, ContextFiles } from "../context-files.ts";
import { runControlledTask, snapshotTaskCommand, type ControlledTaskCommands } from "../controlled-tasks.ts";
import { contextPolicyFeedback, contextPolicyInstruction } from "../policy-feedback.ts";
import { registerPiPolicyFeedback } from "./pi-policy-feedback.ts";

const TOOL_NAMES = ["read", "grep", "find", "ls"];
const CONTEXT_TYPE = "agent-context-kit-project-files-v1";

function result(data: unknown) {
	const feedback = contextPolicyFeedback(data);
	return { content: [{ type: "text" as const, text: JSON.stringify(feedback) }], details: feedback };
}

function errorResult(error: unknown) {
	return result(error instanceof ContextAccessDenied ? error.decision : {
		status: "policyError", reason: "Context operation could not be completed; content was not returned.",
	});
}

function imageMime(body: Buffer): string | undefined {
	if (body.subarray(0, 8).equals(Buffer.from([137, 80, 78, 71, 13, 10, 26, 10]))) return "image/png";
	if (body[0] === 0xff && body[1] === 0xd8 && body[2] === 0xff) return "image/jpeg";
	if (/^GIF8[79]a/.test(body.subarray(0, 6).toString("ascii"))) return "image/gif";
	if (body.subarray(0, 4).toString() === "RIFF" && body.subarray(8, 12).toString() === "WEBP") return "image/webp";
	if (body.subarray(0, 2).toString() === "BM") return "image/bmp";
	return undefined;
}

/** Pi 1.4 tool replacements. Install all four together; original search tools must not remain active. */
export function createContextPolicyTools(projectRoot: string): ToolDefinition<any, any>[] {
	const files = new ContextFiles(projectRoot);
	const nativeRead = createReadToolDefinition(files.root, {
		operations: {
			access: async (path) => { files.require(path); },
			readFile: async (path) => files.read(path, 10 * 1024 * 1024),
			detectImageMimeType: async (path) => imageMime(files.read(path, 10 * 1024 * 1024)),
		},
	});
	const read: ToolDefinition<any, any> = {
		name: "read", label: "read", parameters: nativeRead.parameters,
		description: `${nativeRead.description} Applies .agent-no-read.md context exclusion. Paths are relative to the project root.`,
		promptSnippet: "Read permitted files and images",
		async execute(id, args: ReadToolInput, signal, _onUpdate, ctx) {
			try {
				const decision = files.require(args.path);
				// Pin the root and recheck inside native read operations, including normalized image paths.
				const output = await nativeRead.execute(id, { ...args, path: decision.path }, signal, undefined, { ...ctx, cwd: files.root });
				files.require(args.path);
				if (output.details?.truncation?.firstLineExceedsLimit) {
					return result({ status: "contentTooLarge", reason: "This line exceeds the read output limit. Consult a smaller public interface document or a bounded project index." });
				}
				return output;
			} catch (error) { return errorResult(error); }
		},
	};
	const grepBase = createGrepToolDefinition(files.root);
	const findBase = createFindToolDefinition(files.root);
	const lsBase = createLsToolDefinition(files.root);
	return [read, {
		name: "grep", label: "grep", parameters: grepBase.parameters,
		description: "Search permitted text files with a JavaScript regex or literal pattern. Prunes .agent-no-read.md subtrees before enumeration. Includes hidden and ignored files. Files over 2 MiB are omitted with a policyError summary. Context is capped at 10 lines each side; output at 1000 matches and 32K text characters. No shell flags are accepted.",
		promptSnippet: "Search permitted file contents",
		async execute(_id, args: GrepToolInput, signal) {
			try { return result(files.grep({ ...args, ...(signal ? { signal } : {}) })); } catch (error) { return errorResult(error); }
		},
	}, {
		name: "find", label: "find", parameters: findBase.parameters,
		description: "Find permitted files by glob, pruning .agent-no-read.md subtrees before enumeration. Includes hidden and ignored files. At most 1000 results. Paths are relative to the project root.",
		promptSnippet: "Find permitted file paths",
		async execute(_id, args: FindToolInput, signal) {
			try { return result(files.find({ ...args, ...(signal ? { signal } : {}) })); } catch (error) { return errorResult(error); }
		},
	}, {
		name: "ls", label: "ls", parameters: lsBase.parameters,
		description: "List a permitted directory. Excluded directory entries are shown with exclusion status and project guidance; their contents are never expanded. At most 1000 entries.",
		promptSnippet: "List directories with context exclusion status",
		async execute(_id, args: LsToolInput) {
			try { return result(files.list(args.path, args.limit)); } catch (error) { return errorResult(error); }
		},
	}];
}

/** Fixed commands configured by trusted host code, with no model-selectable arguments. */
export function createContextPolicyTaskTools(projectRoot: string, commands: ControlledTaskCommands): ToolDefinition<any, any>[] {
	const root = new ContextFiles(projectRoot).root;
	return (["build", "test"] as const).flatMap((name) => {
		const configured = commands[name];
		if (!configured) return [];
		const command = snapshotTaskCommand(configured);
		return [{
			name, label: name, executionMode: "sequential",
			parameters: { type: "object", properties: {}, additionalProperties: false },
			description: `Run the host-configured ${name} command. Takes no arguments. Internally accesses the full project, returning only controlled status, test counts and policy-checked diagnostics. Raw process output is suppressed.`,
			promptSnippet: `Run the fixed ${name} command`,
			async execute(_id, args, signal) {
				// Also enforce the empty input contract for direct SDK callers outside Pi validation.
				if (!args || typeof args !== "object" || Array.isArray(args) || Object.keys(args).length) {
					return result({ status: "invalidInput", reason: "This tool accepts an empty object only; commands and arguments are fixed by the host." });
				}
				try { return result(await runControlledTask(root, name, command, signal)); }
				catch { return result({ status: "executionError", reason: "The configured task could not be completed." }); }
			},
		} satisfies ToolDefinition<any, any>];
	});
}

export interface ContextPolicyPiOptions {
	projectRoot: string;
	agentDir: string;
	/** Additional project documentation, index or text attachment paths. Each is checked before reading. */
	contextPaths?: readonly string[];
	/** Fixed build/test processes supplied by trusted host code; never loaded from marker files. */
	commands?: ControlledTaskCommands;
	model?: CreateAgentSessionOptions["model"];
	modelRuntime?: CreateAgentSessionOptions["modelRuntime"];
	thinkingLevel?: CreateAgentSessionOptions["thinkingLevel"];
}

/**
 * Dedicated Pi 1.4 session. Default discovery is disabled before any project context
 * is loaded. Guarded file tools and optional fixed build/test commands are enabled;
 * no arbitrary Bash or mutation tools.
 */
export async function createContextPolicyPiSession(options: ContextPolicyPiOptions) {
	const files = new ContextFiles(options.projectRoot);
	const taskTools = createContextPolicyTaskTools(files.root, options.commands ?? {});
	const enabledTools = new Set([...TOOL_NAMES, ...taskTools.map((tool) => tool.name)]);
	const settingsManager = SettingsManager.inMemory();
	const resourceLoader = new DefaultResourceLoader({
		cwd: files.root, agentDir: options.agentDir, settingsManager,
		noExtensions: true, noSkills: true, noPromptTemplates: true, noThemes: true, noContextFiles: true,
		// Explicit values suppress SYSTEM.md / APPEND_SYSTEM.md discovery as well.
		systemPrompt: `You are a coding assistant.\nUse the available tools to help with the user's project.\n${contextPolicyInstruction}`,
		appendSystemPrompt: [],
		extensionFactories: [(pi: ExtensionAPI) => {
			registerPiPolicyFeedback(pi, files.root);
			pi.on("tool_call", (event) => {
				if (!enabledTools.has(event.toolName)) return {
					block: true, reason: "This harness allows guarded file tools and configured build/test tools only. Arbitrary shell and mutation tools are disabled.",
				};
				return undefined;
			});
			pi.on("user_bash", () => ({ result: {
				output: "Arbitrary Bash is disabled in this context-policy harness. Use the configured build/test tools.",
				exitCode: 1, cancelled: false, truncated: false,
			} }));
			pi.on("context_with_system", (event) => {
				const data = loadContextPolicyFiles(files.root, options.contextPaths);
				return {
					messages: [...event.messages, {
						role: "custom", customType: CONTEXT_TYPE, content: JSON.stringify(data), display: false, timestamp: Date.now(),
					}],
				};
			});
		}],
	});
	await resourceLoader.reload();
	if (resourceLoader.getExtensions().errors.length) throw new Error("Unable to initialize context policy extension");
	return createAgentSession({
		cwd: files.root, agentDir: options.agentDir, settingsManager, resourceLoader,
		tools: [...TOOL_NAMES, ...taskTools.map((tool) => tool.name)],
		customTools: [...createContextPolicyTools(files.root), ...taskTools],
		...(options.model ? { model: options.model } : {}),
		...(options.modelRuntime ? { modelRuntime: options.modelRuntime } : {}),
		...(options.thinkingLevel ? { thinkingLevel: options.thinkingLevel } : {}),
	});
}
