import assert from "node:assert/strict";
import { mkdtempSync, mkdirSync, rmSync, symlinkSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join } from "node:path";
import test from "node:test";

import { ReadGuard, parseReadGuardConfig } from "../src/read-guard.ts";

const guidance =
	"TeaQL workspace context already provides the complete business model; use it instead of reading generated libraries.";

function fixture(): string {
	const root = mkdtempSync(join(tmpdir(), "agent-context-kit-read-guard-"));
	mkdirSync(join(root, "generated", "library"), { recursive: true });
	mkdirSync(join(root, "src"), { recursive: true });
	writeFileSync(join(root, "generated", "library", "model.json"), "secret");
	writeFileSync(join(root, "src", "index.ts"), "export {};");
	return root;
}

test("blocks direct reads and returns the configured TeaQL guidance", () => {
	const root = fixture();
	try {
		const guard = new ReadGuard({
			workspaceRoot: root,
			paths: ["generated/library"],
			message: guidance,
		});
		const blocked = guard.evaluate({
			toolName: "read",
			input: { path: "generated/library/model.json" },
			cwd: root,
		});

		assert.equal(blocked?.protectedPath, "generated/library");
		assert.match(blocked?.reason ?? "", /TeaQL workspace context/);
		assert.match(blocked?.reason ?? "", /Do not retry/);
		assert.equal(
			guard.evaluate({ toolName: "read", input: { path: "src/index.ts" }, cwd: root }),
			undefined,
		);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});

test("blocks recursive searches that would cross a protected subtree", () => {
	const root = fixture();
	try {
		const guard = new ReadGuard({
			workspaceRoot: root,
			paths: ["generated/library"],
			message: guidance,
		});

		const grep = guard.evaluate({ toolName: "grep", input: { pattern: "Order" }, cwd: root });
		assert.match(grep?.reason ?? "", /recursively traverse/);
		assert.ok(guard.evaluate({ toolName: "find", input: { pattern: "*.json" }, cwd: root }));
		assert.equal(
			guard.evaluate({
				toolName: "grep",
				input: { pattern: "Order", path: "src" },
				cwd: root,
			}),
			undefined,
		);
		assert.equal(guard.evaluate({ toolName: "ls", input: { path: "." }, cwd: root }), undefined);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});

test("resolves symlinks before matching protected paths", () => {
	const root = fixture();
	try {
		symlinkSync(join(root, "generated", "library"), join(root, "library-alias"));
		const guard = new ReadGuard({
			workspaceRoot: root,
			paths: ["generated/library"],
			message: guidance,
		});

		assert.ok(
			guard.evaluate({
				toolName: "read",
				input: { path: "library-alias/model.json" },
				cwd: root,
			}),
		);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});

test("supports literal and strict bash modes", () => {
	const root = fixture();
	try {
		const literal = new ReadGuard({
			workspaceRoot: root,
			paths: ["generated/library"],
			message: guidance,
			bashMode: "literal",
		});
		assert.ok(
			literal.evaluate({
				toolName: "bash",
				input: { command: "cat generated/library/model.json" },
				cwd: root,
			}),
		);
		assert.equal(
			literal.evaluate({ toolName: "bash", input: { command: "rg Order src" }, cwd: root }),
			undefined,
		);
		assert.ok(
			literal.evaluate({
				toolName: "bash",
				input: { command: "cat model.json" },
				cwd: join(root, "generated", "library"),
			}),
		);

		const strict = new ReadGuard({
			workspaceRoot: root,
			paths: ["generated/library"],
			message: guidance,
			bashMode: "block",
		});
		assert.match(
			strict.evaluate({ toolName: "bash", input: { command: "pwd" }, cwd: root })?.reason ?? "",
			/strict read protection/,
		);
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});

test("recognizes common OpenCode and MiMo tool argument aliases", () => {
	const root = fixture();
	try {
		const guard = new ReadGuard({
			workspaceRoot: root,
			paths: ["generated/library"],
			message: guidance,
		});
		assert.ok(guard.evaluate({
			toolName: "read_file",
			input: { filePath: "generated/library/model.json" },
			cwd: root,
		}));
		assert.ok(guard.evaluate({
			toolName: "exec_command",
			input: { cmd: "cat generated/library/model.json" },
			cwd: root,
		}));
		assert.ok(guard.evaluate({
			toolName: "terminal",
			input: { command: "cat generated/library/model.json" },
			cwd: root,
		}));
		assert.ok(guard.evaluate({
			toolName: "read_files",
			input: { paths: ["src/index.ts", "generated/library/model.json"] },
			cwd: root,
		}));
		assert.ok(guard.evaluate({
			toolName: "run_shell_command",
			input: { command: "cat generated/library/model.json" },
			cwd: root,
		}));
	} finally {
		rmSync(root, { recursive: true, force: true });
	}
});

test("rejects incomplete read-guard configuration", () => {
	assert.throws(() => parseReadGuardConfig({ paths: [], message: guidance }), /non-empty/);
	assert.throws(
		() => parseReadGuardConfig({ paths: ["generated"], message: "", bashMode: "literal" }),
		/readGuard.message/,
	);
});
