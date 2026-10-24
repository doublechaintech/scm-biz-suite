import assert from "node:assert/strict";
import { mkdirSync, mkdtempSync, readFileSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";
import { createPiContextMutationTools, preparePiContextCliArgs } from "../src/adapters/pi-cli.ts";

test("native CLI bootstrap disables pre-read resource paths and rejects explicit overrides", () => {
	const prepared = preparePiContextCliArgs(["--print", "inspect"], { fileArgs: [] });
	for (const flag of ["--no-extensions", "--no-mcp", "--no-context-files", "--no-skills", "--no-prompt-templates"]) assert.ok(prepared.includes(flag));
	assert.deepEqual(prepared.slice(-2), ["--print", "inspect"]);
	for (const entry of [{fileArgs:["generated/private.ts"]}, {extensions:["other.ts"]}, {skills:["generated"]}, {promptTemplates:["hidden.md"]}, {themes:["hidden.json"]}, {systemPrompt:"hidden.md"}, {appendSystemPrompt:["hidden.md"]}]) {
		assert.throws(() => preparePiContextCliArgs([], { fileArgs: [], ...entry }), /controlled resource loading/);
	}
});

test("native write/edit schemas preserve permitted edits while excluded source and control files stay untouched", async (t) => {
	const root = mkdtempSync(join(tmpdir(), "pi-cli-files-"));
	t.after(() => rmSync(root, {recursive:true,force:true}));
	mkdirSync(join(root,"src")); mkdirSync(join(root,"generated"));
	writeFileSync(join(root,"generated/.agent-no-read.md"),"Use Assist.");
	writeFileSync(join(root,"generated/private.rs"),"DO_NOT_LEAK");
	const tools = createPiContextMutationTools(root);
	const write = tools[0]!;
	const edit = tools[1]!;
	const invoke = async (tool: any, args: unknown) => JSON.parse((await tool.execute("call",args)).content[0].text);
	assert.equal((await invoke(write,{path:"src/main.rs",content:"first = 1; second = 2;"})).status,"ok");
	assert.equal((await invoke(edit,{path:"src/main.rs",edits:[{oldText:"first",newText:"one"},{oldText:"second",newText:"two"}]})).status,"ok");
	assert.equal(readFileSync(join(root,"src/main.rs"),"utf8"),"one = 1; two = 2;");
	const denied = await invoke(edit,{path:"generated/private.rs",edits:[{oldText:"DO_NOT_LEAK",newText:"changed"}]});
	assert.notEqual(denied.status,"ok"); assert.doesNotMatch(JSON.stringify(denied),/DO_NOT_LEAK/);
	for(const path of ["generated/new.rs","generated/private.rs",".agent-context-kit.json"]) assert.notEqual((await invoke(write,{path,content:"changed"})).status,"ok");
	assert.equal(readFileSync(join(root,"generated/private.rs"),"utf8"),"DO_NOT_LEAK");
	const overlapping = await invoke(edit,{path:"src/main.rs",edits:[{oldText:"one",newText:"changed"},{oldText:"one =",newText:"changed"}]});
	assert.equal(overlapping.status,"policyError");
	assert.equal(readFileSync(join(root,"src/main.rs"),"utf8"),"one = 1; two = 2;");
});
