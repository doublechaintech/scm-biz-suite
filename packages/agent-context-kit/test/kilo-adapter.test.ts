import assert from "node:assert/strict";
import { mkdtempSync, rmSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { createKiloCodePlugin } from "../src/adapters/kilo.ts";

test("Kilo reuses the OpenCode lifecycle hooks under its own plugin identity", async () => {
	const root = mkdtempSync(join(tmpdir(), "agent-context-kit-kilo-"));
	try {
		writeFileSync(
			join(root, ".agent-context-kit.md"),
			"<!--BLOCK_ID:phase-->\nmodel first\n<!--/BLOCK_ID:phase-->",
		);
		const plugin = createKiloCodePlugin({ directory: root });
		const hooks = await plugin.server({ directory: root });
		const output = { system: ["base"] };
		await hooks["experimental.chat.system.transform"]({ sessionID: "kilo-1" }, output);
		assert.equal(plugin.id, "teaql.agent-context-kit.kilo");
		assert.match(output.system.at(-1) ?? "", /model first/);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});
