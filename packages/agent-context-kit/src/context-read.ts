import { closeSync, constants, fstatSync, openSync, readSync, statSync } from "node:fs";
import { resolve } from "node:path";
import { ContextAccessDenied, ContextFiles } from "./context-files.ts";

export class ContextReadError extends Error {
	readonly details: Record<string, unknown>;
	constructor(path: string, code: string, message: string, size?: number) {
		super(code);
		this.details = { status: "readError", path, code, message, ...(size === undefined ? {} : { fileSize: size }) };
	}
}

export function contextImageMime(body: Buffer): string | undefined {
	if (body.subarray(0, 8).equals(Buffer.from([137, 80, 78, 71, 13, 10, 26, 10]))) return "image/png";
	if (body[0] === 0xff && body[1] === 0xd8 && body[2] === 0xff) return "image/jpeg";
	if (/^GIF8[79]a/.test(body.subarray(0, 6).toString("ascii"))) return "image/gif";
	if (body.subarray(0, 4).toString() === "RIFF" && body.subarray(8, 12).toString() === "WEBP") return "image/webp";
	if (body.subarray(0, 2).toString() === "BM") return "image/bmp";
	return undefined;
}

/** Checks policy first, then metadata and at most 512 header bytes. Never loads an oversized body. */
export function inspectContextRead(files: ContextFiles, requested: string, maxBytes = 10 * 1024 * 1024): void {
	const path = resolve(files.root, requested);
	let decision;
	try { decision = files.require(requested); }
	catch (error) {
		if (!(error instanceof ContextAccessDenied) || error.decision.status !== "policyError") throw error;
		try { statSync(path); }
		catch (cause) {
			if ((cause as NodeJS.ErrnoException).code === "ENOENT") throw new ContextReadError(path, "FILE_NOT_FOUND", "The file does not exist. Do not repeat the same read; verify the path or create the intended file first.");
			if ((cause as NodeJS.ErrnoException).code === "EACCES") throw new ContextReadError(path, "READ_ACCESS_DENIED", "The file cannot be read with current permissions. Report the blocker; do not retry unchanged permissions.");
		}
		throw error;
	}
	let fd: number | undefined;
	try {
		fd = openSync(decision.realPath, constants.O_RDONLY | constants.O_NONBLOCK);
		const info = fstatSync(fd);
		if (!info.isFile()) throw new ContextReadError(path, "UNSUPPORTED_FILE_TYPE", "The read tool requires an ordinary file. Use ls for a permitted directory.");
		const header = Buffer.alloc(Math.min(info.size, 512));
		const count = readSync(fd, header, 0, header.length, 0);
		const prefix = header.subarray(0, count);
		if (!contextImageMime(prefix) && (prefix.includes(0) || prefix.subarray(0, 4).equals(Buffer.from([127, 69, 76, 70])))) {
			throw new ContextReadError(path, "UNSUPPORTED_BINARY", "This is a binary/compiled file, not compiler diagnostics. Do not retry with another offset or limit. Use app_build for compiler diagnostics or app_test for test results when those tools are registered.", info.size);
		}
		if (info.size > maxBytes) throw new ContextReadError(path, "FILE_TOO_LARGE", "The file exceeds the read input limit. Changing offset/limit will not help. Use a smaller text artifact or a registered diagnostic tool; do not retry this unchanged file.", info.size);
		files.require(requested);
	} catch (error) {
		if (error instanceof ContextReadError || error instanceof ContextAccessDenied) throw error;
		if ((error as NodeJS.ErrnoException).code === "EACCES") throw new ContextReadError(path, "READ_ACCESS_DENIED", "The file cannot be read with current permissions. Do not retry unchanged permissions; report the blocker.");
		throw new ContextReadError(path, "READ_FAILED", "The file read failed. Do not retry the same request unchanged; use a permitted diagnostic tool or report the blocker.");
	} finally { if (fd !== undefined) closeSync(fd); }
}
