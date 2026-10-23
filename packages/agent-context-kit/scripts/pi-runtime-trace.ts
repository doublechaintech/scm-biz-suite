import { mkdir, mkdtemp, readFile, rm, writeFile } from "node:fs/promises";
import { tmpdir } from "node:os";
import { dirname, join, resolve } from "node:path";
import { pathToFileURL } from "node:url";

import {
	createAgentSession,
	DefaultResourceLoader,
	SessionManager,
	type ExtensionAPI,
} from "@earendil-works/pi-coding-agent";
import { Type, type Context, type Message } from "@earendil-works/pi-ai";
import {
	fauxAssistantMessage,
	fauxProvider,
	fauxToolCall,
} from "@earendil-works/pi-ai/providers/faux";

import { PiLifecycleAdapter } from "../src/adapters/pi.ts";

const BLOCK_ID = "phase_modeling";
const BLOCK_CONTENT = "TRACE_FIXTURE_MODELING_RULE";
const EPHEMERAL_CONTENT = "TRACE_FIXTURE_EPHEMERAL_PAYLOAD";
const FIXED_TIME = Date.parse("2026-01-01T00:00:00.000Z");

interface TraceMessage {
	role: string;
	toolName?: string;
	toolCallId?: string;
	content: string;
}

export interface ProviderRequestTrace {
	kind: "provider_request";
	request: number;
	lifecycleRequestSequence: number;
	activeBlockIds: string[];
	blockVisible: boolean;
	sourceBlockStillInSystemPrompt: boolean;
	ephemeralState: "absent" | "original" | "tombstone";
	messages: TraceMessage[];
	audit: Array<{
		action: string;
		blockId?: string;
		requestSequence: number;
	}>;
}

export interface TranscriptTrace {
	kind: "persistent_transcript";
	originalEphemeralPreserved: boolean;
	tombstonePersisted: boolean;
	activeBlockIdsAfterDiscard: string[];
}

export type PiRuntimeTraceRecord = ProviderRequestTrace | TranscriptTrace;

export interface PiRuntimeTraceResult {
	records: PiRuntimeTraceRecord[];
	outputPath?: string;
}

function contentText(message: Message): string {
	if (message.role === "assistant") {
		return message.content
			.map((part) => {
				if (part.type === "text") return part.text;
				if (part.type === "thinking") return `[THINKING:${part.thinking}]`;
				return `[TOOL_CALL:${part.name}:${JSON.stringify(part.arguments)}]`;
			})
			.join("\n");
	}
	if (typeof message.content === "string") return message.content;
	return message.content
		.map((part) => (part.type === "text" ? part.text : `[IMAGE:${part.mimeType}]`))
		.join("\n");
}

function traceMessage(message: Message): TraceMessage {
	return {
		role: message.role,
		...(message.role === "toolResult"
			? { toolName: message.toolName, toolCallId: message.toolCallId }
			: {}),
		content: contentText(message),
	};
}

function captureProviderRequest(
	request: number,
	context: Context,
	adapter: PiLifecycleAdapter,
): ProviderRequestTrace {
	const messages = context.messages.map(traceMessage);
	const serializedMessages = JSON.stringify(messages);
	const fullContext = `${context.systemPrompt ?? ""}\n${serializedMessages}`;
	const ephemeralState = serializedMessages.includes("[EPHEMERAL:")
		? "tombstone"
		: serializedMessages.includes(EPHEMERAL_CONTENT)
			? "original"
			: "absent";

	return {
		kind: "provider_request",
		request,
		lifecycleRequestSequence: adapter.state.requestSequence,
		activeBlockIds: adapter.state.activeBlocks().map((block) => block.id),
		blockVisible: fullContext.includes(BLOCK_CONTENT),
		sourceBlockStillInSystemPrompt: (context.systemPrompt ?? "").includes(BLOCK_CONTENT),
		ephemeralState,
		messages,
		audit: adapter.state.audit.map((event) => ({
			action: event.action,
			...(event.blockId ? { blockId: event.blockId } : {}),
			requestSequence: event.requestSequence,
		})),
	};
}

/**
 * Run the real Pi AgentSession, extension runner, request transform, tool loop,
 * and provider boundary with a deterministic local faux provider.
 */
