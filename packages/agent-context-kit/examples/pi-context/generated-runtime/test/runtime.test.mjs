import test from "node:test";
import assert from "node:assert/strict";
import { getAnswer } from "../src/main.mjs";

test("public runtime contract", () => { assert.equal(getAnswer(), 42); });
