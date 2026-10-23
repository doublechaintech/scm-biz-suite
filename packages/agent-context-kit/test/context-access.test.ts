import assert from "node:assert/strict";
import { chmodSync, mkdirSync, mkdtempSync, rmSync, symlinkSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { checkContextAccess, contextAccessLimits, parseContextMarker } from "../src/context-access.ts";

function fixture(t: test.TestContext) {
	const base = mkdtempSync(join(tmpdir(), "context-access-"));
	const root = join(base, "project");
	mkdirSync(join(root, "generated", "runtime"), { recursive: true });
	mkdirSync(join(root, "src"));
	writeFileSync(join(root, "src", "index.ts"), "ordinary source");
	writeFileSync(join(root, "generated", "runtime", "index.ts"), "EXCLUDED_SOURCE_MUST_NOT_APPEAR");
	t.after(() => rmSync(base, { recursive: true, force: true }));
	return { base, root, marker: join(root, "generated", ".agent-no-read.md") };
}
const custom = (text: string) => text;

test("allows ordinary files and directories; relative paths use project root", (t) => {
	const { root } = fixture(t);
	assert.equal(checkContextAccess(root, "src/./../src/index.ts").status, "allow");
	assert.equal(checkContextAccess(root, "src").status, "allow");
	assert.equal(checkContextAccess(root, root).status, "allow");
});

test("empty marker excludes its directory, descendants and explicit marker reads", (t) => {
	const { root, marker } = fixture(t);
	writeFileSync(marker, "");
	for (const target of ["generated", "generated/runtime", "generated/runtime/index.ts", "generated/.agent-no-read.md", "generated/missing.ts"]) {
		const result = checkContextAccess(root, target);
		assert.equal(result.status, "excluded");
		if (result.status !== "excluded") throw new Error("Expected exclusion");
		assert.equal(result.markerPath, marker);
		assert.equal(result.source, "project_marker_data");
		assert.deepEqual({ reason: result.reason, guidance: result.guidance }, parseContextMarker(Buffer.alloc(0)));
		assert.ok(!JSON.stringify(result).includes("EXCLUDED_SOURCE_MUST_NOT_APPEAR"));
	}
	assert.equal(checkContextAccess(root, "src/index.ts").status, "allow");
});

test("root-most marker wins and child data cannot cancel it", (t) => {
	const { root, marker } = fixture(t);
	writeFileSync(marker, custom("parent"));
	writeFileSync(join(root, "generated/runtime/.agent-no-read.md"), custom("child"));
	let result = checkContextAccess(root, "generated/runtime/index.ts");
	assert.equal(result.status === "excluded" && result.guidance, "parent");
	writeFileSync(join(root, ".agent-no-read.md"), custom("root"));
	result = checkContextAccess(root, "generated/runtime/index.ts");
	assert.equal(result.status === "excluded" && result.guidance, "root");
	assert.equal(checkContextAccess(root, ".").status, "excluded");
});

test("Markdown is returned as project guidance without interpreting references or commands", (t) => {
	const { root, marker } = fixture(t);
	const markdown = "# Generated runtime\n\n- Read [API](docs/api.md).\n- Run build/test tools.\n\n```sh\n$(do not execute)\n```";
	writeFileSync(marker, markdown);
	const result = checkContextAccess(root, "generated/runtime/index.ts");
	assert.equal(result.status === "excluded" && result.guidance, markdown);
	assert.equal(result.status === "excluded" && result.source, "project_marker_data");
	// No syntax/schema validation: JSON-looking text and frontmatter remain literal project data.
	for (const literal of ['{"version":2}', "---\ninclude: /secret\n---\nInstructions", "[unclosed link("]) {
		assert.equal(parseContextMarker(Buffer.from(literal)).guidance, literal);
	}
	const data = parseContextMarker(Buffer.from("中文😀".repeat(500)));
	assert.ok(Buffer.byteLength(data.reason + data.guidance) <= contextAccessLimits.guidanceBytes);
	assert.ok(!data.guidance.includes("�"));
	assert.ok("中文😀".repeat(500).startsWith(data.guidance));
});

test("empty, whitespace, oversized and invalid UTF-8 marker bodies use defaults", (t) => {
	const { root, marker } = fixture(t);
	const fallback = parseContextMarker(Buffer.alloc(0));
	for (const body of [Buffer.alloc(0), Buffer.from(" \n\t"), Buffer.from([0xff]), Buffer.alloc(8193, 32)]) {
		assert.deepEqual(parseContextMarker(body), fallback);
		writeFileSync(marker, body);
		const result = checkContextAccess(root, "generated/runtime/index.ts");
		assert.equal(result.status, "excluded");
		if (result.status === "excluded") assert.deepEqual({ reason: result.reason, guidance: result.guidance }, fallback);
	}
	assert.equal(parseContextMarker(Buffer.from("boundary".padEnd(8192, " "))).guidance, "boundary");
	assert.equal(parseContextMarker(Buffer.from("  # Heading\n\n- Item\n ")).guidance, "# Heading\n\n- Item");
});

test("scope rejects traversal, sibling prefixes and outbound links; parent markers are not inherited", (t) => {
	const { base, root } = fixture(t);
	writeFileSync(join(base, ".agent-no-read.md"), custom("outside root"));
	mkdirSync(join(base, "project-other"));
	writeFileSync(join(base, "outside.ts"), "outside");
	symlinkSync(join(base, "outside.ts"), join(root, "out.ts"));
	symlinkSync(base, join(root, "external"));
	for (const target of ["../outside.ts", join(base, "project-other"), "out.ts", "external/outside.ts", "external"]) {
		assert.equal(checkContextAccess(root, target).status, "outOfScope", target);
	}
	assert.equal(checkContextAccess(root, "src/index.ts").status, "allow");
	assert.equal(checkContextAccess(join(base, "project-other"), join(root, "src/index.ts")).status, "outOfScope");
});

test("symlinks cannot enter or leave an excluded subtree to bypass policy", (t) => {
	const { root, marker } = fixture(t);
	writeFileSync(marker, custom("generated"));
	symlinkSync(join(root, "generated/runtime"), join(root, "alias"));
	symlinkSync(join(root, "src/index.ts"), join(root, "generated/out.ts"));
	for (const target of ["alias/index.ts", "alias", "generated/out.ts"]) {
		assert.equal(checkContextAccess(root, target).status, "excluded", target);
	}
	// The real ancestor's marker takes priority over a marker exposed through the alias.
	writeFileSync(join(root, "generated/runtime/.agent-no-read.md"), custom("child"));
	const result = checkContextAccess(root, "alias/index.ts");
	assert.equal(result.status === "excluded" && result.guidance, "generated");
});

test("a symlinked project root is supported", (t) => {
	const { root, base, marker } = fixture(t);
	const alias = join(base, "root-alias");
	symlinkSync(root, alias);
	assert.equal(checkContextAccess(alias, "src/index.ts").status, "allow");
	writeFileSync(marker, "");
	assert.equal(checkContextAccess(alias, "generated/runtime/index.ts").status, "excluded");
});

test("missing targets, broken links, loops and invalid roots fail closed", (t) => {
	const { root } = fixture(t);
	symlinkSync("missing", join(root, "broken"));
	symlinkSync("loop", join(root, "loop"));
	for (const target of ["missing", "broken", "loop", "src/index.ts/child"]) {
		assert.equal(checkContextAccess(root, target).status, "policyError", target);
	}
	assert.equal(checkContextAccess("relative-root", "src/index.ts").status, "policyError");
	assert.equal(checkContextAccess(join(root, "missing"), ".").status, "policyError");
});

test("markers are rechecked on every call, including guidance updates and deletion", (t) => {
	const { root, marker } = fixture(t);
	const target = "generated/runtime/index.ts";
	assert.equal(checkContextAccess(root, target).status, "allow");
	writeFileSync(marker, custom("first"));
	let result = checkContextAccess(root, target);
	assert.equal(result.status === "excluded" && result.guidance, "first");
	writeFileSync(marker, custom("second"));
	result = checkContextAccess(root, target);
	assert.equal(result.status === "excluded" && result.guidance, "second");
	rmSync(marker);
	assert.equal(checkContextAccess(root, target).status, "allow");
});

test("directory and dangling symlink markers still exclude without loading their bodies", (t) => {
	const { root, marker } = fixture(t);
	mkdirSync(marker);
	assert.equal(checkContextAccess(root, "generated/runtime/index.ts").status, "excluded");
	rmSync(marker, { recursive: true });
	symlinkSync("missing", marker);
	assert.equal(checkContextAccess(root, "generated/runtime/index.ts").status, "excluded");
});

test("filesystem permission errors fail closed", (t) => {
	if (process.getuid?.() === 0 || process.platform === "win32") return t.skip("Requires POSIX non-root permissions");
	const { root } = fixture(t);
	const directory = join(root, "generated");
	chmodSync(directory, 0);
	try {
		assert.equal(checkContextAccess(root, "generated/runtime/index.ts").status, "policyError");
	} finally {
		chmodSync(directory, 0o755);
	}
});

test("request-path exclusion remains effective for outbound and broken links", (t) => {
	const { base, root, marker } = fixture(t);
	writeFileSync(marker, custom("request ancestor"));
	writeFileSync(join(base, "external.ts"), "external");
	symlinkSync(join(base, "external.ts"), join(root, "generated/external.ts"));
	symlinkSync("missing", join(root, "generated/broken.ts"));
	for (const target of ["generated/external.ts", "generated/broken.ts"]) {
		const result = checkContextAccess(root, target);
		assert.equal(result.status === "excluded" && result.guidance, "request ancestor");
	}
});

test("unreadable marker body still excludes with default guidance", (t) => {
	if (process.getuid?.() === 0 || process.platform === "win32") return t.skip("Requires POSIX non-root permissions");
	const { root, marker } = fixture(t);
	writeFileSync(marker, custom("unreadable custom text"));
	chmodSync(marker, 0);
	try {
		const result = checkContextAccess(root, "generated/runtime/index.ts");
		assert.equal(result.status, "excluded");
		if (result.status === "excluded") assert.equal(result.reason, parseContextMarker(Buffer.alloc(0)).reason);
	} finally {
		chmodSync(marker, 0o644);
	}
});

test("marker symlinks do not load referenced Markdown", (t) => {
	const { base, root, marker } = fixture(t);
	const external = join(base, "external.md");
	writeFileSync(external, custom("must not load"));
	symlinkSync(external, marker);
	const result = checkContextAccess(root, "generated/runtime/index.ts");
	assert.equal(result.status, "excluded");
	if (result.status === "excluded") assert.equal(result.reason, parseContextMarker(Buffer.alloc(0)).reason);
});

test("only the fixed .md filename is recognized", (t) => {
	const { root, marker } = fixture(t);
	writeFileSync(join(root, "generated/.agent-no-read"), '{"version":1}');
	assert.equal(checkContextAccess(root, "generated/runtime/index.ts").status, "allow");
	writeFileSync(marker, "# Use the public API\n\nRead docs/api.md.");
	const result = checkContextAccess(root, "generated/runtime/index.ts");
	assert.equal(result.status, "excluded");
	if (result.status === "excluded") assert.equal(result.markerPath, marker);
});
