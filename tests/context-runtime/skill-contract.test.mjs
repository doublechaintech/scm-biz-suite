import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import test from "node:test";
import { parseMarkdown } from "../../packages/agent-context-kit/src/parser.ts";

test("the actual TeaQL Skill exposes valid phase blocks to the strict lifecycle parser", () => {
  const skill = readFileSync(new URL("../../skills/build-teaql-app/SKILL.md", import.meta.url), "utf8");
  const parsed = parseMarkdown(skill, "teaql:build-teaql-app");
  assert.deepEqual(parsed.diagnostics, []);
  assert.deepEqual(parsed.blocks.map((block) => block.id), ["phase_modeling", "phase_codegen"]);
  assert.match(parsed.blocks[0].content, /Model First/);
  assert.match(parsed.blocks[1].content, /Generate only the outputs requested/);
});
