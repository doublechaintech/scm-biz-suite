import assert from "node:assert/strict";
import { mkdirSync, mkdtempSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { ModelRuntime } from "@earendil-works/pi-coding-agent";
import type { Context } from "@earendil-works/pi-ai";
import { fauxAssistantMessage, fauxProvider, fauxToolCall } from "@earendil-works/pi-ai/providers/faux";

import { createContextPolicyPiSession, createContextPolicyTools, loadContextPolicyFiles } from "../../src/adapters/pi-context.ts";

function fixture(t: test.TestContext) {
	const base = mkdtempSync(join(tmpdir(), "pi-context-"));
	const root = join(base, "project");
	const agentDir = join(base, "agent");
	mkdirSync(join(root, "generated/runtime"), { recursive: true });
	mkdirSync(join(root, ".pi/skills/hidden"), { recursive: true });
	mkdirSync(join(root, ".pi/prompts"), { recursive: true });
	mkdirSync(agentDir);
	writeFileSync(join(root, "generated/.agent-no-read.md"), "Read docs/api.md instead.");
	writeFileSync(join(root, "generated/runtime/INTERNAL_FILE.ts"), "EXCLUDED_RUNTIME_SOURCE needle");
	writeFileSync(join(root, "generated/AGENTS.md"), "EXCLUDED_AUTO_CONTEXT");
	writeFileSync(join(root, "AGENTS.md"), "PERMITTED_PROJECT_CONTEXT");
	writeFileSync(join(root, "src.ts"), "needle permitted\nsecond line\n");
	writeFileSync(join(root, "SYSTEM.md"), "DEFAULT_SYSTEM_MUST_NOT_LOAD");
	writeFileSync(join(root, "APPEND_SYSTEM.md"), "DEFAULT_APPEND_MUST_NOT_LOAD");
	writeFileSync(join(root, ".pi/skills/hidden/SKILL.md"), "---\nname: hidden\ndescription: FORBIDDEN_SKILL_DISCOVERY\n---\nFORBIDDEN_SKILL_BODY");
	writeFileSync(join(root, ".pi/prompts/hidden.md"), "FORBIDDEN_PROMPT_TEMPLATE");
	writeFileSync(join(agentDir, "AGENTS.md"), "GLOBAL_CONTEXT_MUST_NOT_LOAD");
	t.after(() => rmSync(base, { recursive: true, force: true }));
	return { root, agentDir };
}

test("Pi 1.4 provider boundary receives only permitted search/read/list and controlled context", async (t) => {
	const { root, agentDir } = fixture(t);
	const requests: Context[] = [];
	const faux = fauxProvider({
		provider: "context-policy-v14", models: [{ id: "fixture", name: "Fixture" }],
		tokensPerSecond: 1_000_000, tokenSize: { min: 1000, max: 1000 },
	});
	const calls = [
		["read", { path: "generated/runtime/INTERNAL_FILE.ts", offset: 1, limit: 1 }],
		["grep", { path: ".", pattern: "needle" }],
		["find", { path: ".", pattern: "**/*.ts" }],
		["ls", { path: "." }],
		["read", { path: "src.ts", offset: 2, limit: 1 }],
		["read", { path: "generated/.agent-no-read.md" }],
	] as const;
	faux.setResponses([
		...calls.map(([name, args], index) => (context: Context) => {
			requests.push(context);
			return fauxAssistantMessage(fauxToolCall(name, args, { id: `call-${index}` }), { stopReason: "toolUse" });
		}),
		(context) => { requests.push(context); return fauxAssistantMessage("done", { stopReason: "stop" }); },
	]);
	const runtime = await ModelRuntime.create({ authPath: join(agentDir, "auth.json"), modelsPath: null, refreshOnCreate: false });
	runtime.registerNativeProvider(faux.provider);
	const { session } = await createContextPolicyPiSession({
		projectRoot: root, agentDir, model: faux.getModel(), modelRuntime: runtime,
		contextPaths: ["generated/AGENTS.md"],
	});
	try {
		assert.deepEqual(session.getActiveToolNames().sort(), ["find", "grep", "ls", "read"]);
		await session.prompt("Inspect the project with the available tools.");
		assert.equal(requests.length, calls.length + 1);
		for (const request of requests) {
			const all = JSON.stringify(request);
			assert.match(all, /PERMITTED_PROJECT_CONTEXT/);
			assert.doesNotMatch(all, /EXCLUDED_RUNTIME_SOURCE|EXCLUDED_AUTO_CONTEXT|DEFAULT_SYSTEM_MUST_NOT_LOAD|DEFAULT_APPEND_MUST_NOT_LOAD|FORBIDDEN_SKILL_DISCOVERY|FORBIDDEN_SKILL_BODY|FORBIDDEN_PROMPT_TEMPLATE|GLOBAL_CONTEXT_MUST_NOT_LOAD/);
		}
		const last = JSON.stringify(requests.at(-1));
		assert.match(last, /Read docs\/api.md instead/);
		assert.match(last, /needle permitted/);
		assert.match(last, /second line/);
		assert.match(last, /project_marker_data/);
		assert.match(last, /excluded/);
		// Automatic context is request-local and never copied into the persisted transcript.
		assert.doesNotMatch(JSON.stringify(session.messages), /PERMITTED_PROJECT_CONTEXT/);
	} finally { session.dispose(); }
});

test("automatic context is checked anew before every provider request", async (t) => {
	const { root, agentDir } = fixture(t);
	const requests: Context[] = [];
	const faux = fauxProvider({
		provider: "context-policy-dynamic-v14", models: [{ id: "fixture", name: "Fixture" }],
		tokensPerSecond: 1_000_000, tokenSize: { min: 1000, max: 1000 },
	});
	faux.setResponses([
		(context) => {
			requests.push(context);
			writeFileSync(join(root, ".agent-no-read.md"), "Use external interface documentation.");
			return fauxAssistantMessage(fauxToolCall("read", { path: "src.ts" }, { id: "after-marker" }), { stopReason: "toolUse" });
		},
		(context) => { requests.push(context); return fauxAssistantMessage("done", { stopReason: "stop" }); },
	]);
	const runtime = await ModelRuntime.create({ authPath: join(agentDir, "auth.json"), modelsPath: null, refreshOnCreate: false });
	runtime.registerNativeProvider(faux.provider);
	const { session } = await createContextPolicyPiSession({ projectRoot: root, agentDir, modelRuntime: runtime, model: faux.getModel() });
	try {
		await session.prompt("Read src.ts");
		assert.equal(requests.length, 2);
		assert.match(JSON.stringify(requests[0]), /PERMITTED_PROJECT_CONTEXT/);
		assert.doesNotMatch(JSON.stringify(requests[1]), /PERMITTED_PROJECT_CONTEXT|needle permitted/);
		assert.match(JSON.stringify(requests[1]), /Use external interface documentation/);
		// The first request already saw the context; this does not claim to erase that historical exposure.
	} finally { session.dispose(); }
});

test("controlled loader excludes cached/explicit sources and deduplicates repeated marker guidance", (t) => {
	const { root } = fixture(t);
	const context = loadContextPolicyFiles(root, ["generated/AGENTS.md", "generated/runtime/INTERNAL_FILE.ts", "src.ts"]);
	assert.equal(context.context.length, 2);
	assert.equal(context.skipped.length, 1);
	assert.doesNotMatch(JSON.stringify(context), /EXCLUDED_AUTO_CONTEXT|EXCLUDED_RUNTIME_SOURCE/);
	writeFileSync(join(root, ".agent-no-read.md"), "Now excluded");
	const next = loadContextPolicyFiles(root, ["src.ts"]);
	assert.equal(next.context.length, 0);
	assert.match(JSON.stringify(next), /Now excluded/);
});

test("guarded read preserves allowed image support and refuses excluded image bytes", async (t) => {
	const { root } = fixture(t);
	const pixel = Buffer.from("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNk+A8AAQUBAScY42YAAAAASUVORK5CYII=", "base64");
	writeFileSync(join(root, "pixel.png"), pixel);
	writeFileSync(join(root, "generated/pixel.png"), pixel);
	const read = createContextPolicyTools(root).find((tool) => tool.name === "read")!;
	const ctx = { cwd: root, model: { input: ["text", "image"] } } as any;
	const allowed = await read.execute("image", { path: "pixel.png" }, undefined, undefined, ctx);
	assert.ok(allowed.content.some((part) => part.type === "image"), JSON.stringify(allowed));
	const denied = await read.execute("image-blocked", { path: "generated/pixel.png" }, undefined, undefined, ctx);
	assert.ok(denied.content.every((part) => part.type === "text"));
	assert.match(JSON.stringify(denied), /excluded/);
	assert.ok(!JSON.stringify(denied).includes(pixel.toString("base64")));
});

test("each paginated or repeated read sees newly created markers", async (t) => {
	const { root } = fixture(t);
	const read = createContextPolicyTools(root).find((tool) => tool.name === "read")!;
	const ctx = { cwd: root } as any;
	const first = await read.execute("first", { path: "src.ts", offset: 1, limit: 1 }, undefined, undefined, ctx);
	assert.match(JSON.stringify(first), /needle permitted/);
	writeFileSync(join(root, ".agent-no-read.md"), "No further context reads.");
	const second = await read.execute("second", { path: "src.ts", offset: 2, limit: 1 }, undefined, undefined, ctx);
	assert.match(JSON.stringify(second), /excluded/);
	assert.doesNotMatch(JSON.stringify(second), /second line|needle permitted/);
});
