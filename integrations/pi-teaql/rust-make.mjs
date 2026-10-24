import { spawn } from 'node:child_process';
import { mkdirSync, writeFileSync } from 'node:fs';
import { isAbsolute, join, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

export const rustDiagnosticSummaries = {
 E0308:'A Rust type does not match the required type.',
 E0599_PURPOSED_QUERY:'Rust E0599: this query is already a PurposedQuery executable stage. Apply all filters, projection, ordering and paging before purpose(...), then execute with the existing comment and purpose. Preserve the original Q entry point and projection. Regeneration does not repair query stage ordering.',
 E0599:'A method is unavailable. Consult current entity and field Assist before a localized repair.',
 E0425:'A referenced value or function is not in scope.',
 E0412:'A referenced Rust type is not in scope.',
 E0432:'A Rust import cannot be resolved.',
 E0433:'A Rust module or type path cannot be resolved.',
 E0277:'A required trait bound is not satisfied.',
 E0061:'The argument count does not match the function signature.',
 E0609:'A referenced field does not exist.',
 E0382:'A moved value is being used again.',
 E0502:'Conflicting Rust borrows were detected.',
 E0282:'Rust needs an explicit type annotation.',
 RUST_ERROR:'Rust compilation failed. Inspect the permitted source location and relevant Assist.',
 RUST_WARNING:'The Rust compiler reported a warning.',
};

/** Parse metadata/counts only. Never forward compiler messages, snippets, assertion values or test names. */
export function parseRustMakeOutput(text, appDirectory) {
 const diagnostics=[];let pending;
 const tests={passed:0,failed:0,skipped:0};let summaries=0;
 const flush=()=>{if(pending){diagnostics.push(pending);pending=undefined;}};
 for(const line of text.split(/\r?\n/)) {
  const error=/^(error|warning)(?:\[(E\d{4})\])?:/.exec(line);
  if(error){
   flush();
   // Classify a fixed public runtime stage; never forward arbitrary compiler text.
   const purposedQuery=error[2]==='E0599' && /^error\[E0599\]: no method named `[A-Za-z_][A-Za-z0-9_]*` found for struct `(?:[A-Za-z_][A-Za-z0-9_]*::)*PurposedQuery(?:<[^`\r\n]*>)?`/.test(line);
   pending={version:1,type:'diagnostic',severity:error[1]==='error'?'error':'warning',code:purposedQuery?'E0599_PURPOSED_QUERY':error[2]??(error[1]==='error'?'RUST_ERROR':'RUST_WARNING')};
  }
  const location=/^\s*-->\s+(.+?):(\d+):(\d+)\s*$/.exec(line);
  if(location&&pending){pending.path=resolve(appDirectory,location[1]);pending.line=Number(location[2]);pending.column=Number(location[3]);flush();}
  const summary=/^test result: (?:ok|FAILED)\. (\d+) passed; (\d+) failed; (\d+) ignored;/.exec(line.trim());
  if(summary){summaries++;tests.passed+=Number(summary[1]);tests.failed+=Number(summary[2]);tests.skipped+=Number(summary[3]);}
 }
 flush();
 return [...diagnostics,...(summaries?[{version:1,type:'testSummary',...tests}]:[])];
}

export async function runRustMake({appDirectory,makePath,task,evidenceDirectory}) {
 if(!isAbsolute(appDirectory)||!isAbsolute(makePath)||!['build','test'].includes(task))throw new Error('Invalid fixed Make invocation.');
 return new Promise((resolveResult,reject)=>{
  const child=spawn(makePath,['-C',appDirectory,task],{shell:false,stdio:['ignore','pipe','pipe'],env:{...process.env,CARGO_TERM_COLOR:'never'}});
  const chunks=[];let size=0,overflow=false;
  const capture=chunk=>{size+=chunk.length;if(size<=8*1024*1024)chunks.push(chunk);else{overflow=true;child.kill('SIGTERM');}};
  child.stdout.on('data',capture);child.stderr.on('data',capture);
  child.on('error',()=>reject(new Error('The fixed Make executable could not start.')));
  child.on('close',code=>{
   const text=Buffer.concat(chunks).toString('utf8');
   const records=parseRustMakeOutput(text,appDirectory);
   if(evidenceDirectory){
    if(!isAbsolute(evidenceDirectory)){reject(new Error('Evidence directory must be a host-owned absolute path.'));return;}
    try{mkdirSync(evidenceDirectory,{recursive:true,mode:0o700});writeFileSync(join(evidenceDirectory,`${task}-${Date.now()}-${process.pid}.log`),text,{mode:0o600});}
    catch{reject(new Error('Host diagnostic evidence could not be saved.'));return;}
   }
   resolveResult({code:overflow?1:code??1,records});
  });
 });
}

if(process.argv[1]&&resolve(process.argv[1])===fileURLToPath(import.meta.url)) {
 try {
  const [makePath,appDirectory,task,evidenceDirectory,...extra]=process.argv.slice(2);
  if(extra.length)throw new Error('Unexpected arguments');
  const result=await runRustMake({makePath,appDirectory,task,evidenceDirectory});
  for(const record of result.records)console.log(JSON.stringify(record));
  process.exitCode=result.code;
 }catch{console.log(JSON.stringify({version:1,type:'diagnostic',severity:'error',code:'RUST_ERROR'}));process.exitCode=1;}
}
