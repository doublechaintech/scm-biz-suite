import { mkdirSync, readFileSync, writeFileSync } from "node:fs";
import { resolve } from "node:path";
import { fileURLToPath, pathToFileURL } from "node:url";
import ts from "typescript";

const root = fileURLToPath(new URL("../", import.meta.url));

/** Compile the small built-in-only CLI dependency tree for npm's node_modules layout. */
export function buildMarkerCli(outputDirectory = resolve(root, "dist/marker-cli")) {
	mkdirSync(outputDirectory, { recursive: true });
	writeFileSync(resolve(outputDirectory, ".agent-no-read.md"), "# Compiled marker CLI runtime\n\nRead src/context-markers.ts and docs/context-marker-maintenance.md for the implementation and interface. Rebuild with npm run build:marker-cli.\n");
	for (const name of ["context-access", "context-files", "controlled-tasks", "context-markers"]) {
		const fileName = resolve(root, "src", `${name}.ts`);
		const result = ts.transpileModule(readFileSync(fileName, "utf8"), {
			fileName, reportDiagnostics: true,
			compilerOptions: { target: ts.ScriptTarget.ES2022, module: ts.ModuleKind.ESNext, rewriteRelativeImportExtensions: true },
		});
		if (result.diagnostics?.some((diagnostic) => diagnostic.category === ts.DiagnosticCategory.Error)) {
			throw new Error("Unable to compile marker CLI runtime");
		}
		writeFileSync(resolve(outputDirectory, `${name}.js`), result.outputText);
	}
}

if (process.argv[1] && pathToFileURL(resolve(process.argv[1])).href === import.meta.url) buildMarkerCli();
