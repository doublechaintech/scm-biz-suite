import assert from "node:assert/strict";
import { cpSync, mkdtempSync, rmSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import { fileURLToPath } from "node:url";

import { generateWithContextMarkers, maintainContextMarkers } from "../../src/context-markers.ts";
import { ContextFiles } from "../../src/context-files.ts";
import { runControlledTask } from "../../src/controlled-tasks.ts";

const root = mkdtempSync(join(tmpdir(), "context-marker-example-"));
try {
	cpSync(fileURLToPath(new URL("./generated-runtime", import.meta.url)), root, { recursive: true });
	const first = await generateWithContextMarkers(root, "context-markers.json");
	const rebuilt = await generateWithContextMarkers(root, "context-markers.json");
	assert.equal(first.status, "ok");
	assert.equal(rebuilt.status, "ok");
	const files = new ContextFiles(root);
	const read = files.check("generated/runtime.mjs");
	const search = files.grep({ pattern: "GENERATED_IMPLEMENTATION_CANARY" });
	assert.equal(read.status, "excluded");
	assert.equal(search.status, "ok");
	if (search.status === "ok") assert.equal(search.matches.length, 0);
	const build = await runControlledTask(root, "build", {
		executable: process.execPath, args: [fileURLToPath(new URL("./marked-build.mjs", import.meta.url))],
	});
	const tests = await runControlledTask(root, "test", {
		executable: process.execPath,
		args: ["--test", `--test-reporter=${fileURLToPath(new URL("./node-test-jsonl.mjs", import.meta.url))}`, "test/runtime.test.mjs"],
	});
	assert.equal(build.status, "passed");
	assert.equal(tests.status, "passed");
	console.log(JSON.stringify({ first, rebuilt, check: maintainContextMarkers(root, "context-markers.json", "check"), read, search, build, tests }, null, 2));
} finally { rmSync(root, { recursive: true, force: true }); }
