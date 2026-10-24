import { spawn } from 'node:child_process';
import { createHash } from 'node:crypto';
import { readFileSync } from 'node:fs';
import { dirname, isAbsolute, join, relative, resolve, sep } from 'node:path';
import { fileURLToPath, pathToFileURL } from 'node:url';
import { Type } from 'typebox';
import { rustDiagnosticSummaries } from './rust-make.mjs';

const ACTIONS = ['query','create','update','delete','expression','list-page','debug'];
const fail = (code, message) => { throw new Error(JSON.stringify({status:'blocked',code,retryable:false,message})); };
function child(executable,args,cwd,signal) {
  return new Promise((resolveResult,reject) => {
    const process = spawn(executable,args,{cwd,shell:false,detached:true,stdio:['ignore','pipe','pipe']});
    let output='',size=0,stopped=false,killTimer;
    const stop=()=>{if(stopped)return;stopped=true;try{globalThis.process.kill(-process.pid,'SIGTERM');}catch{process.kill('SIGTERM');}killTimer=setTimeout(()=>{try{globalThis.process.kill(-process.pid,'SIGKILL');}catch{}},2000);killTimer.unref();};
    const timer=setTimeout(stop,120000);
    signal?.addEventListener('abort',stop,{once:true});
    if(signal?.aborted)stop();
    process.stdout.on('data',chunk=>{size+=chunk.length;if(size>2*1024*1024)stop();else output+=chunk.toString('utf8');});
    process.stderr.on('data',chunk=>{size+=chunk.length;if(size>2*1024*1024)stop();});
    const clean=()=>{clearTimeout(timer);clearTimeout(killTimer);signal?.removeEventListener('abort',stop);};
    process.on('error',error=>{clean();reject(new Error('Configured executable could not start.'));});
    process.on('close',code=>{clean();resolveResult({code,output,stopped});});
  });
}
export function evaluationCounts(report) {
  const summary=report.split(/##\s+[^\n]*Summary\s*\n/)[1]?.split(/\n##\s/)[0];
  if(!summary)return undefined;
  const counts={};
  for(const name of ['Errors','Warnings','Suggestions']) {
    const matches=[...summary.matchAll(new RegExp('^- \\*\\*'+name+'\\*\\*:\\s*(\\d+)\\s*$','gm'))];
    if(matches.length!==1)return undefined;
    counts[name.toLowerCase()]=Number(matches[0][1]);
  }
  if(counts.errors===0 && /^##[^\n]*Errors[^\n]*Must Fix/im.test(report))return undefined;
  return counts;
}
function clip(text) {
  return text.replace(/(Bearer\s+)[A-Za-z0-9._-]+/gi,'$1[REDACTED]').replace(/((?:api[_-]?key|token)\s*[=:]\s*)[^\s"']+/gi,'$1[REDACTED]').slice(0,32768);
}

/** TeaQL-specific integration stays outside the independently publishable generic Context Kit. */
export async function createTeaqlTools(config) {
  const root=resolve(config.projectRoot);
  if(!isAbsolute(config.cargoPath) || !isAbsolute(config.contextKitPath))throw new Error('Host executable and Context Kit paths must be absolute.');
  const {ContextFiles}=await import(pathToFileURL(join(config.contextKitPath,'src/context-files.ts')));
  const {withContextMarkers,maintainContextMarkers}=await import(pathToFileURL(join(config.contextKitPath,'src/context-markers.ts')));
  const {runControlledTask}=await import(pathToFileURL(join(config.contextKitPath,'src/controlled-tasks.ts')));
  const files=new ContextFiles(root);
  const local=value=>{
    if(typeof value!=='string'||!value||isAbsolute(value))throw new Error('Expected a project-relative host path.');
    const path=resolve(root,value),part=relative(root,path);
    if(!part||part==='..'||part.startsWith(`..${sep}`)||isAbsolute(part))throw new Error('Host path escapes project.');
    return path;
  };
  const model=local(config.model),manifest=local(config.markerManifest),app=local(config.appDirectory);
  const outputs=[...config.outputs];
  for(const output of outputs)local(output);
  const digest=()=>{
    const body=files.read(model);
    if(!body.length || /<_include\b/.test(body.toString('utf8')))fail('MODEL_SCOPE_UNSUPPORTED','This integration requires a saved single-file KSML model.');
    return createHash('sha256').update(body).digest('hex');
  };
  let validated,inventory=false;
  const version=async signal=>{
    const result=await child(config.cargoPath,['teaql','--version'],root,signal);
    if(result.code!==0||result.stopped||result.output.trim()!=='teaql 2.0.14')fail('CLIENT_VERSION_MISMATCH','cargo-teaql must be exactly 2.0.14.');
  };
  const command=async (operation,signal)=>{
    digest();await version(signal);
    const result=await child(config.cargoPath,['teaql','--input',model,...operation],root,signal);
    if(result.stopped)fail('COMMAND_INTERRUPTED','The controlled TeaQL command was cancelled or exceeded its timeout/output limit.');
    return result;
  };
  const service=async signal=>{
    const result=await command(['services'],signal);
    inventory=result.code===0 && /\brust-lib-core\b/.test(result.output);
    if(!inventory)fail('TARGET_NOT_ADVERTISED','The service did not advertise rust-lib-core.');
    return result;
  };
  const execute=async (args,signal)=>{
    const before=digest();
    if(args.operation==='evaluate') {
      validated=undefined;
      const result=await command(['evaluate'],signal);
      const counts=evaluationCounts(result.output);
      if(result.code===0&&counts?.errors===0&&digest()===before)validated=before;
      return {status:validated?'model_ready':'evaluation_failed',model,counts:counts??null,report:clip(result.output),generationAllowed:!!validated};
    }
    if(args.operation==='services') {const result=await service(signal);return {status:'ok',inventory:clip(result.output)};}
    if(args.operation==='assist') {
      if(!ACTIONS.includes(args.action)||typeof args.target!=='string'||!/^[a-z][a-z0-9_]*(?:\.[a-z][a-z0-9_]*)?$/.test(args.target))fail('INVALID_ASSIST_TARGET','Use a supported action and the exact KSML entity or entity.field name; nested paths and command flags are forbidden.');
      const result=await command([`rust-assist-${args.action}/${args.target}`],signal);
      return {status:result.code===0?'ok':'MISSING_ASSIST',action:args.action,target:args.target,output:clip(result.output)};
    }
    if(args.operation==='generate') {
      if(validated!==before)fail('EVALUATION_REQUIRED','Call teaql with operation=evaluate first. Generation requires zero errors for the unchanged saved model.');
      if(!inventory)await service(signal);
      files.require(manifest);
      // The host permits only library targets, preserving existing application-owned src and guides.
      const reports=[];
      for(const output of outputs) {
        if(digest()!==before)fail('MODEL_CHANGED','The model changed. Evaluate again before generation.');
        const {result: generated,markers}=await withContextMarkers(root,config.markerManifest,()=>command(['rust-lib-core','--output',output,'--cwd',root],signal));
        if(generated.code!==0 || /["']?success["']?\s*[:=]\s*false/i.test(generated.output))fail('GENERATION_FAILED','Library generation failed. Markers have been restored; do not inspect generated source.');
        reports.push({output,status:'ok',markers});
      }
      if(digest()!==before)fail('MODEL_CHANGED','Generated libraries are stale because the model changed. Re-evaluate and regenerate.');
      const markers=maintainContextMarkers(root,config.markerManifest,'check');
      return {status:'ok',target:'rust-lib-core',outputs,reports,markers,applicationSourcePreserved:true};
    }
    fail('INVALID_OPERATION','Use evaluate, services, assist or generate. Arbitrary commands are not supported.');
  };
  let queue=Promise.resolve();
  const schema=Type.Object({operation:Type.Union(['evaluate','services','assist','generate'].map(value=>Type.Literal(value))),action:Type.Optional(Type.Union(ACTIONS.map(value=>Type.Literal(value)))),target:Type.Optional(Type.String())},{additionalProperties:false});
  const teaql={name:'teaql',label:'TeaQL',parameters:schema,executionMode:'sequential',
    description:'Run controlled Rust TeaQL operations for the host-configured model. Use evaluate first; generate refreshes generated libraries only after zero errors and restores read-exclusion markers. For progressive Assist use operation=assist, action=query/create/update/delete/expression/list-page/debug, target=exact KSML entity or entity.field. No bash or manual terminal copy/paste is needed.',
    async execute(_id,args,signal){
      if(!args||Object.keys(args).some(key=>!['operation','action','target'].includes(key)))fail('INVALID_ARGUMENTS','Only operation, action and target are accepted.');
      const work=queue.then(()=>execute(args,signal));queue=work.catch(()=>{});
      const result=await work;
      if(['evaluation_failed','MISSING_ASSIST'].includes(result.status))throw new Error(JSON.stringify(result));
      return {content:[{type:'text',text:JSON.stringify(result)}],details:result};
    }};
  const checks=['build','test'].map(task=>({name:`app_${task}`,label:`Application ${task}`,executionMode:'sequential',parameters:Type.Object({},{additionalProperties:false}),
    description:`Run the fixed application make ${task} target. Use app_build to get compiler errors; target/debug executables are not error logs. Returns policy-filtered Rust locations/codes, allowed source excerpts and real test counts. No arbitrary commands or raw process output.`,
    async execute(_id,args,signal){
      if(!args||Object.keys(args).length)fail('INVALID_ARGUMENTS','This tool accepts an empty object only.');
      const adapter=fileURLToPath(new URL('./rust-make.mjs',import.meta.url));
      const result=await runControlledTask(root,task,{executable:process.execPath,args:[adapter,config.makePath??'/usr/bin/make',app,task,...(config.evidenceDirectory?[config.evidenceDirectory]:[])],includeAllowedSource:true,diagnosticSummaries:rustDiagnosticSummaries},signal);
      if(task==='test'&&result.tests&&result.tests.passed+result.tests.failed+result.tests.skipped===0)result.testingLimitation='No test cases were executed. A successful exit does not establish business-test coverage.';
      if(result.status!=='passed')throw new Error(JSON.stringify(result));
      return {content:[{type:'text',text:JSON.stringify(result)}],details:result};
    }}));
  return [teaql,...checks];
}

export async function createTools({projectRoot}) {
  const directory=dirname(fileURLToPath(import.meta.url));
  const plan=JSON.parse(readFileSync(join(directory,'projects.json'),'utf8'));
  const configured=plan.projects?.find(project=>resolve(project.projectRoot)===resolve(projectRoot));
  return configured?createTeaqlTools(configured):[];
}
