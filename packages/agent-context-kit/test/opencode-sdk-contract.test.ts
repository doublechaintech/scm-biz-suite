import type { Plugin } from "@opencode/plugin";
import test from "node:test";
import assert from "node:assert/strict";
import { createOpenCodeContextPolicyPlugin } from "../src/adapters/opencode-context.ts";

// Checked by tsc against the actual pinned published SDK, not a local mock declaration.
const compatible: (options: Parameters<typeof createOpenCodeContextPolicyPlugin>[0]) => Plugin.Plugin = createOpenCodeContextPolicyPlugin;
test("strict OpenCode factory conforms to the published V2 SDK plugin contract", () => {
	assert.equal(compatible, createOpenCodeContextPolicyPlugin);
});
