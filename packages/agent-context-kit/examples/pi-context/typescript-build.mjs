// Trusted adapter: TypeScript may read the full project; only diagnostic metadata is emitted.
import ts from "typescript";
import { resolve } from "node:path";

const configPath = resolve("tsconfig.json");
const report = (diagnostic) => {
  const position = diagnostic.file && diagnostic.start !== undefined
    ? diagnostic.file.getLineAndCharacterOfPosition(diagnostic.start)
    : undefined;
  console.log(JSON.stringify({
    version: 1,
    type: "diagnostic",
    code: `TS${diagnostic.code}`,
    severity: diagnostic.category === ts.DiagnosticCategory.Error ? "error"
      : diagnostic.category === ts.DiagnosticCategory.Warning ? "warning" : "info",
    ...(diagnostic.file ? { path: diagnostic.file.fileName } : {}),
    ...(position ? { line: position.line + 1, column: position.character + 1 } : {}),
  }));
};

const config = ts.readConfigFile(configPath, ts.sys.readFile);
if (config.error) {
  report(config.error);
  process.exitCode = 1;
} else {
  const parsed = ts.parseJsonConfigFileContent(config.config, ts.sys, process.cwd());
  const program = ts.createProgram(parsed.fileNames, parsed.options);
  const emitted = program.emit();
  const diagnostics = [...parsed.errors, ...ts.getPreEmitDiagnostics(program), ...emitted.diagnostics];
  for (const diagnostic of diagnostics) report(diagnostic);
  process.exitCode = diagnostics.some((diagnostic) => diagnostic.category === ts.DiagnosticCategory.Error) ? 1 : 0;
}
