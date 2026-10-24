import assert from "node:assert/strict";
import { spawnSync } from "node:child_process";
import { mkdirSync, mkdtempSync, readFileSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

test("native Pi CLI uses guarded tools and fresh context through a real local provider", (t) => {
	const base = mkdtempSync(join(tmpdir(),"pi-native-cli-"));
	const root = join(base,"project");
	mkdirSync(root);
	t.after(() => rmSync(base,{recursive:true,force:true}));
	for(const name of ["generated","src","agent",".pi/extensions"]) mkdirSync(join(root,name),{recursive:true});
	writeFileSync(join(root,"generated/.agent-no-read.md"),"Use Assist and editable application source.");
	writeFileSync(join(root,"generated/private.rs"),"NATIVE_CLI_PRIVATE_SENTINEL");
	writeFileSync(join(root,"AGENTS.md"),"PERMITTED_CLI_PROJECT_GUIDE");
	writeFileSync(join(root,"SYSTEM.md"),"NATIVE_CLI_SYSTEM_SENTINEL");
	writeFileSync(join(root,"APPEND_SYSTEM.md"),"NATIVE_CLI_APPEND_SENTINEL");
	writeFileSync(join(root,".pi/extensions/unsafe.ts"),"throw new Error('UNSAFE_EXTENSION_LOADED');");
	const sdk = import.meta.resolve("@earendil-works/pi-coding-agent");
	const ai = import.meta.resolve("@earendil-works/pi-ai/providers/faux");
	const main = new URL("main.js",sdk).href;
	const entry = new URL("../../src/adapters/pi-cli.ts",import.meta.url).href;
	const runner = join(base,"runner.mjs");
	writeFileSync(runner, `
import assert from 'node:assert/strict';
import {main} from ${JSON.stringify(main)};
import {fauxProvider,fauxAssistantMessage,fauxToolCall} from ${JSON.stringify(ai)};
import {createPiContextCliExtension,preparePiContextCliArgs} from ${JSON.stringify(entry)};
const faux=fauxProvider({provider:'native-cli-policy-test',models:[{id:'fixture',name:'Fixture'}],tokensPerSecond:1000000,tokenSize:{min:1000,max:1000}});
const calls=[['read',{path:'generated/private.rs'}],['read',{path:'generated/other.rs'}],['grep',{path:'.',pattern:'needle'}],['write',{path:'src/main.rs',content:'value = 1;'}],['edit',{path:'src/main.rs',edits:[{oldText:'1',newText:'2'}]}],['write',{path:'generated/new.rs',content:'blocked'}],['bash',{command:'cat generated/private.rs'}]];
let requests=0;
let blockedResults=0;
const check=context=>{requests++;const text=JSON.stringify(context);assert.doesNotMatch(text,/NATIVE_CLI_PRIVATE_SENTINEL|NATIVE_CLI_SYSTEM_SENTINEL|NATIVE_CLI_APPEND_SENTINEL/);assert.match(text,/PERMITTED_CLI_PROJECT_GUIDE/);const last=context.messages.findLast(message=>message.role==='toolResult');if(last?.toolName==='read'){const data=JSON.parse(last.content[0].text);assert.equal(last.isError,true);assert.equal(data.blocked,true);assert.equal(data.retryable,false);blockedResults++;assert.equal(data.attemptsForScope,blockedResults);if(blockedResults===2){assert.equal(data.previouslyBlocked,true);assert.equal(data.guidance,undefined);assert.match(text,/host_policy/);}}if(last?.toolName==='grep')assert.equal(last.isError,false);};
faux.setResponses([...calls.map(([name,args],index)=>context=>{check(context);return fauxAssistantMessage(fauxToolCall(name,args,{id:'native-'+index}),{stopReason:'toolUse'});}),context=>{check(context);return fauxAssistantMessage('Native CLI protection verified.',{stopReason:'stop'});}]);
const args=preparePiContextCliArgs(['--offline','--provider','native-cli-policy-test','--model','fixture','--no-session','--print','Inspect project'],{fileArgs:[]});
await main(args,{extensionFactories:[pi=>pi.registerProvider(faux.provider),createPiContextCliExtension()]});
assert.equal(requests,8);
assert.equal(blockedResults,2);
`);
	const run=spawnSync(process.execPath,["--experimental-strip-types",runner],{
		cwd:root,encoding:"utf8",timeout:30000,maxBuffer:128*1024,
		env:{...process.env,PI_CODING_AGENT_DIR:join(root,"agent"),PI_OFFLINE:"1",PI_SKIP_VERSION_CHECK:"1",NO_COLOR:"1"},
	});
	assert.equal(run.status,0,`${run.stderr}\n${run.stdout}`);
	assert.doesNotMatch(run.stdout+run.stderr,/NATIVE_CLI_PRIVATE_SENTINEL|UNSAFE_EXTENSION_LOADED/);
	assert.match(run.stdout,/Native CLI protection verified/);
	assert.equal(readFileSync(join(root,"src/main.rs"),"utf8"),"value = 2;");
	assert.equal(readFileSync(join(root,"generated/private.rs"),"utf8"),"NATIVE_CLI_PRIVATE_SENTINEL");
});
