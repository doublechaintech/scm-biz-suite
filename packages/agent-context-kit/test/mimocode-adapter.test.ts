import assert from "node:assert/strict";
import { mkdtempSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { createMiMoCodePlugin } from "../src/adapters/mimocode.ts";

test("MiMo Code adapts envelope messages and injects active blocks", async () => {
	const root = mkdtempSync(join(tmpdir(), "agent-context-kit-mimocode-"));
	try {
		writeFileSync(
			join(root, ".agent-context-kit.md"),
			"<!--BLOCK_ID:phase-->\nmodel first\n<!--/BLOCK_ID:phase-->",
		);
		const plugin = createMiMoCodePlugin({ directory: root });
		const hooks = await plugin({ directory: root });
		const messages = [
			{
				info: { role: "user", sessionID: "session-1", time: { created: 1 } },
				parts: [{ type: "text", text: "<!--ephemeral-->\nlarge" }],
			},
			{
				info: { role: "assistant", sessionID: "session-1", time: { created: 2 } },
				parts: [{ type: "text", text: "done" }],
			},
		];
		const output = { messages };
		await hooks["experimental.chat.messages.transform"]({}, output);
		assert.match(JSON.stringify(output.messages[0]?.parts), /EPHEMERAL:/);

		const system = { system: ["base"] };
		await hooks["experimental.chat.system.transform"]({ sessionID: "session-1" }, system);
		assert.match(system.system.at(-1) ?? "", /model first/);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});

test("MiMo Code cancels protected tool calls and returns the redirect message", async () => {
	const root = mkdtempSync(join(tmpdir(), "agent-context-kit-mimocode-guard-"));
	try {
		const plugin = createMiMoCodePlugin({
			directory: root,
			readGuard: {
				paths: ["generated/library"],
				message: "Use TeaQL workspace context.",
			},
		});
		const hooks = await plugin({ directory: root });
		const output: { args: unknown; cancel?: boolean; cancelReason?: string } = {
			args: { file_path: "generated/library/model.json" },
		};
		await hooks["tool.execute.before"](
			{ tool: "read_file", sessionID: "session-1" },
			output,
		);
		assert.equal(output.cancel, true);
		assert.match(output.cancelReason ?? "", /Use TeaQL workspace context/);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});
