import assert from "node:assert/strict";
import { cpSync, existsSync, mkdirSync, mkdtempSync, readFileSync, rmSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import { fileURLToPath } from "node:url";
import test from "node:test";

import { ModelRuntime } from "@earendil-works/pi-coding-agent";
import type { Context } from "@earendil-works/pi-ai";
import { fauxAssistantMessage, fauxProvider, fauxToolCall } from "@earendil-works/pi-ai/providers/faux";

import { createContextPolicyPiSession, createContextPolicyTaskTools } from "../../src/adapters/pi-context.ts";
import { maintainContextMarkers } from "../../src/context-markers.ts";

// The same project and adapters used by npm run example:context-markers.
test("full Pi lifecycle regenerates marked runtime twice, builds/tests it and never exposes its implementation", async (t) => {
	const base = mkdtempSync(join(tmpdir(), "pi-marker-lifecycle-"));
	const root = join(base, "project");
	const agentDir = join(base, "agent");
	cpSync(fileURLToPath(new URL("../../examples/pi-context/generated-runtime", import.meta.url)), root, { recursive: true });
	mkdirSync(agentDir);
	t.after(() => rmSync(base, { recursive: true, force: true }));
	const build = { executable: process.execPath, args: [fileURLToPath(new URL("../../examples/pi-context/marked-build.mjs", import.meta.url))] };
	const tests = {
		executable: process.execPath,
		args: ["--test", `--test-reporter=${fileURLToPath(new URL("../../examples/pi-context/node-test-jsonl.mjs", import.meta.url))}`, "test/runtime.test.mjs"],
	};
	assert.equal(createContextPolicyTaskTools(root, { build })[0]?.executionMode, "sequential");
	const requests: Context[] = [];
	const faux = fauxProvider({
		provider: "marker-lifecycle-v14", models: [{ id: "fixture", name: "Fixture" }],
		tokensPerSecond: 1_000_000, tokenSize: { min: 1000, max: 1000 },
	});
	const calls = [
		["build", {}], ["test", {}], ["build", {}],
		["read", { path: "generated/runtime.mjs" }],
		["grep", { pattern: "answer", path: "." }],
		["find", { pattern: "*.mjs", path: "generated" }],
	] as const;
	faux.setResponses([
		...calls.map(([name, args], index) => (context: Context) => {
			requests.push(context);
			if (index > 0) assert.equal(existsSync(join(root, "generated/.agent-no-read.md")), true);
			return fauxAssistantMessage(fauxToolCall(name, args, { id: `step-${index}` }), { stopReason: "toolUse" });
		}),
		(context) => { requests.push(context); return fauxAssistantMessage("done", { stopReason: "stop" }); },
	]);
	const runtime = await ModelRuntime.create({ authPath: join(agentDir, "auth.json"), modelsPath: null, refreshOnCreate: false });
	runtime.registerNativeProvider(faux.provider);
	const { session } = await createContextPolicyPiSession({
		projectRoot: root, agentDir, model: faux.getModel(), modelRuntime: runtime,
		commands: { build, test: tests }, contextPaths: ["generated/AGENTS.md"],
	});
	try {
		await session.prompt("Build, test, rebuild and inspect the public runtime interface.");
		assert.equal(requests.length, calls.length + 1);
		assert.match(readFileSync(join(root, "generated/runtime.mjs"), "utf8"), /GENERATED_IMPLEMENTATION_CANARY/);
		assert.equal(maintainContextMarkers(root, "context-markers.json", "check").status, "ok");
		for (const request of requests) {
			assert.doesNotMatch(JSON.stringify(request), /GENERATED_IMPLEMENTATION_CANARY|return 42;|Generated internals are not project guidance/);
		}
		const toolResults = session.messages.filter((message) => message.role === "toolResult");
		assert.equal(toolResults.length, calls.length);
		assert.match(JSON.stringify(toolResults[0]), /passed/);
		assert.match(JSON.stringify(toolResults[1]), /passed/);
		assert.match(JSON.stringify(toolResults[2]), /passed/);
		assert.match(JSON.stringify(toolResults[3]), /excluded/);
		assert.match(JSON.stringify(toolResults[5]), /excluded/);
		assert.doesNotMatch(JSON.stringify(session.messages), /GENERATED_IMPLEMENTATION_CANARY|return 42;/);
	} finally { session.dispose(); }
});
