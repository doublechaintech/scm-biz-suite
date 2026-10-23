import assert from "node:assert/strict";
import { mkdtempSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { createClinePlugin } from "../src/adapters/cline.ts";

test("Cline rewrites provider-bound messages and blocks protected reads", () => {
	const root = mkdtempSync(join(tmpdir(), "agent-context-kit-cline-"));
	try {
		writeFileSync(
			join(root, ".agent-context-kit.md"),
			"<!--BLOCK_ID:phase-->\nmodel first\n<!--/BLOCK_ID:phase-->",
		);
		let build: ((messages: any[]) => any[]) | undefined;
		const plugin = createClinePlugin({
			directory: root,
			readGuard: { paths: ["generated/library"], message: "Use TeaQL context." },
		});
		plugin.setup({ registerMessageBuilder(builder) { build = builder.build; } }, {
			workspaceInfo: { rootPath: root },
		});

		const messages = [
			{ role: "user", content: "<!--ephemeral-->\nlarge", timestamp: 1 },
			{ role: "assistant", content: "done", timestamp: 2 },
		];
		const rewritten = build?.(messages) ?? [];
		assert.match(String(rewritten[0]?.content), /EPHEMERAL:/);
		assert.match(JSON.stringify(rewritten.at(-1)?.content), /model first/);
		const blocked = plugin.hooks.beforeTool({
			toolCall: { toolName: "read_files" },
			input: { paths: ["src/index.ts", "generated/library/model.json"] },
		});
		assert.equal(blocked?.skip, true);
		assert.match(blocked?.reason ?? "", /Use TeaQL context/);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});
