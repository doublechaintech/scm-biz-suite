import assert from "node:assert/strict";
import fs from "node:fs";
import { syncBuiltinESMExports } from "node:module";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { ContextAccessDenied, ContextFiles } from "../src/context-files.ts";

function fixture(t: test.TestContext) {
	const root = fs.mkdtempSync(join(tmpdir(), "context-files-"));
	fs.mkdirSync(join(root, "generated/runtime"), { recursive: true });
	fs.mkdirSync(join(root, "src"));
	fs.writeFileSync(join(root, "generated/.agent-no-read.md"), "Read docs/api.md instead.");
	fs.writeFileSync(join(root, "generated/runtime/INTERNAL_FILENAME.ts"), "TOP_SECRET_SOURCE needle");
	fs.writeFileSync(join(root, "src/index.ts"), "before\nneedle allowed\nafter\nneedle again\n");
	fs.writeFileSync(join(root, ".hidden"), "needle hidden");
	t.after(() => fs.rmSync(root, { recursive: true, force: true }));
	return { root, files: new ContextFiles(root) };
}

test("find/grep prune before readdir or source reads, including hidden/ignore override requests", (t) => {
	const { root, files } = fixture(t);
	const visited: string[] = [];
	const opened: string[] = [];
	const originalReadDir = fs.readdirSync;
	const originalOpen = fs.openSync;
	t.mock.method(fs, "readdirSync", (path: fs.PathLike, ...args: unknown[]) => {
		visited.push(String(path));
		return (originalReadDir as any)(path, ...args);
	});
	t.mock.method(fs, "openSync", (path: fs.PathLike, ...args: unknown[]) => {
		opened.push(String(path));
		return (originalOpen as any)(path, ...args);
	});
	syncBuiltinESMExports();
	try {
		const found = files.find({ pattern: "**/*", noIgnore: true, hidden: true } as any);
		const searched = files.grep({ pattern: "needle", noIgnore: true, hidden: true } as any);
		assert.equal(found.status, "ok");
		assert.equal(searched.status, "ok");
		assert.ok(!visited.includes(join(root, "generated")));
		assert.ok(!visited.some((path) => path.includes("generated/runtime")));
		assert.ok(!opened.some((path) => path.includes("INTERNAL_FILENAME")));
		for (const result of [found, searched]) {
			assert.doesNotMatch(JSON.stringify(result), /INTERNAL_FILENAME|TOP_SECRET_SOURCE/);
			if (result.status === "ok") {
				assert.equal(result.skipped.length, 1);
				assert.equal(result.skipped[0]?.guidance, "Read docs/api.md instead.");
			}
		}
		const hidden = files.find({ pattern: ".hidden" });
		if (hidden.status === "ok") assert.ok(hidden.files.includes(".hidden"));
		if (searched.status === "ok") assert.ok(searched.matches.some((match) => match.path === ".hidden"));
	} finally {
		t.mock.restoreAll();
		syncBuiltinESMExports();
	}
});

test("explicit excluded search/list/read targets return useful denials", (t) => {
	const { files } = fixture(t);
	for (const result of [files.find({ path: "generated", pattern: "*" }), files.grep({ path: "generated/runtime/INTERNAL_FILENAME.ts", pattern: "needle" }), files.list("generated")]) {
		assert.equal(result.status, "excluded");
		assert.equal(result.status === "excluded" && result.guidance, "Read docs/api.md instead.");
	}
	assert.throws(() => files.read("generated/runtime/INTERNAL_FILENAME.ts"), ContextAccessDenied);
	assert.throws(() => files.read("generated/.agent-no-read.md"), ContextAccessDenied);
});

test("list shows the excluded directory entry without expanding it", (t) => {
	const { files } = fixture(t);
	const result = files.list();
	assert.equal(result.status, "ok");
	if (result.status !== "ok") throw new Error("Expected list");
	const entry = result.entries.find((entry) => entry.name === "generated");
	assert.equal(entry?.status, "excluded");
	assert.doesNotMatch(JSON.stringify(result), /INTERNAL_FILENAME|TOP_SECRET_SOURCE/);
});

