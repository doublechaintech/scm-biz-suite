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
