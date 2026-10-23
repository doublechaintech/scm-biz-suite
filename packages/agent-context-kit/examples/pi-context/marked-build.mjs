// Trusted host-side adapter. Run with the example project as cwd; expose it only as a fixed build command.
import { resolve, sep } from "node:path";
import { fileURLToPath, pathToFileURL } from "node:url";

try {
  const installed = fileURLToPath(import.meta.url).split(sep).includes("node_modules");
  const { generateWithContextMarkers } = await import(new URL(installed ? "../../dist/marker-cli/context-markers.js" : "../../src/context-markers.ts", import.meta.url).href);
  const generated = await generateWithContextMarkers(process.cwd(), "context-markers.json");
  if (generated.status !== "ok") throw new Error("Generation or marker restoration failed");
  const { getAnswer } = await import(pathToFileURL(resolve("src/main.mjs")).href);
  if (getAnswer() !== 42) throw new Error("Runtime contract failed");
} catch {
  console.log(JSON.stringify({ version: 1, type: "diagnostic", code: "BUILD_FAILURE", severity: "error" }));
  process.exitCode = 1;
}
