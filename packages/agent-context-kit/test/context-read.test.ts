import assert from "node:assert/strict";
import {chmodSync,closeSync,ftruncateSync,mkdirSync,mkdtempSync,openSync,rmSync,writeFileSync,writeSync} from "node:fs";
import {tmpdir} from "node:os";
import {join} from "node:path";
import test from "node:test";
import {ContextFiles} from "../src/context-files.ts";
import {ContextReadError,inspectContextRead} from "../src/context-read.ts";
import {createContextPolicyTools} from "../src/adapters/pi-context.ts";
import {registerPiPolicyFeedback} from "../src/adapters/pi-policy-feedback.ts";

function fixture(t:test.TestContext){const root=mkdtempSync(join(tmpdir(),"context-read-errors-"));t.after(()=>rmSync(root,{recursive:true,force:true}));return root;}
function sparse(path:string,header:Buffer,size:number){const fd=openSync(path,"wx");try{writeSync(fd,header);ftruncateSync(fd,size);}finally{closeSync(fd);}}

test("ELF and oversized text are classified from a bounded header without returning binary bytes",async t=>{
	const root=fixture(t),files=new ContextFiles(root);
	sparse(join(root,"program"),Buffer.from("\x7fELF\0PRIVATE_BINARY_CANARY"),110*1024*1024);
	sparse(join(root,"large.txt"),Buffer.from("x".repeat(600)),11*1024*1024);
	for(const [path,code] of [["program","UNSUPPORTED_BINARY"],["large.txt","FILE_TOO_LARGE"],["absent.txt","FILE_NOT_FOUND"],[".","UNSUPPORTED_FILE_TYPE"]]){
		assert.throws(()=>inspectContextRead(files,path!),error=>error instanceof ContextReadError&&error.details.code===code);
	}
	const read=createContextPolicyTools(root)[0]!;
	const hooks=new Map<string,(event:any)=>any>();registerPiPolicyFeedback({on(name:string,fn:any){hooks.set(name,fn);}} as never,root);
	const invoke=async(path:string)=>read.execute("test",{path},undefined,undefined,{cwd:root} as never);
	const first=await invoke("program");
	assert.doesNotMatch(JSON.stringify(first),/PRIVATE_BINARY_CANARY/);
	assert.equal(first.details.blocked,true);assert.equal(first.details.retryable,false);
	const converted=hooks.get("tool_result")!({toolName:"read",input:{path:"program"},...first});
	assert.equal(converted.isError,true);assert.equal(converted.details.code,"UNSUPPORTED_BINARY");
	const again=hooks.get("tool_result")!({toolName:"read",input:{path:"program",offset:2},...await invoke("program")});
	assert.equal(again.details.attemptsForScope,2);assert.equal(again.details.previouslyBlocked,true);assert.match(again.details.message,/app_build/);
	assert.ok(hooks.get("context_with_system")!({messages:[]}));
	writeFileSync(join(root,"program"),"now ordinary text");
	assert.equal(hooks.get("context_with_system")!({messages:[]}),undefined);
	const success=await invoke("program");assert.match(JSON.stringify(success.content),/now ordinary text/);
});

test("excluded content takes precedence over file inspection and long-line errors are non-retryable",async t=>{
	const root=fixture(t);mkdirSync(join(root,"generated"));writeFileSync(join(root,"generated/.agent-no-read.md"),"Use Assist.");
	const read=createContextPolicyTools(root)[0]!;
	const denied=await read.execute("test",{path:"generated/absent"},undefined,undefined,{cwd:root} as never);
	assert.equal(denied.details.status,"excluded");
	writeFileSync(join(root,"line.txt"),"x".repeat(200000));
	const huge=await read.execute("test",{path:"line.txt"},undefined,undefined,{cwd:root} as never);
	assert.equal(huge.details.code,"OUTPUT_LINE_TOO_LARGE");assert.equal(huge.details.retryable,false);
});

test("permission failures have explicit non-retryable errors",{skip:process.platform==="win32"||process.getuid?.()===0},t=>{
	const root=fixture(t),path=join(root,"private.txt");writeFileSync(path,"PERMISSION_CANARY");chmodSync(path,0);
	try{assert.throws(()=>inspectContextRead(new ContextFiles(root),path),error=>error instanceof ContextReadError&&error.details.code==="READ_ACCESS_DENIED");}
	finally{chmodSync(path,0o600);}
});
