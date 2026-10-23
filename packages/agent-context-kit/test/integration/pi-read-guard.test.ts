import assert from "node:assert/strict";
import { mkdir, mkdtemp, rm, writeFile } from "node:fs/promises";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import {
	createAgentSession,
	DefaultResourceLoader,
	SessionManager,
	type ExtensionAPI,
} from "@earendil-works/pi-coding-agent";
import type { Context } from "@earendil-works/pi-ai";
import {
	fauxAssistantMessage,
	fauxProvider,
	fauxToolCall,
} from "@earendil-works/pi-ai/providers/faux";

import { PiLifecycleAdapter } from "../../src/adapters/pi.ts";

test("real Pi runtime blocks a protected read before file content reaches the model", async () => {
	const root = await mkdtemp(join(tmpdir(), "agent-context-kit-read-guard-runtime-"));
	const agentDir = join(root, "agent");
	const protectedDir = join(root, "generated", "library");
	await mkdir(agentDir, { recursive: true });
	await mkdir(protectedDir, { recursive: true });
	await writeFile(join(protectedDir, "model.json"), "PROTECTED_GENERATED_LIBRARY_PAYLOAD");

	const guidance =
		"TeaQL workspace context already provides the complete business model; use it instead.";
	let secondRequest: Context | undefined;
	const faux = fauxProvider({
		provider: "agent-context-kit-read-guard-fixture",
		models: [{ id: "read-guard-fixture", name: "Read guard fixture" }],
		tokensPerSecond: 1_000_000,
		tokenSize: { min: 1000, max: 1000 },
	});
	faux.setResponses([
		() =>
			fauxAssistantMessage(
				fauxToolCall("read", { path: "generated/library/model.json" }, { id: "read-call" }),
				{ stopReason: "toolUse" },
			),
		(context) => {
			secondRequest = context;
			return fauxAssistantMessage("guard observed", { stopReason: "stop" });
		},
	]);

	const resourceLoader = new DefaultResourceLoader({
		cwd: root,
		agentDir,
		extensionFactories: [
			(pi: ExtensionAPI) => {
				new PiLifecycleAdapter(pi as any, {
					readGuard: {
						workspaceRoot: root,
						paths: ["generated/library"],
						message: guidance,
					},
				});
			},
			(pi: ExtensionAPI) => pi.registerProvider(faux.provider),
		],
	});
	await resourceLoader.reload();

	const { session } = await createAgentSession({
		cwd: root,
		agentDir,
		model: faux.getModel(),
		resourceLoader,
		sessionManager: SessionManager.inMemory(root),
	});

	try {
		await session.prompt("read the generated library");
		assert.ok(secondRequest, "expected a follow-up provider request after the blocked tool call");
		const serialized = JSON.stringify(secondRequest.messages);
		assert.match(serialized, /Read blocked by agent-context-kit/);
		assert.match(serialized, /TeaQL workspace context/);
		assert.doesNotMatch(serialized, /PROTECTED_GENERATED_LIBRARY_PAYLOAD/);
	} finally {
		session.dispose();
		await rm(root, { recursive: true, force: true });
	}
});
