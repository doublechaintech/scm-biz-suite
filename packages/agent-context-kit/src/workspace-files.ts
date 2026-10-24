import { closeSync, constants, fchmodSync, fsyncSync, linkSync, openSync, renameSync, statSync, unlinkSync, writeFileSync } from "node:fs";
import { randomUUID } from "node:crypto";
import { dirname, resolve } from "node:path";
import { ContextFiles } from "./context-files.ts";
import { FileAccessPolicy, type FileMutationDecision, type FileOperation, type FilePolicyOptions } from "./file-policy.ts";

export type MutationResult = Exclude<FileMutationDecision, { status: "allow" }> | { status: "ok" };
const MAX_WRITE_BYTES = 2 * 1024 * 1024;

/** Controlled ordinary-file mutations. Never returns original content or a diff. */
export class WorkspaceFiles {
	readonly policy: FileAccessPolicy;
	readonly context: ContextFiles;
	constructor(options: FilePolicyOptions) {
		this.policy = new FileAccessPolicy(options);
		this.context = new ContextFiles(this.policy.root);
	}

	private perform(operation: FileOperation, path: string, action: (paths: string[]) => void, destination?: string): MutationResult {
		const decision = this.policy.checkMutation(operation, path, destination);
		if (decision.status !== "allow") return decision;
		try { action(decision.paths); return { status: "ok" }; }
		catch { return { status: "policyError", reason: "File operation could not be completed." }; }
	}

	create(path: string, content: string): MutationResult {
		if (typeof content !== "string" || Buffer.byteLength(content) > MAX_WRITE_BYTES) return { status: "policyError", reason: "Invalid or oversized text content." };
		return this.perform("create", path, ([target]) => {
			const fd = openSync(target!, constants.O_WRONLY | constants.O_CREAT | constants.O_EXCL | constants.O_NOFOLLOW, 0o600);
			try { writeFileSync(fd, content, "utf8"); } finally { closeSync(fd); }
		});
	}

	/** Exact single-match edit; no regex, fuzzy patches, shell or generated previews. */
	edit(path: string, oldText: string, newText: string): MutationResult {
		if (typeof oldText !== "string" || !oldText || typeof newText !== "string" || Buffer.byteLength(newText) > MAX_WRITE_BYTES) {
			return { status: "policyError", reason: "An exact non-empty oldText and bounded newText are required." };
		}
		return this.perform("edit", path, ([target]) => {
			const body = new TextDecoder("utf-8", { fatal: true }).decode(this.context.read(target!));
			const start = body.indexOf(oldText);
			if (start < 0 || body.indexOf(oldText, start + 1) >= 0) throw new Error("Edit must match once");
			this.replace(target!, body.slice(0, start) + newText + body.slice(start + oldText.length));
		});
	}

	overwrite(path: string, content: string): MutationResult {
		if (typeof content !== "string" || Buffer.byteLength(content) > MAX_WRITE_BYTES) return { status: "policyError", reason: "Invalid or oversized text content." };
		return this.perform("overwrite", path, ([target]) => this.replace(target!, content));
	}

	private replace(target: string, content: string): void {
		if (Buffer.byteLength(content) > MAX_WRITE_BYTES) throw new Error("Oversized content");
		const temporary = resolve(dirname(target), `.agent-context-tmp-${randomUUID()}`);
		let fd: number | undefined;
		try {
			fd = openSync(temporary, constants.O_WRONLY | constants.O_CREAT | constants.O_EXCL, 0o600);
			writeFileSync(fd, content, "utf8");
			fchmodSync(fd, statSync(target).mode & 0o777);
			fsyncSync(fd); closeSync(fd); fd = undefined;
			if (this.policy.checkMutation("overwrite", target).status !== "allow") throw new Error("Policy changed");
			renameSync(temporary, target);
		} finally {
			if (fd !== undefined) closeSync(fd);
			try { unlinkSync(temporary); } catch (error) { if ((error as NodeJS.ErrnoException).code !== "ENOENT") throw error; }
		}
	}

	delete(path: string): MutationResult {
		return this.perform("delete", path, ([target]) => unlinkSync(target!));
	}

	move(path: string, destination: string): MutationResult {
		return this.perform("move", path, ([source, target]) => {
			// No clobber: link fails if a destination appeared after validation. Ordinary files only.
			linkSync(source!, target!);
			try { unlinkSync(source!); } catch (error) { unlinkSync(target!); throw error; }
		}, destination);
	}
}
