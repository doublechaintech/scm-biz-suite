import assert from "node:assert/strict";
import test from "node:test";

import {
	apply,
	deepSeekEphemeralProjection,
	deepSeekHarnessLifecycleConstants,
} from "../src/adapters/deepseek-harness.ts";

test("DeepSeek Harness projection tombstones only consumed ephemeral messages", () => {
	const ephemeral = {
		id: "u1",
		role: "user",
		source: { kind: "user" },
		content: [{ type: "text", text: "<!--ephemeral-->\nlarge" }],
	};
	const assistant = {
		id: "a1",
		role: "assistant",
		source: { kind: "model" },
		content: [{ type: "text", text: "done" }],
	};
	const events = [
		{ type: "user/message", seq: 0, data: ephemeral },
		{ type: "assistant/message", seq: 1, data: { message: assistant } },
	];
	const replacements = deepSeekEphemeralProjection.project(
		{ type: deepSeekHarnessLifecycleConstants.consumeEvent, seq: 2, data: { version: 1 } },
		{ nodes: [0, 1], events, baseSeq: 0, messages: new Map() },
	);

	assert.match(JSON.stringify(replacements.get(0)?.content), /EPHEMERAL:/);
	assert.equal(replacements.has(1), false);
	assert.match(JSON.stringify(ephemeral.content), /large/);
});

test("DeepSeek Harness plugin registers projection and appends a durable consume event", async () => {
	let projection: unknown;
	let preStep: ((payload: any, next: () => Promise<unknown>) => Promise<unknown>) | undefined;
	const appended: Array<{ type: string; data: unknown }> = [];
	const ctx = {
		sessions: { registerMessageProjection(value: unknown) { projection = value; } },
		systemPrompt: { section() {} },
		on(_event: string, handler: typeof preStep) { preStep = handler; },
	};
	apply(ctx as never);
	const agent = {
		session: {
			header: {},
			surface: { nodes: [] },
			deriveMessages: () => [
				{ role: "user", content: [{ type: "text", text: "<!--ephemeral-->\nlarge" }] },
				{ role: "assistant", content: [{ type: "text", text: "done" }] },
			],
			append(type: string, data: unknown) { appended.push({ type, data }); },
		},
	};
	await preStep?.({ agent }, async () => "next");

	assert.equal(projection, deepSeekEphemeralProjection);
	assert.deepEqual(appended, [{
		type: deepSeekHarnessLifecycleConstants.consumeEvent,
		data: { version: 1 },
	}]);
});
