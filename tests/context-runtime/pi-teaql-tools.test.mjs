import assert from 'node:assert/strict';
import {chmodSync,mkdirSync,mkdtempSync,readFileSync,rmSync,writeFileSync,existsSync} from 'node:fs';
import {tmpdir} from 'node:os';
import {dirname,join} from 'node:path';
import {fileURLToPath} from 'node:url';
import test from 'node:test';
import {createTeaqlTools,evaluationCounts} from '../../integrations/pi-teaql/tools.mjs';
const contextKitPath=fileURLToPath(new URL('../../packages/agent-context-kit',import.meta.url));

test('evaluation gate requires complete unambiguous semantic counts',()=>{
 assert.deepEqual(evaluationCounts('## 📊 Summary\n- **Errors**: 0\n- **Warnings**: 2\n- **Suggestions**: 1\n\n## Warnings\ntext'),{errors:0,warnings:2,suggestions:1});
 assert.equal(evaluationCounts('success=true'),undefined);
 assert.equal(evaluationCounts('## Summary\n- **Errors**: 0\n- **Warnings**: 0\n- **Suggestions**: 0\n## ❌ Errors (Must Fix)\nerror'),undefined);
});

test('controlled TeaQL tool verifies each client call, gates changed models, restores markers and preserves application source',async t=>{
 const root=mkdtempSync(join(tmpdir(),'teaql-host-tool-'));t.after(()=>rmSync(root,{recursive:true,force:true}));
 for(const path of ['models','app/src','standalone/lib','app/lib','guidance'])mkdirSync(join(root,path),{recursive:true});
 writeFileSync(join(root,'models/model.xml'),'<root name="example-service"><school _name="School"/></root>');
 writeFileSync(join(root,'app/src/main.rs'),'KEEP_BUSINESS_SOURCE');
 writeFileSync(join(root,'guidance/generated.md'),'Use Assist.');
 writeFileSync(join(root,'context-markers.json'),JSON.stringify({version:1,markers:[{directory:'standalone',guidanceFile:'guidance/generated.md'},{directory:'app/lib',guidanceFile:'guidance/generated.md'}]}));
 const cargo=join(root,'fake-cargo.mjs');
 writeFileSync(cargo,`#!${process.execPath}\nimport{appendFileSync,existsSync,readFileSync,mkdirSync,writeFileSync,rmSync}from'node:fs';import{join}from'node:path';const a=process.argv.slice(2);appendFileSync('calls.jsonl',JSON.stringify(a)+'\\n');if(a[1]==='--version'){console.log(existsSync('bad-version')?'teaql 2.0.13':'teaql 2.0.14');}else if(a.includes('evaluate')){console.log('## Summary\\n- **Errors**: '+(existsSync('model-errors')?1:0)+'\\n- **Warnings**: 0\\n- **Suggestions**: 0');}else if(a.includes('services')){console.log('rust-lib-core');}else if(a.some(x=>x.startsWith('rust-assist-'))){console.log('CURRENT_ASSIST_API');}else if(a.includes('rust-lib-core')){const out=a[a.indexOf('--output')+1];rmSync(join(out,'lib'),{recursive:true,force:true});mkdirSync(join(out,'lib'),{recursive:true});writeFileSync(join(out,'lib/generated.txt'),'PRIVATE_GENERATED_CONTENT');}else{process.exitCode=1;}`);
 chmodSync(cargo,0o700);
 const tools=await createTeaqlTools({projectRoot:root,cargoPath:cargo,contextKitPath,model:'models/model.xml',outputs:['standalone','app'],markerManifest:'context-markers.json',appDirectory:'app'});
 const teaql=tools[0];const invoke=async args=>JSON.parse((await teaql.execute('test',args,new AbortController().signal)).content[0].text);
 await assert.rejects(()=>invoke({operation:'generate'}),/EVALUATION_REQUIRED/);
 assert.equal((await invoke({operation:'evaluate'})).generationAllowed,true);
 const generated=await invoke({operation:'generate'});
 assert.equal(generated.status,'ok');assert.equal(generated.applicationSourcePreserved,true);
 assert.equal(readFileSync(join(root,'app/src/main.rs'),'utf8'),'KEEP_BUSINESS_SOURCE');
 assert.ok(existsSync(join(root,'standalone/.agent-no-read.md')));assert.ok(existsSync(join(root,'app/lib/.agent-no-read.md')));
 assert.doesNotMatch(JSON.stringify(generated),/PRIVATE_GENERATED_CONTENT/);
 assert.equal((await invoke({operation:'assist',action:'query',target:'school.name'})).output.trim(),'CURRENT_ASSIST_API');
 await assert.rejects(()=>invoke({operation:'assist',action:'query',target:'school;cat secret'}),/INVALID_ASSIST_TARGET/);
 await assert.rejects(()=>invoke({operation:'assist',action:'query',target:'school',command:'cat secret'}),/INVALID_ARGUMENTS/);
 writeFileSync(join(root,'models/model.xml'),'<root name="changed-service"><school/></root>');
 await assert.rejects(()=>invoke({operation:'generate'}),/EVALUATION_REQUIRED/);
 writeFileSync(join(root,'model-errors'),'');await assert.rejects(()=>invoke({operation:'evaluate'}),/evaluation_failed/);
 writeFileSync(join(root,'bad-version'),'');await assert.rejects(()=>invoke({operation:'assist',action:'query',target:'school'}),/CLIENT_VERSION_MISMATCH/);
 const calls=readFileSync(join(root,'calls.jsonl'),'utf8').trim().split('\n').map(JSON.parse);
 for(let index=0;index<calls.length;index++){if(calls[index][1]!=='--version')assert.deepEqual(calls[index-1],['teaql','--version']);}
});