test("search handles globs, literal/case modes, context, result limits and invalid regexes", (t) => {
	const { root, files } = fixture(t);
	fs.writeFileSync(join(root, "src/special.ts"), "a.b\nA.B\naxb");
	const grep = files.grep({ path: "src", pattern: "a.b", literal: true, ignoreCase: true, context: 1 });
	assert.equal(grep.status, "ok");
	if (grep.status !== "ok") throw new Error("Expected matches");
	assert.equal(grep.matches.length, 2);
	assert.equal(grep.matches[0]?.context[0]?.text, "A.B");
	const find = files.find({ pattern: "**/*.ts", limit: 1 });
	assert.equal(find.status === "ok" && find.files.length, 1);
	assert.equal(find.status === "ok" && find.truncated, true);
	const limited = files.grep({ pattern: "needle", glob: "*.ts", limit: 1 });
	assert.equal(limited.status === "ok" && limited.matches.length, 1);
	assert.equal(limited.status === "ok" && limited.truncated, true);
	assert.equal(files.grep({ pattern: "[" }).status, "invalidPattern");
});

test("symlink exclusion summaries deduplicate and cycles terminate", (t) => {
	const { root, files } = fixture(t);
	fs.symlinkSync(join(root, "generated/runtime"), join(root, "alias"));
	fs.symlinkSync(root, join(root, "src/cycle"));
	const result = files.grep({ pattern: "needle" });
	assert.equal(result.status, "ok");
	if (result.status !== "ok") throw new Error("Expected search");
	assert.equal(result.skipped.filter((skip) => skip.status === "excluded").length, 1);
	assert.doesNotMatch(JSON.stringify(result), /INTERNAL_FILENAME|TOP_SECRET_SOURCE/);
});

test("new markers affect the next search, list and read without cached results", (t) => {
	const { root, files } = fixture(t);
	assert.match(files.read("src/index.ts").toString(), /needle/);
	assert.equal(files.grep({ path: "src", pattern: "needle" }).status, "ok");
	fs.writeFileSync(join(root, "src/.agent-no-read.md"), "Use public docs.");
	assert.equal(files.find({ path: "src", pattern: "*" }).status, "excluded");
	assert.equal(files.grep({ path: "src", pattern: "needle" }).status, "excluded");
	assert.equal(files.list("src").status, "excluded");
	assert.throws(() => files.read("src/index.ts"), ContextAccessDenied);
	fs.rmSync(join(root, "src/.agent-no-read.md"));
	assert.match(files.read("src/index.ts").toString(), /needle/);
});

test("a marker created during traversal is honored before descending", (t) => {
	const { root, files } = fixture(t);
	const original = fs.readdirSync;
	t.mock.method(fs, "readdirSync", (path: fs.PathLike, ...args: unknown[]) => {
		const names = (original as any)(path, ...args);
		if (String(path) === root) fs.writeFileSync(join(root, "src/.agent-no-read.md"), "New exclusion");
		return names;
	});
	syncBuiltinESMExports();
	try {
		const result = files.grep({ pattern: "needle" });
		assert.equal(result.status, "ok");
		if (result.status === "ok") assert.ok(result.matches.every((match) => !match.path.startsWith("src/")));
	} finally { t.mock.restoreAll(); syncBuiltinESMExports(); }
});

test("binary and oversized files do not yield content; cancellation and external paths fail closed", (t) => {
	const { root, files } = fixture(t);
	fs.writeFileSync(join(root, "binary"), Buffer.from("needle\0SECRET"));
	fs.writeFileSync(join(root, "large"), Buffer.alloc(2 * 1024 * 1024 + 1, 65));
	const result = files.grep({ pattern: "needle" });
	assert.equal(result.status, "ok");
	if (result.status === "ok") {
		assert.ok(result.matches.every((match) => match.path !== "binary" && match.path !== "large"));
		assert.ok(result.skipped.some((skip) => skip.status === "policyError"));
	}
	assert.equal(files.list("..").status, "outOfScope");
	assert.equal(files.find({ path: "..", pattern: "*" }).status, "outOfScope");
	assert.throws(() => files.find({ pattern: "*", signal: AbortSignal.abort() }));
});

test("skip summaries are capped and excluded descendants never appear in find output", (t) => {
	const { root, files } = fixture(t);
	for (let index = 0; index < 8; index++) {
		const directory = join(root, `excluded-${index}`);
		fs.mkdirSync(directory);
		fs.writeFileSync(join(directory, ".agent-no-read.md"), "Use public docs.");
		fs.writeFileSync(join(directory, "ANOTHER_INTERNAL_FILENAME"), "needle HIDDEN_BODY");
	}
	const result = files.find({ pattern: "**/*" });
	assert.equal(result.status, "ok");
	if (result.status === "ok") assert.equal(result.skipped.length, 5);
	assert.doesNotMatch(JSON.stringify(result), /ANOTHER_INTERNAL_FILENAME|HIDDEN_BODY|INTERNAL_FILENAME/);
});
