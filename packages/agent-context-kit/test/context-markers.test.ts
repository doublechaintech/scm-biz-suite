import assert from "node:assert/strict";
import { execFileSync, spawn } from "node:child_process";
import { cpSync, existsSync, lstatSync, mkdirSync, mkdtempSync, readFileSync, readdirSync, rmSync, statSync, symlinkSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { dirname, join } from "node:path";
import { fileURLToPath } from "node:url";
import test from "node:test";

import { ContextMarkerError, generateWithContextMarkers, maintainContextMarkers, withContextMarkers } from "../src/context-markers.ts";
import { checkContextAccess } from "../src/context-access.ts";
import { buildMarkerCli } from "../scripts/build-marker-cli.ts";

function fixture(t: test.TestContext) {
	const base = mkdtempSync(join(tmpdir(), "context-markers-"));
	const root = join(base, "project");
	mkdirSync(join(root, "docs"), { recursive: true });
	writeFileSync(join(root, "docs/guidance.md"), "# Generated runtime\r\n\r\nRead docs/api.md.\r\n");
	const manifest = {
		version: 1, markers: [{ directory: "generated", guidanceFile: "docs/guidance.md" }],
		generator: { executable: process.execPath, args: ["--input-type=module", "-e", `
			import {mkdirSync, rmSync, writeFileSync} from 'node:fs';
			rmSync('generated', {recursive:true,force:true}); mkdirSync('generated');
			writeFileSync('generated/runtime.ts', 'GENERATED_PRIVATE_CANARY');
		`] },
	};
	const save = () => writeFileSync(join(root, "context-markers.json"), JSON.stringify(manifest));
	save();
	t.after(() => rmSync(base, { recursive: true, force: true }));
	return { base, root, manifest, save, marker: join(root, "generated/.agent-no-read.md") };
}

function runCli(root: string, args: string[], script = fileURLToPath(new URL("../skills/context-exclusion/scripts/markers.mjs", import.meta.url))) {
	let output: Buffer;
	let status = 0;
	try { output = execFileSync(process.execPath, [script, ...args], { cwd: root, stdio: ["ignore", "pipe", "pipe"] }); }
	catch (error) { const failed = error as { stdout: Buffer; status: number }; output = failed.stdout; status = failed.status; }
	return { status, result: JSON.parse(output.toString()) as any };
}

test("host callback restores snapshotted markers after rejection and guidance changes", async (t) => {
	const {root,marker}=fixture(t);
	await assert.rejects(()=>withContextMarkers(root,"context-markers.json",async()=>{
		rmSync(join(root,"generated"),{recursive:true,force:true});
		writeFileSync(join(root,"docs/guidance.md"),"Changed during operation");
		throw new Error("Host operation failed");
	}),/Host operation failed/);
	assert.match(readFileSync(marker,"utf8"),/Read docs\/api.md/);
	assert.doesNotMatch(readFileSync(marker,"utf8"),/Changed during operation/);
});

test("apply creates canonical Markdown, is idempotent and updates only the marker", (t) => {
	const { root, marker } = fixture(t);
	const first = maintainContextMarkers(root, "context-markers.json");
	assert.equal(first.markers[0]?.status, "created");
	assert.equal(readFileSync(marker, "utf8"), "# Generated runtime\n\nRead docs/api.md.\n");
	writeFileSync(join(root, "generated/runtime.ts"), "GENERATED_PRIVATE_CANARY");
	const before = statSync(marker, { bigint: true });
	assert.equal(maintainContextMarkers(root, "context-markers.json").markers[0]?.status, "unchanged");
	const after = statSync(marker, { bigint: true });
	assert.equal(after.ino, before.ino);
	assert.equal(after.mtimeNs, before.mtimeNs);
	writeFileSync(join(root, "docs/guidance.md"), "Use the new public API.\n");
	assert.equal(maintainContextMarkers(root, "context-markers.json", "check").markers[0]?.status, "outdated");
	assert.equal(maintainContextMarkers(root, "context-markers.json").markers[0]?.status, "updated");
	assert.equal(readFileSync(marker, "utf8"), "Use the new public API.\n");
	assert.equal(readFileSync(join(root, "generated/runtime.ts"), "utf8"), "GENERATED_PRIVATE_CANARY");
	assert.deepEqual(readdirSync(dirname(marker)).sort(), [".agent-no-read.md", "runtime.ts"]);
});

test("check never creates directories or markers and returns needsUpdate for missing state", (t) => {
	const { root, marker } = fixture(t);
	const result = maintainContextMarkers(root, "context-markers.json", "check");
	assert.equal(result.status, "needsUpdate");
	assert.equal(result.markers[0]?.status, "missing");
	assert.equal(existsSync(dirname(marker)), false);
});

test("empty guidance is a valid marker; oversized old markers are replaced without copying content", (t) => {
	const { root, marker } = fixture(t);
	writeFileSync(join(root, "docs/guidance.md"), " \r\n");
	maintainContextMarkers(root, "context-markers.json");
	assert.equal(readFileSync(marker).length, 0);
	assert.equal(checkContextAccess(root, "generated").status, "excluded");
	writeFileSync(marker, "PRIVATE_OLD_BODY".repeat(1000));
	const result = maintainContextMarkers(root, "context-markers.json");
	assert.equal(result.markers[0]?.status, "updated");
	assert.doesNotMatch(JSON.stringify(result), /PRIVATE_OLD_BODY/);
});

test("nested markers preserve parent guidance and removing manifest entries never deletes old markers", (t) => {
	const { root, manifest, save, marker } = fixture(t);
	writeFileSync(join(root, "docs/child.md"), "Child hint");
	manifest.markers.push({ directory: "generated/runtime", guidanceFile: "docs/child.md" });
	save();
	maintainContextMarkers(root, "context-markers.json");
	const decision = checkContextAccess(root, "generated/runtime");
	assert.equal(decision.status === "excluded" && decision.markerPath, marker);
	manifest.markers.pop(); save();
	maintainContextMarkers(root, "context-markers.json");
	assert.equal(existsSync(join(root, "generated/runtime/.agent-no-read.md")), true);
});

test("invalid plans fail before writing any marker", (t) => {
	const { root, marker, manifest } = fixture(t);
	const cases: unknown[] = [
		{ ...manifest, version: 2 }, { ...manifest, markers: [] },
		{ ...manifest, markers: [...manifest.markers, ...manifest.markers] },
		{ ...manifest, markers: [...manifest.markers, { directory: "../outside", guidanceFile: "docs/guidance.md" }] },
		{ ...manifest, markers: [{ directory: ".", guidanceFile: "docs/guidance.md" }] },
		{ ...manifest, markers: [{ directory: "generated/.agent-no-read.md/child", guidanceFile: "docs/guidance.md" }] },
		{ ...manifest, markers: [{ directory: "generated", guidanceFile: "/etc/passwd" }] },
		{ ...manifest, generator: { executable: process.execPath, timeoutMs: -1 } },
	];
	for (const value of cases) {
		writeFileSync(join(root, "invalid.json"), JSON.stringify(value));
		assert.throws(() => maintainContextMarkers(root, "invalid.json"), ContextMarkerError);
		assert.equal(existsSync(marker), false);
	}
	writeFileSync(join(root, "invalid.json"), "not json");
	assert.throws(() => maintainContextMarkers(root, "invalid.json"), ContextMarkerError);
	assert.throws(() => maintainContextMarkers(root, "../invalid.json"), ContextMarkerError);
});

test("guidance and manifest sources must survive regeneration outside all output directories", (t) => {
	const { root, manifest, save, marker } = fixture(t);
	mkdirSync(join(root, "generated"));
	writeFileSync(join(root, "generated/guidance.md"), "Unstable guidance");
	manifest.markers[0]!.guidanceFile = "generated/guidance.md"; save();
	assert.throws(() => maintainContextMarkers(root, "context-markers.json"), ContextMarkerError);
	assert.equal(existsSync(marker), false);
	manifest.markers[0]!.guidanceFile = "docs/guidance.md"; save();
	writeFileSync(join(root, "generated/manifest.json"), JSON.stringify(manifest));
	assert.throws(() => maintainContextMarkers(root, "generated/manifest.json"), ContextMarkerError);
	for (const body of [Buffer.from([0xff]), Buffer.alloc(8193, 65)]) {
		writeFileSync(join(root, "docs/guidance.md"), body);
		assert.throws(() => maintainContextMarkers(root, "context-markers.json"), ContextMarkerError);
	}
});

test("target and marker symlinks are rejected without touching their destinations", (t) => {
	const { base, root, marker } = fixture(t);
	const outside = join(base, "outside"); mkdirSync(outside);
	symlinkSync(outside, join(root, "generated"));
	assert.throws(() => maintainContextMarkers(root, "context-markers.json"), ContextMarkerError);
	assert.equal(existsSync(join(outside, ".agent-no-read.md")), false);
	rmSync(join(root, "generated")); mkdirSync(join(root, "generated"));
	writeFileSync(join(outside, "marker"), "Original external data");
	symlinkSync(join(outside, "marker"), marker);
	assert.throws(() => maintainContextMarkers(root, "context-markers.json"), ContextMarkerError);
	assert.equal(readFileSync(join(outside, "marker"), "utf8"), "Original external data");
	assert.equal(lstatSync(marker).isSymbolicLink(), true);
});

test("a symlinked project root is supported without allowing output links", (t) => {
	const { base, root, marker } = fixture(t);
	const alias = join(base, "alias"); symlinkSync(root, alias);
	assert.equal(maintainContextMarkers(alias, "context-markers.json").status, "ok");
	assert.equal(existsSync(marker), true);
});

test("generation restores markers after complete output-directory deletion", async (t) => {
	const { root, marker } = fixture(t);
	for (let index = 0; index < 2; index++) {
		const result = await generateWithContextMarkers(root, "context-markers.json");
		assert.equal(result.status, "ok");
		assert.equal(result.markers[0]?.status, "created");
		assert.equal(existsSync(marker), true);
		assert.equal(checkContextAccess(root, "generated/runtime.ts").status, "excluded");
		assert.doesNotMatch(JSON.stringify(result), /GENERATED_PRIVATE_CANARY/);
	}
});

test("failed generation restores the original guidance snapshot and suppresses raw process output", async (t) => {
	const { root, manifest, save, marker } = fixture(t);
	manifest.generator.args[2] += `
		writeFileSync('docs/guidance.md', 'UNTRUSTED_CHANGED_GUIDANCE');
		console.log('GENERATED_PRIVATE_CANARY'); console.error('GENERATED_PRIVATE_CANARY');
		process.exitCode = 7;
	`;
	save();
	const result = await generateWithContextMarkers(root, "context-markers.json");
	assert.equal(result.status, "generationFailed");
	assert.equal(result.generator?.exitCode, 7);
	assert.equal(readFileSync(marker, "utf8"), "# Generated runtime\n\nRead docs/api.md.\n");
	assert.doesNotMatch(JSON.stringify(result), /GENERATED_PRIVATE_CANARY|UNTRUSTED_CHANGED_GUIDANCE/);
});

test("cancellation after directory removal still restores its marker", { timeout: 5000 }, async (t) => {
	const { root, manifest, save, marker } = fixture(t);
	manifest.generator.args[2] = `
		import {rmSync, writeFileSync} from 'node:fs';
		rmSync('generated', {recursive:true,force:true});
		writeFileSync('generator-started', 'yes'); setInterval(() => {}, 1000);
	`;
	save();
	const controller = new AbortController();
	const running = generateWithContextMarkers(root, "context-markers.json", controller.signal);
	try {
		for (let index = 0; index < 100 && !existsSync(join(root, "generator-started")); index++) await new Promise((resolve) => setTimeout(resolve, 10));
		assert.equal(existsSync(join(root, "generator-started")), true);
		assert.equal(existsSync(marker), false);
	} finally { controller.abort(); }
	const result = await running;
	assert.equal(result.generator?.status, "cancelled");
	assert.equal(result.status, "generationFailed");
	assert.equal(existsSync(marker), true);
});

test("unsafe regeneration replacements fail restoration without writing outside the project", async (t) => {
	const { base, root, manifest, save } = fixture(t);
	const outside = join(base, "outside"); mkdirSync(outside);
	manifest.generator.args[2] = `
		import {rmSync, symlinkSync} from 'node:fs';
		rmSync('generated', {recursive:true,force:true}); symlinkSync(${JSON.stringify(outside)}, 'generated');
	`;
	save();
	const result = await generateWithContextMarkers(root, "context-markers.json");
	assert.equal(result.status, "maintenanceFailed");
	assert.equal(result.generator?.status, "passed");
	assert.equal(existsSync(join(outside, ".agent-no-read.md")), false);
});

test("CLI has fixed operations, JSON-only output and meaningful exit codes", (t) => {
	const { root } = fixture(t);
	assert.equal(runCli(root, ["check", "--manifest", "context-markers.json"]).status, 1);
	assert.equal(runCli(root, ["apply", "--manifest", "context-markers.json"]).status, 0);
	assert.equal(runCli(root, ["check", "--manifest", "context-markers.json"]).status, 0);
	assert.equal(runCli(root, ["generate", "--manifest", "context-markers.json"]).result.status, "ok");
	const invalid = runCli(root, ["apply", "--manifest", "context-markers.json", "--command", "touch arbitrary"]);
	assert.equal(invalid.status, 2);
	assert.equal(invalid.result.code, "invalidArguments");
	assert.equal(runCli(root, ["apply", "--manifest", "missing.json"]).status, 2);
});

test("packaged CLI works inside node_modules without TypeScript stripping or any dependencies", (t) => {
	const { base, root } = fixture(t);
	const installed = join(base, "node_modules/@teaql/agent-context-kit");
	const script = join(installed, "skills/context-exclusion/scripts/markers.mjs");
	mkdirSync(dirname(script), { recursive: true });
	cpSync(fileURLToPath(new URL("../skills/context-exclusion/scripts/markers.mjs", import.meta.url)), script);
	writeFileSync(join(installed, "package.json"), '{"type":"module"}');
	buildMarkerCli(join(installed, "dist/marker-cli"));
	assert.equal(existsSync(join(installed, "src")), false);
	const applied = runCli(root, ["apply", "--manifest", "context-markers.json"], script);
	assert.equal(applied.status, 0);
	assert.equal(applied.result.markers[0]?.status, "created");
	assert.equal(runCli(root, ["generate", "--manifest", "context-markers.json"], script).status, 0);
	rmSync(join(installed, "dist"), { recursive: true });
	const missingRuntime = runCli(root, ["check", "--manifest", "context-markers.json"], script);
	assert.equal(missingRuntime.status, 2);
	assert.equal(missingRuntime.result.code, "runtimeUnavailable");
});

test("timeout and spawn failures preserve a restored marker and remain failures", async (t) => {
	const { root, manifest, marker } = fixture(t);
	const timed = { ...manifest, generator: {
		...manifest.generator, timeoutMs: 150,
		args: ["--input-type=module", "-e", "import {rmSync} from 'node:fs'; rmSync('generated', {recursive:true,force:true}); setInterval(() => {}, 1000);"],
	} };
	writeFileSync(join(root, "timed.json"), JSON.stringify(timed));
	const timeout = await generateWithContextMarkers(root, "timed.json");
	assert.equal(timeout.status, "generationFailed");
	assert.equal(timeout.generator?.status, "timedOut");
	assert.equal(existsSync(marker), true);
	writeFileSync(join(root, "missing-command.json"), JSON.stringify({ ...manifest, generator: { executable: join(root, "missing-generator") } }));
	const failed = await generateWithContextMarkers(root, "missing-command.json");
	assert.equal(failed.status, "generationFailed");
	assert.equal(failed.generator?.status, "executionError");
	assert.equal(existsSync(marker), true);
});

test("CLI SIGTERM cancels its generator and restores the deleted output marker", { timeout: 5000 }, async (t) => {
	if (process.platform === "win32") return t.skip("SIGTERM handling requires POSIX");
	const { root, manifest, save, marker } = fixture(t);
	manifest.generator.args[2] = `
		import {rmSync,writeFileSync} from 'node:fs';
		rmSync('generated',{recursive:true,force:true}); writeFileSync('cli-started','yes');
		console.log('GENERATED_PRIVATE_CANARY'); setInterval(() => {},1000);
	`;
	save();
	const script = fileURLToPath(new URL("../skills/context-exclusion/scripts/markers.mjs", import.meta.url));
	const child = spawn(process.execPath, [script, "generate", "--manifest", "context-markers.json"], { cwd: root, stdio: ["ignore", "pipe", "pipe"] });
	let stdout = "";
	child.stdout.on("data", (chunk) => { stdout += chunk.toString(); });
	const done = new Promise<number | null>((resolve, reject) => { child.once("error", reject); child.once("close", resolve); });
	try {
		for (let index = 0; index < 150 && !existsSync(join(root, "cli-started")); index++) await new Promise((resolve) => setTimeout(resolve, 10));
		assert.equal(existsSync(join(root, "cli-started")), true);
		assert.equal(existsSync(marker), false);
	} finally { child.kill("SIGTERM"); }
	assert.equal(await done, 1);
	const report = JSON.parse(stdout);
	assert.equal(report.generator.status, "cancelled");
	assert.equal(report.status, "generationFailed");
	assert.equal(existsSync(marker), true);
	assert.doesNotMatch(stdout, /GENERATED_PRIVATE_CANARY/);
});