test('Rust Make diagnostics expose metadata and permitted snippets, suppress excluded content, and report zero tests explicitly',async t=>{
 const {parseRustMakeOutput}=await import('../../integrations/pi-teaql/rust-make.mjs');
 const root=mkdtempSync(join(tmpdir(),'rust-make-diagnostics-'));t.after(()=>rmSync(root,{recursive:true,force:true}));
 for(const dir of ['models','app/src','app/lib'])mkdirSync(join(root,dir),{recursive:true});
 writeFileSync(join(root,'models/model.xml'),'<root name="test-service"><school/></root>');
 writeFileSync(join(root,'app/src/main.rs'),'fn main() { let value: u32 = "wrong"; }\n');
 writeFileSync(join(root,'app/lib/.agent-no-read.md'),'Use Assist.');
 writeFileSync(join(root,'app/lib/private.rs'),'EXCLUDED_DIAGNOSTIC_CANARY');
 const fakeMake=join(root,'make.mjs');
 writeFileSync(fakeMake,`#!${process.execPath}\nif(process.argv.at(-1)==='build'){console.error('error[E0308]: PRIVATE_COMPILER_MESSAGE\\n --> src/main.rs:1:13\\nPRIVATE_ASSERTION_VALUE\\nerror[E0599]: PRIVATE_GENERATED_MESSAGE\\n --> lib/private.rs:1:1');process.exitCode=1;}else{console.log('test result: ok. 0 passed; 0 failed; 0 ignored; 0 measured; 0 filtered out; finished in 0.00s');}`);chmodSync(fakeMake,0o700);
 const tools=await createTeaqlTools({projectRoot:root,cargoPath:process.execPath,contextKitPath,model:'models/model.xml',outputs:['app'],markerManifest:'context-markers.json',appDirectory:'app',makePath:fakeMake});
 const build=tools.find(tool=>tool.name==='app_build');let failure;
 try{await build.execute('test',{},new AbortController().signal);assert.fail('Expected build failure');}catch(error){failure=JSON.parse(error.message);}
 assert.equal(failure.status,'failed');assert.equal(failure.exitCode,1);
 assert.equal(failure.diagnostics[0].code,'E0308');assert.equal(failure.diagnostics[0].access,'allow');assert.ok(failure.diagnostics[0].source.length);
 assert.equal(failure.diagnostics[1].access,'excluded');assert.equal(failure.diagnostics[1].source,undefined);
 assert.doesNotMatch(JSON.stringify(failure),/PRIVATE_COMPILER_MESSAGE|PRIVATE_ASSERTION_VALUE|PRIVATE_GENERATED_MESSAGE|EXCLUDED_DIAGNOSTIC_CANARY/);
 const result=await tools.find(tool=>tool.name==='app_test').execute('test',{},new AbortController().signal);
 assert.deepEqual(result.details.tests,{passed:0,failed:0,skipped:0});assert.match(result.details.testingLimitation,/No test cases/);
 const metadata=parseRustMakeOutput('error[E0432]: hidden message\n --> src/main.rs:9:2\ntest result: FAILED. 2 passed; 1 failed; 3 ignored; 0 measured; 0 filtered out;','/project/app');
 assert.equal(metadata[0].path,'/project/app/src/main.rs');assert.equal(metadata[0].code,'E0432');assert.deepEqual(metadata.at(-1),{version:1,type:'testSummary',passed:2,failed:1,skipped:3});
});
