import assert from "node:assert/strict";
import { existsSync, mkdirSync, mkdtempSync, readFileSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { ModelRuntime } from "@earendil-works/pi-coding-agent";
import type { Context } from "@earendil-works/pi-ai";
import { fauxAssistantMessage, fauxProvider, fauxToolCall } from "@earendil-works/pi-ai/providers/faux";

import { createContextPolicyPiSession, createContextPolicyTaskTools } from "../../src/adapters/pi-context.ts";

function fixture(t: test.TestContext) {
	const base = mkdtempSync(join(tmpdir(), "pi-controlled-tasks-"));
	const root = join(base, "project");
	const agentDir = join(base, "agent");
	mkdirSync(join(root, "generated"), { recursive: true });
	mkdirSync(agentDir);
	writeFileSync(join(root, "generated/.agent-no-read.md"), "Use the public API and build/test tools.");
	writeFileSync(join(root, "generated/runtime.ts"), "PROVIDER_EXCLUDED_SOURCE_CANARY");
	t.after(() => rmSync(base, { recursive: true, force: true }));
	return { root, agentDir };
}

test("Pi 1.4 build/test results are filtered at the actual provider and transcript boundaries", async (t) => {
	const { root, agentDir } = fixture(t);
	const requests: Context[] = [];
	const faux = fauxProvider({
		provider: "controlled-tasks-provider-v14", models: [{ id: "fixture", name: "Fixture" }],
		tokensPerSecond: 1_000_000, tokenSize: { min: 1000, max: 1000 },
	});
	faux.setResponses([
		(context) => { requests.push(context); return fauxAssistantMessage(fauxToolCall("build", {}, { id: "build" }), { stopReason: "toolUse" }); },
		(context) => { requests.push(context); return fauxAssistantMessage(fauxToolCall("test", {}, { id: "test" }), { stopReason: "toolUse" }); },
		(context) => { requests.push(context); return fauxAssistantMessage("done", { stopReason: "stop" }); },
	]);
	const runtime = await ModelRuntime.create({ authPath: join(agentDir, "auth.json"), modelsPath: null, refreshOnCreate: false });
	runtime.registerNativeProvider(faux.provider);
	const buildScript = `
		import {readFileSync, writeFileSync} from 'node:fs';
		const source = readFileSync('generated/runtime.ts', 'utf8');
		writeFileSync('build-used-runtime', String(source.length));
		console.log(source); console.error(source);
		console.log(JSON.stringify({version:1, type:'diagnostic', path:'generated/runtime.ts', line:1, column:2, code:'TS2322', message:source, excerpt:source}));
		process.exitCode = 1;
	`;
	const { session } = await createContextPolicyPiSession({
		projectRoot: root, agentDir, model: faux.getModel(), modelRuntime: runtime,
		commands: {
			build: { executable: process.execPath, args: ["--input-type=module", "-e", buildScript], includeAllowedSource: true },
			test: { executable: process.execPath, args: ["-e", `console.log(JSON.stringify({version:1,type:'testSummary',passed:2,failed:0,skipped:1}));`] },
		},
	});
	try {
		assert.deepEqual(session.getActiveToolNames().sort(), ["build", "find", "grep", "ls", "read", "test"]);
		await session.prompt("Run the configured build and tests.");
		assert.equal(requests.length, 3);
		assert.equal(readFileSync(join(root, "build-used-runtime"), "utf8"), "31");
		for (const request of requests) assert.doesNotMatch(JSON.stringify(request), /PROVIDER_EXCLUDED_SOURCE_CANARY|readFileSync|console\.error/);
		const last = JSON.stringify(requests.at(-1));
		assert.match(last, /TS2322/);
		assert.match(last, /not assignable/);
		assert.match(last, /generated\/runtime.ts/);
		assert.match(last, /excluded/);
		assert.match(last, /passed/);
		assert.match(last, /skipped/);
		assert.doesNotMatch(JSON.stringify(session.messages), /PROVIDER_EXCLUDED_SOURCE_CANARY|readFileSync|console\.error/);
	} finally { session.dispose(); }
});

test("fixed task tools reject command arguments and snapshot their host configuration", async (t) => {
	const { root } = fixture(t);
	const args = ["-e", "require('node:fs').writeFileSync('original-ran', 'yes')"];
	const tools = createContextPolicyTaskTools(root, { build: { executable: process.execPath, args } });
	assert.deepEqual(tools.map((tool) => tool.name), ["build"]);
	const build = tools[0]!;
	args[1] = "require('node:fs').writeFileSync('changed-ran', 'yes')";
	const rejected = await build.execute("reject", { command: "touch must-not-run", args: ["ignored"] }, undefined, undefined, {} as any);
	assert.match(JSON.stringify(rejected), /invalidInput/);
	assert.equal(existsSync(join(root, "original-ran")), false);
	const output = await build.execute("fixed", {}, undefined, undefined, {} as any);
	assert.match(JSON.stringify(output), /passed/);
	assert.equal(existsSync(join(root, "original-ran")), true);
	assert.equal(existsSync(join(root, "changed-ran")), false);
	assert.equal(existsSync(join(root, "must-not-run")), false);
});

test("arbitrary model Bash is blocked, user_bash is intercepted, raw host executeBash remains explicitly uncovered", async (t) => {
	const { root, agentDir } = fixture(t);
	const requests: Context[] = [];
	const faux = fauxProvider({
		provider: "controlled-tasks-bash-v14", models: [{ id: "fixture", name: "Fixture" }],
		tokensPerSecond: 1_000_000, tokenSize: { min: 1000, max: 1000 },
	});
	faux.setResponses([
		(context) => { requests.push(context); return fauxAssistantMessage(fauxToolCall("bash", { command: "touch must-not-run" }, { id: "bash-attempt" }), { stopReason: "toolUse" }); },
		(context) => { requests.push(context); return fauxAssistantMessage("done", { stopReason: "stop" }); },
	]);
	const runtime = await ModelRuntime.create({ authPath: join(agentDir, "auth.json"), modelsPath: null, refreshOnCreate: false });
	runtime.registerNativeProvider(faux.provider);
	const { session, extensionsResult } = await createContextPolicyPiSession({ projectRoot: root, agentDir, model: faux.getModel(), modelRuntime: runtime });
	try {
		assert.ok(!session.getActiveToolNames().includes("bash"));
		// The factory did not register native Bash, so accidental activation cannot enable it.
		session.setActiveToolsByName(["bash", "read"]);
		await session.prompt("Try the tool.");
		assert.equal(existsSync(join(root, "must-not-run")), false);
		assert.ok(!session.getActiveToolNames().includes("bash"));
		assert.match(JSON.stringify(requests.at(-1)), /Tool bash not found/);
		const callHandlers = extensionsResult.extensions.flatMap((extension) => extension.handlers.get("tool_call") ?? []);
		const deniedCall = await callHandlers[0]!({ type: "tool_call", toolName: "bash", input: { command: "touch must-not-run" } } as any, {} as any);
		assert.match(JSON.stringify(deniedCall), /Arbitrary shell and mutation tools are disabled/);
		const handlers = extensionsResult.extensions.flatMap((extension) => extension.handlers.get("user_bash") ?? []);
		assert.equal(handlers.length, 1);
		const blocked = await handlers[0]!({ type: "user_bash", command: "touch must-not-run", cwd: root, excludeFromContext: false } as any, {} as any);
		assert.match(JSON.stringify(blocked), /Arbitrary Bash is disabled/);
		assert.equal(existsSync(join(root, "must-not-run")), false);
		// This trusted-host API bypasses user_bash; demonstrate rather than claim it is protected.
		const host = await session.executeBash("printf HOST_API_IS_UNCOVERED");
		assert.equal(host.output, "HOST_API_IS_UNCOVERED");
	} finally { session.dispose(); }
});
