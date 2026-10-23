import assert from "node:assert/strict";
import { mkdtempSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { handleCommandHook } from "../src/adapters/command-hook.ts";

function workspace(): string {
	const root = mkdtempSync(join(tmpdir(), "agent-context-kit-hook-"));
	writeFileSync(
		join(root, ".agent-context-kit.md"),
		"<!--BLOCK_ID:phase-->\nuse TeaQL context\n<!--/BLOCK_ID:phase-->",
	);
	writeFileSync(join(root, ".agent-context-kit.json"), JSON.stringify({
		readGuard: { paths: ["generated/library"], message: "Use TeaQL context." },
	}));
	return root;
}

test("command hooks inject active blocks for prompt and subagent events", () => {
	const root = workspace();
	try {
		for (const host of ["kimi", "qwen", "kiro"] as const) {
			const result = handleCommandHook(host, {
				hook_event_name: "UserPromptSubmit",
				session_id: "s1",
				cwd: root,
			});
			assert.equal(result.exitCode, 0);
			assert.match(result.stdout, /use TeaQL context/);
		}
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});

test("command hooks emit each host's documented deny envelope", () => {
	const root = workspace();
	try {
		const payload = {
			hook_event_name: "PreToolUse",
			session_id: "s1",
			cwd: root,
			tool_name: "read_file",
			tool_input: { file_path: "generated/library/model.json" },
		};
		const qwen = handleCommandHook("qwen", payload);
		assert.equal(JSON.parse(qwen.stdout).hookSpecificOutput.permissionDecision, "deny");
		const copilot = handleCommandHook("copilot", payload);
		assert.equal(JSON.parse(copilot.stdout).permissionDecision, "deny");
		const crush = handleCommandHook("crush", { ...payload, event: "PreToolUse" });
		assert.equal(JSON.parse(crush.stdout).decision, "deny");
		const kiro = handleCommandHook("kiro", payload);
		assert.equal(kiro.exitCode, 2);
		assert.match(kiro.stderr, /Use TeaQL context/);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});
