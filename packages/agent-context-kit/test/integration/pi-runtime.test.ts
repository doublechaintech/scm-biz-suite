import assert from "node:assert/strict";
import test from "node:test";

import {
	runPiRuntimeTrace,
	type ProviderRequestTrace,
	type TranscriptTrace,
} from "../../scripts/pi-runtime-trace.ts";

test("real Pi runtime exposes deterministic lifecycle changes at the provider boundary", async () => {
	const { records } = await runPiRuntimeTrace();
	const requests = records.filter(
		(record): record is ProviderRequestTrace => record.kind === "provider_request",
	);
	const transcript = records.find(
		(record): record is TranscriptTrace => record.kind === "persistent_transcript",
	);

	assert.equal(requests.length, 4);
	assert.deepEqual(
		requests.map((request) => ({
			request: request.request,
			active: request.activeBlockIds,
			blockVisible: request.blockVisible,
			ephemeral: request.ephemeralState,
		})),
		[
			{ request: 1, active: ["phase_modeling"], blockVisible: true, ephemeral: "absent" },
			{ request: 2, active: ["phase_modeling"], blockVisible: true, ephemeral: "original" },
			{ request: 3, active: ["phase_modeling"], blockVisible: true, ephemeral: "tombstone" },
			{ request: 4, active: [], blockVisible: false, ephemeral: "tombstone" },
		],
	);
	assert.ok(requests.every((request) => request.sourceBlockStillInSystemPrompt === false));
	assert.ok(requests[3]?.audit.some((event) => event.action === "block_discarded"));
	assert.deepEqual(transcript, {
		kind: "persistent_transcript",
		originalEphemeralPreserved: true,
		tombstonePersisted: false,
		activeBlockIdsAfterDiscard: [],
	});
});
