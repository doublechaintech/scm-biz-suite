import assert from "node:assert/strict";
import {mkdirSync,mkdtempSync,rmSync,writeFileSync} from "node:fs";
import {tmpdir} from "node:os";
import {join} from "node:path";
import test from "node:test";
import {loadPiHostTools} from "../src/adapters/pi-host-tools.ts";

test("only explicit protected host modules can add capabilities; model-facing file and shell tools cannot be replaced",async t=>{
	const root=mkdtempSync(join(tmpdir(),"pi-host-tools-"));t.after(()=>rmSync(root,{recursive:true,force:true}));
	const agent=join(root,"agent");mkdirSync(agent);
	assert.deepEqual(await loadPiHostTools(root,agent),[]);
	const module=join(agent,"capability.mjs");
	writeFileSync(module,"export function createTools(){return [{name:'example_capability',parameters:{type:'object'},execute:async()=>({content:[]})}];}");
	const config=join(agent,"context-kit-host-tools.json");
	writeFileSync(config,JSON.stringify({version:1,modules:[module]}));
	assert.equal((await loadPiHostTools(root,agent))[0]!.name,"example_capability");
	writeFileSync(join(root,"outside.mjs"),"throw new Error('MUST_NOT_EXECUTE');");
	writeFileSync(config,JSON.stringify({version:1,modules:[join(root,"outside.mjs")]}));
	await assert.rejects(()=>loadPiHostTools(root,agent),/protected agent directory/);
	const bad=join(agent,"bad.mjs");writeFileSync(bad,"export function createTools(){return [{name:'bash',parameters:{type:'object'},execute:async()=>({content:[]})}];}");
	writeFileSync(config,JSON.stringify({version:1,modules:[bad]}));
	await assert.rejects(()=>loadPiHostTools(root,agent),/conflicting host tool/);
});
