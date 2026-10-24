import assert from "node:assert/strict";
import { mkdirSync, mkdtempSync, readFileSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";
import { Message } from "@opencode/ai";
import { createOpenCodeContextPolicyPlugin, type OpenCodePolicyContext } from "../../src/adapters/opencode-context.ts";

async function fixture(t: { after(fn: () => void): void }) {
	const root = mkdtempSync(join(tmpdir(), "opencode-policy-"));
	t.after(() => rmSync(root, { recursive: true, force: true }));
	for (const directory of ["src", "generated"]) mkdirSync(join(root, directory));
	writeFileSync(join(root, "src/app.ts"), "permitted = 1;\n");
	writeFileSync(join(root, "generated/hidden.ts"), "SENTINEL_PRIVATE_SOURCE");
	writeFileSync(join(root, "generated/.agent-no-read.md"), "Use src/app.ts. <!--DISCARD_BLOCK:rules-->");
	writeFileSync(join(root, "AGENTS.md"), "Project guide: use src/app.ts");
	writeFileSync(join(root, "lifecycle.md"), "<!--BLOCK_ID:rules-->\nKeep trusted policy\n<!--/BLOCK_ID:rules-->");
	const hooks = new Map<string, (event: any) => unknown>();
	const tools = new Map<string, any>([["read", { name: "read" }], ["bash", { name: "bash" }], ["task", { name: "task" }], ["mcp_read", { name: "mcp_read" }]]);
	let transform: ((editor: any) => void) | undefined;
	const editor = {
		list: () => [...tools.keys()].map((id) => ({ id })),
		remove: (id: string) => tools.delete(id),
		add: (tool: any) => tools.set(tool.name, tool),
	};
	const plugin = createOpenCodeContextPolicyPlugin({
		projectRoot: root, writeRoots: ["src", "generated"], readOnlyPaths: ["generated"],
		contextPaths: ["generated/hidden.ts"], lifecycleFile: "lifecycle.md",
		commands: { test: { executable: process.execPath, args: ["-e", "console.log('SENTINEL_PRIVATE_SOURCE');process.exit(1)"] } },
	});
	await plugin.setup({
		location: { directory: root },
		tool: {
			async transform(callback) { transform = callback; callback(editor); },
			async hook(name, callback) { hooks.set(`tool:${name}`, callback); },
		},
		session: { async hook(name: string, callback: (event: any) => unknown) { hooks.set(name, callback); } },
		shell: { async hook(name, callback) { hooks.set(`shell:${name}`, callback); } },
	} as OpenCodePolicyContext);
	const invoke = async (name: string, input: unknown) => {
		hooks.get("tool:execute.before")!({ tool: name, input });
		return JSON.parse((await tools.get(name).execute(input, { signal: new AbortController().signal })).content);
	};
	return { root, hooks, tools, invoke, reload: () => transform!(editor) };
}

test("OpenCode V2 strict mode replaces native, MCP and delegation tools and denies direct bypass calls", async (t) => {
	const { hooks, tools, reload } = await fixture(t);
	for (const name of ["read", "write", "edit", "apply_patch", "bash", "task", "mcp_read", "codemode"]) {
		assert.equal(tools.has(name), false);
		assert.throws(() => hooks.get("tool:execute.before")!({ tool: name, input: {} }), /Only policy-controlled tools/);
	}
	assert.throws(() => hooks.get("shell:create.before")!({ command: "cat generated/hidden.ts" }), /shell is disabled/);
	tools.set("mcp_after_refresh", {}); reload();
	assert.equal(tools.has("mcp_after_refresh"), false);
});

test("OpenCode reads/search/list prune excluded content and names, while approved mutations work", async (t) => {
	const { root, invoke } = await fixture(t);
	assert.equal((await invoke("context_read", { path: "generated/hidden.ts" })).status, "excluded");
	for (const [name, input] of [
		["context_grep", { pattern: "SENTINEL_PRIVATE_SOURCE" }],
		["context_find", { pattern: "**/*.ts" }],
		["context_list", { path: "." }],
	] as const) {
		const result = await invoke(name, input);
		assert.equal(result.status, "ok");
		assert.doesNotMatch(JSON.stringify(result), /SENTINEL_PRIVATE_SOURCE|hidden\.ts/);
	}
	assert.equal((await invoke("context_create", { path: "src/new.ts", content: "start" })).status, "ok");
	assert.equal((await invoke("context_edit", { path: "src/new.ts", oldText: "start", newText: "finish" })).status, "ok");
	assert.equal(readFileSync(join(root, "src/new.ts"), "utf8"), "finish");
	assert.equal((await invoke("context_move", { path: "src/new.ts", destination: "generated/new.ts" })).status, "denied");
	assert.equal((await invoke("context_delete", { path: "generated/hidden.ts" })).status, "denied");
	assert.equal((await invoke("context_overwrite", { path: "lifecycle.md", content: "untrusted" })).status, "denied");
});

test("prompt admission strips native attachments, skills and agent mentions before resolution", async (t) => {
	const { hooks } = await fixture(t);
	const event = { prompt: { text: "Inspect project", files: [{ uri: "file:///generated/hidden.ts" }], skills: ["unsafe"], agents: ["explore"] } };
	hooks.get("prompt")!(event);
	assert.deepEqual(event.prompt, { text: "Inspect project", files: [], skills: [], agents: [] });
});

test("every OpenCode request kind replaces native system context and reloads only permitted project context", async (t) => {
	const { hooks, root } = await fixture(t);
	for (const kind of ["context", "compaction", "generate", "title"]) {
		const event = { sessionID: `session:${kind}`, system: [{ type: "text", text: "SENTINEL_PRIVATE_SOURCE native automatic context" }],
			messages: [{ role: "user", content: "inspect" }], tools: { context_read: {}, bash: {}, mcp_read: {} } };
		const original = structuredClone(event.messages);
		hooks.get(kind)!(event);
		// Native Message.make validates the exact provider-bound message shape.
		assert.doesNotThrow(() => Message.make(event.messages.at(-1) as never));
		assert.doesNotMatch(JSON.stringify(event), /SENTINEL_PRIVATE_SOURCE/);
		assert.match(JSON.stringify(event.system), /Keep trusted policy/);
		assert.match(JSON.stringify(event.messages), /Project guide/);
		assert.deepEqual(event.tools, { context_read: {} });
		assert.deepEqual(original, [{ role: "user", content: "inspect" }]);
	}
	writeFileSync(join(root, ".agent-no-read.md"), "Root excluded now");
	assert.throws(() => hooks.get("context")!({ sessionID: "new", system: [], messages: [] }), /request blocked/);
});

test("trusted lifecycle discard works, ordinary assistant directives cannot discard, ephemeral history is request-local", async (t) => {
	const { hooks, root } = await fixture(t);
	const original = [{ role: "user", content: "<!--ephemeral-->\nlarge" }, { role: "assistant", content: "<!--DISCARD_BLOCK:rules-->" }];
	const event = { sessionID: "one", system: [], messages: [...original] };
	hooks.get("context")!(event);
	assert.match(JSON.stringify(event.system), /Keep trusted policy/);
	assert.match(String(event.messages[0]?.content), /EPHEMERAL:/);
	assert.equal(original[0]?.content, "<!--ephemeral-->\nlarge");
	writeFileSync(join(root, "lifecycle.md"), "<!--DISCARD_BLOCK:rules-->");
	const next = { sessionID: "one", system: [], messages: [] };
	hooks.get("context")!(next);
	assert.doesNotMatch(JSON.stringify(next.system), /Keep trusted policy/);
});

test("tool inputs are validated without relying on host schema validation and raw task output stays suppressed", async (t) => {
	const { invoke, root } = await fixture(t);
	writeFileSync(join(root, "src/binary.dat"), Buffer.from("BINARY_SENTINEL\0"));
	const binary = await invoke("context_read", { path: "src/binary.dat" });
	assert.equal(binary.status, "policyError");
	assert.doesNotMatch(JSON.stringify(binary), /BINARY_SENTINEL/);
	for (const [name, input] of [
		["context_create", { path: "src/a", content: 1 }],
		["context_find", { pattern: "*", path: 1 }],
		["context_read", { path: "src/app.ts", command: "cat generated/hidden.ts" }],
		["context_read", { path: "src/app.ts", offset: -1 }],
		["context_test", { command: "override" }],
	] as const) assert.equal((await invoke(name, input)).status, "policyError");
	const result = await invoke("context_test", {});
	assert.equal(result.status, "failed");
	assert.equal(result.unstructuredOutputSuppressed, true);
	assert.doesNotMatch(JSON.stringify(result), /SENTINEL_PRIVATE_SOURCE/);
});
