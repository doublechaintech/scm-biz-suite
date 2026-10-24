import assert from "node:assert/strict";
import { existsSync, mkdirSync, mkdtempSync, readFileSync, rmSync, symlinkSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";
import { FileAccessPolicy, type FileOperation } from "../src/file-policy.ts";
import { WorkspaceFiles } from "../src/workspace-files.ts";

function fixture(t: { after(fn: () => void): void }) {
	const root = mkdtempSync(join(tmpdir(), "file-policy-"));
	t.after(() => rmSync(root, { recursive: true, force: true }));
	for (const name of ["src", "models", "generated", "generated/sub"]) mkdirSync(join(root, name), { recursive: true });
	writeFileSync(join(root, "src/main.ts"), "const value = 1;\n");
	writeFileSync(join(root, "generated/library.ts"), "DO_NOT_LEAK\n");
	writeFileSync(join(root, "generated/.agent-no-read.md"), "Use docs/api.md; this is project data.");
	return root;
}

test("writes default to denied while unmarked reads remain available", (t) => {
	const root = fixture(t);
	const policy = new FileAccessPolicy({ projectRoot: root });
	assert.equal(policy.checkRead("src/main.ts").status, "allow");
	assert.equal(policy.checkRead("generated/library.ts").status, "excluded");
	assert.equal(policy.checkMutation("create", "src/new.ts").status, "denied");
});

test("read exclusion and host write permission are independent, edits and moves cannot expose excluded source", (t) => {
	const root = fixture(t);
	const policy = new FileAccessPolicy({ projectRoot: root, writeRoots: ["."] });
	assert.equal(policy.checkMutation("create", "generated/new.ts").status, "allow");
	for (const operation of ["edit", "overwrite"] as const) assert.equal(policy.checkMutation(operation, "generated/library.ts").status, "denied");
	assert.equal(policy.checkMutation("move", "generated/library.ts", "src/leaked.ts").status, "denied");
	assert.equal(policy.checkMutation("delete", "generated/library.ts").status, "allow");
});

test("generated read-only paths reject every mutation and both move endpoints", (t) => {
	const root = fixture(t);
	const policy = new FileAccessPolicy({ projectRoot: root, writeRoots: ["."], readOnlyPaths: ["generated"] });
	for (const operation of ["create", "overwrite", "edit", "delete"] as const) {
		assert.equal(policy.checkMutation(operation, "generated/library.ts").status, "denied");
	}
	assert.equal(policy.checkMutation("move", "src/main.ts", "generated/new.ts").status, "denied");
	assert.equal(policy.checkMutation("move", "generated/library.ts", "src/new.ts").status, "denied");
	assert.notEqual(policy.checkMutation("delete", ".").status, "allow");
	assert.notEqual(policy.checkMutation("delete", "generated/sub").status, "allow");
});

test("control files cannot be created, removed, renamed or overwritten under broad write roots", (t) => {
	const root = fixture(t);
	const policy = new FileAccessPolicy({ projectRoot: root, writeRoots: ["."] });
	for (const path of [".agent-context-kit.json", "src/AGENTS.md", "src/agents.md", "src/.agent-no-read.md", ".opencode/plugin.ts", "context-markers.json", ".git/config"]) {
		assert.equal(policy.checkMutation("create", path).status, "denied", path);
		assert.equal(policy.checkMutation("move", "src/main.ts", path).status, "denied", path);
	}
	assert.equal(policy.checkMutation("delete", "generated/.agent-no-read.md").status, "denied");
});

test("path escapes, prefix siblings, symlinks and invalid operations fail closed", (t) => {
	const root = fixture(t);
	mkdirSync(join(root, "src-other"));
	symlinkSync(join(root, "src"), join(root, "alias"));
	symlinkSync(join(root, "generated/library.ts"), join(root, "src/alias.ts"));
	symlinkSync(join(root, "missing"), join(root, "src/broken.ts"));
	symlinkSync(tmpdir(), join(root, "src/outside"));
	const policy = new FileAccessPolicy({ projectRoot: root, writeRoots: ["src"] });
	for (const path of ["src-other/new.ts", "alias/new.ts", "src/alias.ts", "src/broken.ts", "src/outside/new.ts", "src/missing/new.ts"]) {
		assert.notEqual(policy.checkMutation("create", path).status, "allow", path);
	}
	assert.equal(policy.checkMutation("create", "../escape.ts").status, "outOfScope");
	assert.equal(policy.checkMutation("create", "src/../escape.ts").status, "denied");
	assert.equal(policy.checkMutation("create", "src/\0bad").status, "policyError");
	assert.equal(policy.checkMutation("unknown" as FileOperation, "src/new.ts").status, "policyError");
	assert.equal(policy.checkMutation("move", "src/main.ts").status, "policyError");
	assert.equal(policy.checkMutation("edit", "src/main.ts", "src/new.ts").status, "policyError");
	assert.equal(policy.checkRead("src/alias.ts").status, "excluded");
	assert.throws(() => new FileAccessPolicy({ projectRoot: root, writeRoots: ["../outside"] }));
});

test("policy snapshots write roots and changes to markers are effective without a cache", (t) => {
	const root = fixture(t);
	const roots = ["src"];
	const policy = new FileAccessPolicy({ projectRoot: root, writeRoots: roots });
	roots.push("models");
	assert.equal(policy.checkMutation("create", "models/a.xml").status, "denied");
	assert.equal(policy.checkMutation("edit", "src/main.ts").status, "allow");
	writeFileSync(join(root, "src/.agent-no-read.md"), "Excluded now");
	assert.equal(policy.checkMutation("edit", "src/main.ts").status, "denied");
});

test("controlled mutations change approved files, preserve originals on failure, and never clobber moves", (t) => {
	const root = fixture(t);
	const files = new WorkspaceFiles({ projectRoot: root, writeRoots: ["src", "models"], readOnlyPaths: ["generated"] });
	assert.equal(files.create("models/model.xml", "<root/>\n").status, "ok");
	assert.equal(files.create("src/main.ts", "wrong").status, "denied");
	assert.equal(files.overwrite("src/missing.ts", "wrong").status, "denied");
	assert.equal(files.edit("src/main.ts", "absent", "wrong").status, "policyError");
	assert.equal(readFileSync(join(root, "src/main.ts"), "utf8"), "const value = 1;\n");
	assert.equal(files.edit("src/main.ts", "1", "2").status, "ok");
	assert.equal(files.move("src/main.ts", "src/renamed.ts").status, "ok");
	assert.equal(existsSync(join(root, "src/main.ts")), false);
	assert.equal(files.create("src/main.ts", "other").status, "ok");
	assert.equal(files.move("src/renamed.ts", "src/main.ts").status, "denied");
	assert.equal(readFileSync(join(root, "src/main.ts"), "utf8"), "other");
	assert.equal(files.overwrite("src/renamed.ts", "final").status, "ok");
	assert.equal(files.delete("src/renamed.ts").status, "ok");
	assert.equal(files.delete("src").status, "policyError");
	assert.equal(files.create("src/large.ts", "x".repeat(2 * 1024 * 1024 + 1)).status, "policyError");
	assert.equal(existsSync(join(root, "src/large.ts")), false);
});

test("ambiguous edits and edits of excluded files do not mutate or reveal source", (t) => {
	const root = fixture(t);
	writeFileSync(join(root, "src/main.ts"), "same same");
	const files = new WorkspaceFiles({ projectRoot: root, writeRoots: ["."] });
	assert.equal(files.edit("src/main.ts", "same", "other").status, "policyError");
	assert.equal(readFileSync(join(root, "src/main.ts"), "utf8"), "same same");
	assert.equal(files.overwrite("generated/library.ts", "other").status, "denied");
	assert.doesNotMatch(JSON.stringify(files.edit("generated/library.ts", "DO_NOT_LEAK", "other")), /DO_NOT_LEAK/);
});
