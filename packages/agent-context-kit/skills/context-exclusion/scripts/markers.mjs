#!/usr/bin/env node
import { sep } from "node:path";
import { fileURLToPath } from "node:url";

// Run from the project root. No command, cwd, guidance or target override arguments.
const [operation, flag, manifest, ...extra] = process.argv.slice(2);
if (!["apply", "check", "generate"].includes(operation) || flag !== "--manifest" || !manifest || extra.length) {
  console.log(JSON.stringify({ status: "error", code: "invalidArguments", message: "Usage: markers.mjs <apply|check|generate> --manifest <project-relative-manifest>" }));
  process.exitCode = 2;
} else {
  const controller = new AbortController();
  const cancel = () => controller.abort();
  process.once("SIGINT", cancel);
  process.once("SIGTERM", cancel);
  let api;
  try {
    // npm forbids native TypeScript stripping inside node_modules; published packages include JS.
    // Checkouts always use current sources, never a stale previous build.
    const installed = fileURLToPath(import.meta.url).split(sep).includes("node_modules");
    api = await import(new URL(installed ? "../../../dist/marker-cli/context-markers.js" : "../../../src/context-markers.ts", import.meta.url).href);
    const { generateWithContextMarkers, maintainContextMarkers } = api;
    const report = operation === "generate"
      ? await generateWithContextMarkers(process.cwd(), manifest, controller.signal)
      : maintainContextMarkers(process.cwd(), manifest, operation);
    console.log(JSON.stringify(report));
    process.exitCode = report.status === "ok" ? 0 : 1;
  } catch (error) {
    const known = api && error instanceof api.ContextMarkerError;
    console.log(JSON.stringify({ status: "error", code: known ? error.code : api ? "maintenanceFailed" : "runtimeUnavailable", message: known ? error.message : api ? "Marker maintenance could not complete." : "The marker CLI runtime is unavailable; use a packaged release or build the CLI runtime in a checkout." }));
    process.exitCode = 2;
  } finally {
    process.removeListener("SIGINT", cancel);
    process.removeListener("SIGTERM", cancel);
  }
}
