import assert from "node:assert/strict";
import test from "node:test";

import { parseMarkdown } from "../src/parser.ts";

test("parses only exact V1 declarations and preserves ordinary markdown", () => {
	const markdown = [
		"before",
		"<!--ephemeral-->",
		"<!--BLOCK_ID:phase_modeling-->",
		"rules",
		"<!--/BLOCK_ID:phase_modeling-->",
		"<!--DISCARD_BLOCK:phase_modeling-->",
		"after",
	].join("\n");
	const parsed = parseMarkdown(markdown, "fixture.md");

	assert.equal(parsed.ephemeral, true);
	assert.deepEqual(parsed.blocks, [
		{
			id: "phase_modeling",
			source: "fixture.md",
			content: "rules\n",
			startLine: 3,
			endLine: 5,
		},
	]);
	assert.deepEqual(parsed.discards, [{ blockId: "phase_modeling", line: 6 }]);
	assert.equal(parsed.ordinaryMarkdown, "before\n<!--ephemeral-->\n<!--DISCARD_BLOCK:phase_modeling-->\nafter");
	assert.deepEqual(parsed.diagnostics, []);
});

test("does not trim, repair, case-fold, or fuzzy-match tags", () => {
	const invalid = [
		"<!-- ephemeral -->",
		"<!-- BLOCK_ID:phase_modeling -->",
		"<!--BLOCK_ID: phase_modeling-->",
		"<!--BLOCK_ID:phase modeling-->",
		"<!--block_id:phase_modeling-->",
		" <!--DISCARD_BLOCK:phase_modeling-->",
		"<!--DISCARD_BLOCK:phase_modeling--> trailing",
	].join("\n");
	const parsed = parseMarkdown(invalid, "invalid.md");

	assert.equal(parsed.ephemeral, false);
	assert.deepEqual(parsed.blocks, []);
	assert.deepEqual(parsed.discards, []);
	assert.equal(parsed.ordinaryMarkdown, invalid);
	assert.equal(parsed.diagnostics.length, 7);
	assert.ok(parsed.diagnostics.every((item) => item.code === "invalid-lifecycle-tag"));
});

test("rejects mismatched, nested, unclosed, and duplicate blocks", () => {
	const mismatch = parseMarkdown(
		"<!--BLOCK_ID:first-->\nbody\n<!--/BLOCK_ID:second-->\n<!--/BLOCK_ID:first-->",
		"mismatch.md",
	);
	assert.deepEqual(mismatch.blocks, []);
	assert.ok(mismatch.diagnostics.some((item) => item.code === "mismatched-block-end"));

	const nested = parseMarkdown(
		"<!--BLOCK_ID:outer-->\n<!--BLOCK_ID:inner-->\nx\n<!--/BLOCK_ID:inner-->\n<!--/BLOCK_ID:outer-->",
		"nested.md",
	);
	assert.deepEqual(nested.blocks, []);
	assert.ok(nested.diagnostics.some((item) => item.code === "nested-block"));

	const unclosed = parseMarkdown("<!--BLOCK_ID:open-->\nbody", "unclosed.md");
	assert.deepEqual(unclosed.blocks, []);
	assert.equal(unclosed.diagnostics.at(-1)?.code, "unclosed-block");

	const duplicate = parseMarkdown(
		"<!--BLOCK_ID:same-->\none\n<!--/BLOCK_ID:same-->\n<!--BLOCK_ID:same-->\ntwo\n<!--/BLOCK_ID:same-->",
		"duplicate.md",
	);
	assert.equal(duplicate.blocks.length, 0);
	assert.ok(duplicate.ordinaryMarkdown.includes("one"));
	assert.ok(duplicate.ordinaryMarkdown.includes("two"));
	assert.ok(duplicate.diagnostics.some((item) => item.code === "duplicate-block-id"));
});

test("leaves ordinary HTML comments alone", () => {
	const markdown = "<!-- generated file -->\ntext\n<!-- TODO: revisit -->";
	const parsed = parseMarkdown(markdown, "ordinary.md");

	assert.equal(parsed.ordinaryMarkdown, markdown);
	assert.deepEqual(parsed.diagnostics, []);
	assert.deepEqual(parsed.blocks, []);
});
