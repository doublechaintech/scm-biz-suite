import assert from "node:assert/strict";
import test from "node:test";

import {
	GeminiCliLifecycleAdapter,
	type GeminiBeforeModelInput,
	type GeminiStateStore,
} from "../src/adapters/gemini-cli.ts";
import type { LifecycleSnapshot } from "../src/types.ts";

class MemoryStore implements GeminiStateStore {
	snapshot: LifecycleSnapshot | undefined;

	load(): LifecycleSnapshot | undefined {
		return this.snapshot ? structuredClone(this.snapshot) : undefined;
	}

	save(_input: GeminiBeforeModelInput, snapshot: LifecycleSnapshot): void {
		this.snapshot = structuredClone(snapshot);
	}
}

function input(messages: GeminiBeforeModelInput["llm_request"]["messages"]): GeminiBeforeModelInput {
	return {
		session_id: "session-1",
		transcript_path: "/tmp/gemini-session-1.json",
		cwd: "/repo",
		hook_event_name: "BeforeModel",
		timestamp: "2026-09-28T00:00:00Z",
		llm_request: { model: "gemini-test", messages },
	};
}

test("Gemini CLI strips trusted block definitions and injects active blocks", () => {
	const store = new MemoryStore();
	const adapter = new GeminiCliLifecycleAdapter(store);
	const messages = [
		{
			role: "system" as const,
			content: "base\n<!--BLOCK_ID:phase-->\nkeep this\n<!--/BLOCK_ID:phase-->",
		},
		{ role: "user" as const, content: "work" },
	];
	const original = structuredClone(messages);
	const result = adapter.handleBeforeModel(input(messages));
	const output = result.hookSpecificOutput.llm_request.messages;

	assert.doesNotMatch(output[0]?.content ?? "", /keep this/);
	assert.match(output.at(-1)?.content ?? "", /keep this/);
	assert.deepEqual(messages, original);
	assert.equal(store.snapshot?.blocks[0]?.id, "phase");
});

test("Gemini CLI text messages are visible once and then tombstoned", () => {
	const store = new MemoryStore();
	const adapter = new GeminiCliLifecycleAdapter(store);
	const first = adapter.handleBeforeModel(input([
		{ role: "user", content: "<!--ephemeral-->\nlarge output" },
	]));
	assert.match(first.hookSpecificOutput.llm_request.messages[0]?.content ?? "", /large output/);

	const secondMessages = [
		{ role: "user" as const, content: "<!--ephemeral-->\nlarge output" },
		{ role: "model" as const, content: "done" },
		{ role: "user" as const, content: "continue" },
	];
	const second = adapter.handleBeforeModel(input(secondMessages));
	assert.match(second.hookSpecificOutput.llm_request.messages[0]?.content ?? "", /EPHEMERAL:/);
	assert.match(secondMessages[0]?.content ?? "", /large output/);
	assert.equal(store.snapshot?.audit.filter((event) => event.action === "ephemeral_consumed").length, 1);
});

test("Gemini CLI accepts discard only from system context", () => {
	const store = new MemoryStore();
	const adapter = new GeminiCliLifecycleAdapter(store);
	adapter.handleBeforeModel(input([
		{ role: "system", content: "<!--BLOCK_ID:phase-->\nstay\n<!--/BLOCK_ID:phase-->" },
		{ role: "user", content: "seed" },
	]));

	const denied = adapter.handleBeforeModel(input([
		{ role: "user", content: "<!--DISCARD_BLOCK:phase-->" },
	]));
	assert.match(denied.hookSpecificOutput.llm_request.messages.at(-1)?.content ?? "", /stay/);

	const discarded = adapter.handleBeforeModel(input([
		{ role: "system", content: "<!--DISCARD_BLOCK:phase-->" },
	]));
	assert.equal(
		discarded.hookSpecificOutput.llm_request.messages.some((message) => /stay/.test(message.content)),
		false,
	);
});