export async function runPiRuntimeTrace(outputPath?: string): Promise<PiRuntimeTraceResult> {
	const temporaryRoot = await mkdtemp(join(tmpdir(), "agent-context-kit-pi-"));
	const agentDir = join(temporaryRoot, "agent");
	await mkdir(agentDir, { recursive: true });

	const records: PiRuntimeTraceRecord[] = [];
	const faux = fauxProvider({
		provider: "agent-context-kit-fixture",
		models: [{ id: "lifecycle-fixture", name: "Lifecycle fixture" }],
		tokensPerSecond: 1_000_000,
		tokenSize: { min: 1000, max: 1000 },
	});
	let adapter: PiLifecycleAdapter | undefined;
	let providerRequest = 0;

	const capture = (context: Context) => {
		providerRequest += 1;
		if (!adapter) throw new Error("Pi lifecycle adapter was not initialized");
		records.push(captureProviderRequest(providerRequest, context, adapter));
	};

	faux.setResponses([
		(context) => {
			capture(context);
			return fauxAssistantMessage(fauxToolCall("emit_ephemeral", {}, { id: "ephemeral-call" }), {
				stopReason: "toolUse",
				timestamp: FIXED_TIME + 1,
			});
		},
		(context) => {
			capture(context);
			return fauxAssistantMessage(fauxToolCall("continue_probe", {}, { id: "continue-call" }), {
				stopReason: "toolUse",
				timestamp: FIXED_TIME + 2,
			});
		},
		(context) => {
			capture(context);
			return fauxAssistantMessage("first run complete", {
				stopReason: "stop",
				timestamp: FIXED_TIME + 3,
			});
		},
		(context) => {
			capture(context);
			return fauxAssistantMessage("discard verified", {
				stopReason: "stop",
				timestamp: FIXED_TIME + 4,
			});
		},
	]);

	const contextMarkdown = [
		"# Fixture context",
		`<!--BLOCK_ID:${BLOCK_ID}-->`,
		BLOCK_CONTENT,
		`<!--/BLOCK_ID:${BLOCK_ID}-->`,
	].join("\n");

	const resourceLoader = new DefaultResourceLoader({
		cwd: process.cwd(),
		agentDir,
		agentsFilesOverride: () => ({
			agentsFiles: [{ path: "/virtual/AGENTS.md", content: contextMarkdown }],
		}),
		extensionFactories: [
			(pi: ExtensionAPI) => {
				adapter = new PiLifecycleAdapter(pi as any, {
					clock: () => new Date(FIXED_TIME),
				});
			},
			(pi: ExtensionAPI) => {
				pi.registerProvider(faux.provider);
				pi.registerTool({
					name: "emit_ephemeral",
					label: "Emit ephemeral",
					description: "Return deterministic ephemeral output for lifecycle testing",
					parameters: Type.Object({}),
					async execute() {
						return {
							content: [{ type: "text", text: `<!--ephemeral-->\n${EPHEMERAL_CONTENT}` }],
							details: {},
						};
					},
				});
				pi.registerTool({
					name: "continue_probe",
					label: "Continue probe",
					description: "Force one additional provider request",
					parameters: Type.Object({}),
					async execute() {
						return { content: [{ type: "text", text: "ordinary continuation" }], details: {} };
					},
				});
			},
		],
	});
	await resourceLoader.reload();

	const { session } = await createAgentSession({
		cwd: process.cwd(),
		agentDir,
		model: faux.getModel(),
		resourceLoader,
		sessionManager: SessionManager.inMemory(process.cwd()),
		noTools: "builtin",
	});

	try {
		await session.prompt("run lifecycle fixture");
		if (!adapter) throw new Error("Pi lifecycle adapter was not initialized");
		adapter.acceptTrustedControl(
			`<!--DISCARD_BLOCK:${BLOCK_ID}-->`,
			"integration:trusted-workflow",
			"fixture_phase_complete",
		);
		await session.prompt("verify discarded context");

		const transcript = JSON.stringify(session.messages);
		records.push({
			kind: "persistent_transcript",
			originalEphemeralPreserved: transcript.includes(EPHEMERAL_CONTENT),
			tombstonePersisted: transcript.includes("[EPHEMERAL:"),
			activeBlockIdsAfterDiscard: adapter.state.activeBlocks().map((block) => block.id),
		});
	} finally {
		session.dispose();
		await rm(temporaryRoot, { recursive: true, force: true });
	}

	if (outputPath) {
		const absoluteOutput = resolve(outputPath);
		await mkdir(dirname(absoluteOutput), { recursive: true });
		await writeFile(absoluteOutput, `${records.map((record) => JSON.stringify(record)).join("\n")}\n`, "utf8");
		await readFile(absoluteOutput, "utf8");
		return { records, outputPath: absoluteOutput };
	}

	return { records };
}

async function main(): Promise<void> {
	const outputPath = process.argv[2] ?? ".artifacts/pi-context-trace.jsonl";
	const result = await runPiRuntimeTrace(outputPath);
	process.stdout.write(`Pi runtime trace written to ${result.outputPath}\n`);
	for (const record of result.records) process.stdout.write(`${JSON.stringify(record)}\n`);
}

if (process.argv[1] && import.meta.url === pathToFileURL(resolve(process.argv[1])).href) {
	await main();
}
