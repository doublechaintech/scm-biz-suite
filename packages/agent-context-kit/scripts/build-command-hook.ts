import { mkdirSync, readFileSync, writeFileSync } from "node:fs";
import { dirname, resolve } from "node:path";
import { fileURLToPath, pathToFileURL } from "node:url";
import ts from "typescript";

const root = fileURLToPath(new URL("../", import.meta.url));

/** Node cannot strip TypeScript inside node_modules; ship a built-in-only JS hook. */
export function buildCommandHook(outputDirectory = resolve(root, "dist/command-hook")) {
	mkdirSync(outputDirectory, { recursive: true });
	writeFileSync(resolve(outputDirectory, ".agent-no-read.md"), "# Compiled command-hook runtime\n\nRead src/adapters/command-hook.ts and docs/command-hook-adapters.md. Rebuild with npm run build:command-hook.\n");
	for (const name of ["parser", "session", "read-guard", "adapters/workspace-runtime", "adapters/command-hook"]) {
		const fileName = resolve(root, "src", `${name}.ts`);
		const result = ts.transpileModule(readFileSync(fileName, "utf8"), {
			fileName, reportDiagnostics: true,
			compilerOptions: { target: ts.ScriptTarget.ES2022, module: ts.ModuleKind.ESNext, rewriteRelativeImportExtensions: true },
		});
		if (result.diagnostics?.some((diagnostic) => diagnostic.category === ts.DiagnosticCategory.Error)) {
			throw new Error("Unable to compile command-hook runtime");
		}
		const destination = resolve(outputDirectory, `${name}.js`);
		mkdirSync(dirname(destination), { recursive: true });
		writeFileSync(destination, result.outputText);
	}
}

if (process.argv[1] && pathToFileURL(resolve(process.argv[1])).href === import.meta.url) buildCommandHook();
