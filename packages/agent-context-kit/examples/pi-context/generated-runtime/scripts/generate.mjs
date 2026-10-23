import { mkdirSync, rmSync, writeFileSync } from "node:fs";

// Simulate a generator that deletes its entire output directory, including the marker.
rmSync("generated", { recursive: true, force: true });
mkdirSync("generated");
const canary = ["GENERATED", "IMPLEMENTATION", "CANARY"].join("_");
writeFileSync("generated/runtime.mjs", `// ${canary}\nexport function answer() { return ${6 * 7}; }\n`);
writeFileSync("generated/AGENTS.md", "Generated internals are not project guidance.\n");
