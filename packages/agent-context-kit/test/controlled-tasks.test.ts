import assert from "node:assert/strict";
import { existsSync, mkdirSync, mkdtempSync, readFileSync, rmSync, symlinkSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { runControlledTask, snapshotTaskCommand, type ControlledTaskCommand } from "../src/controlled-tasks.ts";

function fixture(t: test.TestContext) {
	const base = mkdtempSync(join(tmpdir(), "controlled-tasks-"));
	const root = join(base, "project");
	mkdirSync(join(root, "generated"), { recursive: true });
	mkdirSync(join(root, "src"));
	writeFileSync(join(root, "generated/.agent-no-read.md"), "Use docs/api.md and the fixed build/test tools.");
	writeFileSync(join(root, "generated/runtime.ts"), "EXCLUDED_SOURCE_CANARY");
	writeFileSync(join(root, "src/main.ts"), "// allowed before\nconst value: number = 'allowed';\n// allowed after\n");
	t.after(() => rmSync(base, { recursive: true, force: true }));
	return { base, root };
}
function command(script: string, extra: Partial<ControlledTaskCommand> = {}): ControlledTaskCommand {
	return { executable: process.execPath, args: ["--input-type=module", "-e", script], ...extra };
}
const diagnostic = (path: string, code = "TS2322", extra: object = {}) => ({ version: 1, type: "diagnostic", path, code, line: 2, column: 7, severity: "error", ...extra });
const emit = (data: unknown) => `console.log(${JSON.stringify(JSON.stringify(data))});`;

test("build internally uses excluded inputs but raw stdout/stderr and excluded excerpts never return", async (t) => {
	const { root } = fixture(t);
	const result = await runControlledTask(root, "build", command(`
		import { readFileSync, writeFileSync } from 'node:fs';
		const body = readFileSync('generated/runtime.ts', 'utf8');
		writeFileSync('build-used-excluded-input', body.length.toString());
		console.log(body); console.error(body);
		${emit(diagnostic("generated/runtime.ts", "TS2322", { message: "EXCLUDED_SOURCE_CANARY", excerpt: "EXCLUDED_SOURCE_CANARY", stack: "EXCLUDED_SOURCE_CANARY" }))}
		process.exitCode = 1;
	`, { includeAllowedSource: true }));
	assert.equal(result.status, "failed");
	assert.equal(result.exitCode, 1);
	assert.equal(readFileSync(join(root, "build-used-excluded-input"), "utf8"), "22");
	assert.equal(result.diagnostics[0]?.location?.path, "generated/runtime.ts");
	assert.equal(result.diagnostics[0]?.location?.column, 7);
	assert.equal(result.diagnostics[0]?.code, "TS2322");
	assert.match(result.diagnostics[0]?.summary ?? "", /not assignable/);
	assert.equal(result.diagnostics[0]?.access, "excluded");
	assert.equal(result.diagnostics[0]?.source, undefined);
	assert.equal(result.exclusions[0]?.source, "project_marker_data");
	assert.doesNotMatch(JSON.stringify(result), /EXCLUDED_SOURCE_CANARY|console\.log|readFileSync/);
});

test("allowed source excerpts are re-read from disk rather than copied from process diagnostics", async (t) => {
	const { root } = fixture(t);
	const result = await runControlledTask(root, "test", command(emit(diagnostic("src/main.ts", "TEST_FAILURE", { message: "EXCLUDED_SOURCE_CANARY", source: "EXCLUDED_SOURCE_CANARY" })), { includeAllowedSource: true }));
	assert.equal(result.status, "failed"); // Reported errors also fail a zero-exit command.
	assert.equal(result.diagnostics[0]?.access, "allow");
	assert.equal(result.diagnostics[0]?.source?.length, 3);
	assert.match(JSON.stringify(result.diagnostics[0]?.source), /allowed before|allowed after/);
	assert.doesNotMatch(JSON.stringify(result), /EXCLUDED_SOURCE_CANARY/);
});

test("unknown codes and arbitrary messages do not become summaries, even for allowed paths", async (t) => {
	const { root } = fixture(t);
	const result = await runControlledTask(root, "build", command(emit(diagnostic("src/main.ts", "EXCLUDED_SOURCE_CANARY", { message: "EXCLUDED_SOURCE_CANARY" }))));
	assert.equal(result.diagnostics[0]?.code, undefined);
	assert.equal(result.diagnostics[0]?.source, undefined);
	assert.match(result.diagnostics[0]?.summary ?? "", /no registered description/);
	assert.doesNotMatch(JSON.stringify(result), /EXCLUDED_SOURCE_CANARY/);
});

test("trusted code summaries and numeric test counts are preserved without names or assertion bodies", async (t) => {
	const { root } = fixture(t);
	const result = await runControlledTask(root, "test", command(
		emit(diagnostic("src/main.ts", "CUSTOM_ERROR")) + emit({ version: 1, type: "testSummary", passed: 3, failed: 1, skipped: 2, name: "EXCLUDED_SOURCE_CANARY", expected: "EXCLUDED_SOURCE_CANARY" }),
		{ diagnosticSummaries: { CUSTOM_ERROR: "An invariant check failed." } },
	));
	assert.deepEqual(result.tests, { passed: 3, failed: 1, skipped: 2 });
	assert.equal(result.diagnostics[0]?.summary, "An invariant check failed.");
	assert.doesNotMatch(JSON.stringify(result), /EXCLUDED_SOURCE_CANARY/);
});

test("markers added by the process are applied when final diagnostics are rendered", async (t) => {
	const { root } = fixture(t);
	const result = await runControlledTask(root, "build", command(`
		import { writeFileSync } from 'node:fs';
		${emit(diagnostic("src/main.ts"))}
		writeFileSync('src/.agent-no-read.md', 'New marker');
	`, { includeAllowedSource: true }));
	assert.equal(result.diagnostics[0]?.access, "excluded");
	assert.equal(result.diagnostics[0]?.source, undefined);
	assert.doesNotMatch(JSON.stringify(result), /allowed before|allowed after/);
});

test("symlink aliases are excluded, external and missing diagnostic paths do not echo arbitrary strings", async (t) => {
	const { base, root } = fixture(t);
	symlinkSync(join(root, "generated/runtime.ts"), join(root, "alias.ts"));
	writeFileSync(join(base, "outside.ts"), "EXCLUDED_SOURCE_CANARY");
	const result = await runControlledTask(root, "build", command(
		emit(diagnostic("alias.ts")) + emit(diagnostic("../outside.ts")) + emit(diagnostic("EXCLUDED_SOURCE_CANARY")),
		{ includeAllowedSource: true },
	));
	assert.equal(result.diagnostics[0]?.access, "excluded");
	assert.equal(result.diagnostics[0]?.location?.path, "alias.ts");
	assert.equal(result.diagnostics[1]?.access, "outOfScope");
	assert.equal(result.diagnostics[1]?.location, undefined);
	assert.equal(result.diagnostics[2]?.location, undefined);
	assert.doesNotMatch(JSON.stringify(result), /EXCLUDED_SOURCE_CANARY|\.\.\/outside/);
});

test("plain and malformed output is suppressed while exit status remains available", async (t) => {
	const { root } = fixture(t);
	const result = await runControlledTask(root, "build", command(`
		console.log('src/main.ts:2: error: EXCLUDED_SOURCE_CANARY');
		console.log('{ malformed JSON EXCLUDED_SOURCE_CANARY');
		console.log(JSON.stringify({ version: 2, type: 'diagnostic', message: 'EXCLUDED_SOURCE_CANARY' }));
		console.error(${JSON.stringify(JSON.stringify(diagnostic("src/main.ts")))});
	`));
	assert.equal(result.status, "passed");
	assert.equal(result.exitCode, 0);
	assert.deepEqual(result.diagnostics, []);
	assert.equal(result.unstructuredOutputSuppressed, true);
	assert.doesNotMatch(JSON.stringify(result), /EXCLUDED_SOURCE_CANARY/);
});

test("streamed JSONL handles chunk boundaries and drops oversized lines; diagnostics are bounded", async (t) => {
	const { root } = fixture(t);
	const json = JSON.stringify(diagnostic("src/main.ts", "TS2322", { message: "中文😀" }));
	const result = await runControlledTask(root, "build", command(`
		process.stdout.write('x'.repeat(70000) + '\\n');
		const bytes = Buffer.from(${JSON.stringify(json)} + '\\n');
		process.stdout.write(bytes.subarray(0, bytes.length - 5));
		process.stdout.write(bytes.subarray(bytes.length - 5));
		for (let i = 0; i < 70; i++) ${emit(diagnostic("src/main.ts"))}
	`));
	assert.equal(result.diagnostics.length, 64);
	assert.equal(result.diagnosticsTruncated, true);
	assert.equal(result.diagnostics[0]?.code, "TS2322");
});

test("timeout, cancellation, output overflow and spawn errors never echo raw output or argv", async (t) => {
	const { root } = fixture(t);
	const timeout = await runControlledTask(root, "test", command("setInterval(() => {}, 1000)", { timeoutMs: 150 }));
	assert.equal(timeout.status, "timedOut");
	const controller = new AbortController();
	const running = runControlledTask(root, "test", command("setInterval(() => {}, 1000)"), controller.signal);
	setTimeout(() => controller.abort(), 100);
	assert.equal((await running).status, "cancelled");
	const cancelled = await runControlledTask(root, "build", command("import {writeFileSync} from 'node:fs'; writeFileSync('must-not-run', 'x');"), AbortSignal.abort());
	assert.equal(cancelled.status, "cancelled");
	assert.equal(existsSync(join(root, "must-not-run")), false);
	for (const stream of ["stdout", "stderr"]) {
		const overflow = await runControlledTask(root, "test", command(`process.${stream}.write('EXCLUDED_SOURCE_CANARY'.repeat(1000)); setInterval(() => {}, 1000);`, { maxOutputBytes: 1024 }));
		assert.equal(overflow.status, "outputLimit");
		assert.doesNotMatch(JSON.stringify(overflow), /EXCLUDED_SOURCE_CANARY/);
	}
	const missing = await runControlledTask(root, "build", { executable: join(root, "EXCLUDED_SOURCE_CANARY") });
	assert.equal(missing.status, "executionError");
	assert.doesNotMatch(JSON.stringify(missing), /EXCLUDED_SOURCE_CANARY/);
});

test("task configuration validation rejects invalid limits and copies mutable command inputs", () => {
	const args = ["--version"];
	const summaries = { CUSTOM_ERROR: "Original reason" };
	const snapshot = snapshotTaskCommand({ executable: process.execPath, args, diagnosticSummaries: summaries });
	args[0] = "--help";
	summaries.CUSTOM_ERROR = "Changed reason";
	assert.deepEqual(snapshot.args, ["--version"]);
	assert.equal(snapshot.diagnosticSummaries?.CUSTOM_ERROR, "Original reason");
	assert.throws(() => snapshotTaskCommand({ executable: "" }));
	assert.throws(() => snapshotTaskCommand({ executable: process.execPath, timeoutMs: Infinity }));
	assert.throws(() => snapshotTaskCommand({ executable: process.execPath, maxOutputBytes: 0 }));
	assert.throws(() => snapshotTaskCommand({ executable: process.execPath, diagnosticSummaries: { bad: "Unstable code" } }));
});

test("real TypeScript build adapter reports an excluded implementation error without its source", async (t) => {
	const { root } = fixture(t);
	writeFileSync(join(root, "tsconfig.json"), JSON.stringify({ compilerOptions: { noEmit: true, strict: true }, include: ["generated/*.ts"] }));
	writeFileSync(join(root, "generated/runtime.ts"), 'const EXCLUDED_SOURCE_CANARY: number = "private generated value";');
	const adapter = new URL("../examples/pi-context/typescript-build.mjs", import.meta.url);
	const { fileURLToPath } = await import("node:url");
	const result = await runControlledTask(root, "build", {
		executable: process.execPath, args: [fileURLToPath(adapter)], includeAllowedSource: true,
	});
	assert.equal(result.status, "failed");
	assert.ok(result.diagnostics.some((diagnostic) => diagnostic.code === "TS2322" && diagnostic.access === "excluded" && diagnostic.location?.path === "generated/runtime.ts"));
	assert.doesNotMatch(JSON.stringify(result), /EXCLUDED_SOURCE_CANARY|private generated value/);
});

test("real Node test reporter preserves test counts while suppressing assertion values and test output", async (t) => {
	const { root } = fixture(t);
	writeFileSync(join(root, "generated/example.test.mjs"), `
		import test from 'node:test';
		import assert from 'node:assert/strict';
		test('EXCLUDED_SOURCE_CANARY', () => {
			console.log('EXCLUDED_SOURCE_CANARY');
			assert.equal('EXCLUDED_SOURCE_CANARY', 'private expected value');
		});
		test('passing', () => {});
		test.skip('skipped', () => {});
	`);
	const { fileURLToPath } = await import("node:url");
	const reporter = fileURLToPath(new URL("../examples/pi-context/node-test-jsonl.mjs", import.meta.url));
	const result = await runControlledTask(root, "test", {
		executable: process.execPath, args: ["--test", `--test-reporter=${reporter}`, "generated/example.test.mjs"], includeAllowedSource: true,
	});
	assert.equal(result.status, "failed");
	assert.deepEqual(result.tests, { passed: 1, failed: 1, skipped: 1 });
	assert.ok(result.diagnostics.some((diagnostic) => diagnostic.code === "TEST_FAILURE" && diagnostic.access === "excluded"));
	assert.doesNotMatch(JSON.stringify(result), /EXCLUDED_SOURCE_CANARY|private expected value|assert\.equal/);
});

test("error diagnostics beyond the return limit still make a zero-exit command fail", async (t) => {
	const { root } = fixture(t);
	const warning = emit(diagnostic("src/main.ts", "TS2322", { severity: "warning" }));
	const result = await runControlledTask(root, "build", command(`for(let i=0;i<64;i++) { ${warning} } ${emit(diagnostic("src/main.ts"))}`));
	assert.equal(result.exitCode, 0);
	assert.equal(result.status, "failed");
	assert.equal(result.diagnostics.length, 64);
	assert.equal(result.diagnosticsTruncated, true);
});

test("POSIX timeout kills descendants that ignore SIGTERM", { timeout: 5000 }, async (t) => {
	if (process.platform === "win32") return t.skip("Windows needs a host process-tree facility");
	const { root } = fixture(t);
	const descendant = `
		require('node:process').on('SIGTERM', () => {});
		setTimeout(() => require('node:fs').writeFileSync('orphan-side-effect', 'bad'), 650);
		setInterval(() => {}, 1000);
	`;
	const result = await runControlledTask(root, "test", command(`
		import {spawn} from 'node:child_process';
		spawn(process.execPath, ['-e', ${JSON.stringify(descendant)}], {stdio:'inherit'});
		process.on('SIGTERM', () => {});
		setInterval(() => {}, 1000);
	`, { timeoutMs: 200 }));
	assert.equal(result.status, "timedOut");
	await new Promise((resolve) => setTimeout(resolve, 450));
	assert.equal(existsSync(join(root, "orphan-side-effect")), false);
});
