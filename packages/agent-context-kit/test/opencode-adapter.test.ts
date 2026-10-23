import assert from "node:assert/strict";
import { mkdtempSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { createOpenCodePlugin } from "../src/adapters/opencode.ts";

test("OpenCode V2 rewrites request-local history and injects active blocks", async () => {
	const root = mkdtempSync(join(tmpdir(), "agent-context-kit-opencode-"));
	try {
		writeFileSync(
			join(root, ".agent-context-kit.md"),
			"<!--BLOCK_ID:phase-->\nmodel first\n<!--/BLOCK_ID:phase-->",
		);
		let contextHook: ((event: any) => unknown) | undefined;
		let toolHook: ((event: any) => unknown) | undefined;
		const plugin = createOpenCodePlugin({ directory: root });
		await plugin.setup({
			location: { directory: root },
			session: { async hook(_name: string, callback: (event: any) => unknown) { contextHook = callback; } },
			tool: { async hook(_name: string, callback: (event: any) => unknown) { toolHook = callback; } },
		} as never);

		const event = {
			sessionID: "session-1",
			system: [{ type: "text", text: "base" }],
			messages: [
				{ role: "user", content: "<!--ephemeral-->\nlarge", timestamp: 1 },
				{ role: "assistant", content: "done", timestamp: 2 },
				{ role: "user", content: "next", timestamp: 3 },
			],
		};
		await contextHook?.(event);

		assert.match(String(event.messages[0]?.content), /EPHEMERAL:/);
		assert.match(event.system.at(-1)?.text ?? "", /model first/);
		assert.equal(typeof toolHook, "function");
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});

test("OpenCode V2 blocks protected reads with the configured guidance", async () => {
	const root = mkdtempSync(join(tmpdir(), "agent-context-kit-opencode-guard-"));
	try {
		let toolHook: ((event: any) => unknown) | undefined;
		const plugin = createOpenCodePlugin({
			directory: root,
			readGuard: {
				paths: ["generated/library"],
				message: "Use TeaQL workspace context.",
			},
		});
		await plugin.setup({
			location: { directory: root },
			session: { async hook() {} },
			tool: { async hook(_name: string, callback: (event: any) => unknown) { toolHook = callback; } },
		} as never);

		assert.throws(
			() => toolHook?.({ tool: "read", input: { filePath: "generated/library/model.json" } }),
			/Use TeaQL workspace context/,
		);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});
