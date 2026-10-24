import assert from "node:assert/strict";
import test from "node:test";
import { createPiCompletionGuard } from "../src/adapters/pi-completion.ts";

function harness(fail = false, withChecks = true, duringCheck?: () => void) {
 const hooks = new Map<string, Function>(); const entries: any[] = []; const calls: string[] = [];
 const tool = (name: string) => ({ name, label: name, description: name, parameters: { type: "object" as const }, async execute() { calls.push(name); if (name === "app_build") duringCheck?.(); if (fail && name === "app_build") throw new Error('{"status":"failed","diagnostics":[{"code":"E0308"}]}'); return { content: [{ type: "text" as const, text: "ok" }], details: { status: "ok" } }; } });
 const checks = withChecks ? [tool("app_build"), tool("app_test")] : [];
 const pi = { on(name: string, fn: Function) { hooks.set(name, fn); }, appendEntry(customType: string, data: unknown) { entries.push({ type: "custom", customType, data }); } };
 const wrap = createPiCompletionGuard(pi as never, checks);
 const ctx = { signal: undefined as AbortSignal | undefined, sessionManager: { getBranch: () => entries }, ui: { setStatus() {} } };
 const settle = (outcome = "completed") => hooks.get("turn_end")?.({ outcome, message: { role: "assistant", stopReason: "stop" }, entries: [], context: { canContinue: true } }, ctx);
 return { hooks, entries, calls, wrap, tool, ctx, settle };
}

test("premature stop after edit runs both checks and returns actual failures for continuation", async () => {
 const h = harness(true); await h.wrap(h.tool("edit")).execute("e", {}, undefined, undefined, h.ctx as never);
 const next = await h.settle(); assert.equal(next.continue, true);
 assert.deepEqual(h.calls, ["edit", "app_build", "app_test"]); assert.match(next.entries[0].content, /E0308/);
 assert.equal(await h.settle(), undefined); // Same unchanged failure is never run again.
});

test("only missing checks run and a later edit invalidates prior verification", async () => {
 const h = harness();
 await h.wrap(h.tool("edit")).execute("e", {}, undefined, undefined, h.ctx as never);
 await h.wrap(h.tool("app_build")).execute("b", {}, undefined, undefined, h.ctx as never);
 await h.settle(); assert.deepEqual(h.calls, ["edit", "app_build", "app_test"]);
 await h.wrap(h.tool("write")).execute("w", {}, undefined, undefined, h.ctx as never);
 await h.settle(); assert.deepEqual(h.calls.slice(-3), ["write", "app_build", "app_test"]);
});

test("read-only work, failed edits, unavailable checks and cancellation never trigger verification", async () => {
 const h = harness(); await h.wrap(h.tool("read")).execute("r", {}, undefined, undefined, h.ctx as never); assert.equal(await h.settle(), undefined);
 const denied = { ...h.tool("edit"), async execute() { return { content: [], details: { status: "denied" } }; } };
 await h.wrap(denied).execute("e", {}, undefined, undefined, h.ctx as never); assert.equal(await h.settle(), undefined);
 await h.wrap(h.tool("edit")).execute("e", {}, undefined, undefined, h.ctx as never);
 assert.equal(await h.settle("aborted"), undefined); assert.equal(await h.settle("error"), undefined);
 h.ctx.signal = AbortSignal.abort(); assert.equal(await h.settle(), undefined); assert.deepEqual(h.calls, ["read", "edit"]);
 assert.equal(harness(false, false).hooks.has("turn_end"), false);
 const controller = new AbortController(); const cancelled = harness(false, true, () => controller.abort());
 cancelled.ctx.signal = controller.signal;
 await cancelled.wrap(cancelled.tool("edit")).execute("e", {}, controller.signal, undefined, cancelled.ctx as never);
 assert.equal(await cancelled.settle(), undefined); assert.deepEqual(cancelled.calls, ["edit", "app_build"]);
});

test("automatic repair cycles are bounded and pending verification survives session restoration", async () => {
 const h = harness();
 for (let i = 0; i < 3; i++) { await h.wrap(h.tool("edit")).execute("e", {}, undefined, undefined, h.ctx as never); assert.equal((await h.settle()).continue, true); }
 await h.wrap(h.tool("edit")).execute("e", {}, undefined, undefined, h.ctx as never);
 const blocked = await h.settle(); assert.equal(blocked.continue, undefined); assert.match(blocked.entries[0].content, /VERIFICATION_INCOMPLETE/);
 h.hooks.get("session_start")!({}, h.ctx); assert.match((await h.settle()).entries[0].content, /VERIFICATION_INCOMPLETE/);
 h.hooks.get("before_agent_start")!({ messageType: "user" }); assert.equal((await h.settle()).continue, true);
});

test("verification started before a concurrent edit cannot certify the new revision", async () => {
 const h = harness(); let finish!: () => void;
 const slow = { ...h.tool("app_build"), async execute() { await new Promise<void>(r => { finish = r; }); return { content: [], details: { status: "ok" } }; } };
 const pending = h.wrap(slow).execute("b", {}, undefined, undefined, h.ctx as never);
 await h.wrap(h.tool("edit")).execute("e", {}, undefined, undefined, h.ctx as never); finish(); await pending;
 await h.settle(); assert.deepEqual(h.calls, ["edit", "app_build", "app_test"]);
});
