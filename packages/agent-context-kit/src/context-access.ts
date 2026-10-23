import { closeSync, constants, fstatSync, lstatSync, openSync, readSync, realpathSync, statSync } from "node:fs";
import { dirname, isAbsolute, relative, resolve, sep } from "node:path";

export const contextAccessLimits = { markerBytes: 8192, guidanceBytes: 1024 } as const;
export const contextAccessMarker = ".agent-no-read.md";

export interface ContextGuidance {
	reason: string;
	guidance: string;
}

export type ContextAccessDecision =
	| { status: "allow"; path: string; realPath: string }
	| ({ status: "excluded"; path: string; markerPath: string; source: "project_marker_data" } & ContextGuidance)
	| { status: "outOfScope"; path: string }
	| { status: "policyError"; path: string; reason: string };

function defaults(): ContextGuidance {
	return {
		reason: "This directory is excluded from model context by .agent-no-read.md.",
		guidance: "Use public interface documentation or permitted source directories. Use the harness build/test tools for verification.",
	};
}

function truncate(value: string, bytes: number): string {
	let result = "";
	for (const character of value) {
		const size = Buffer.byteLength(character);
		if (size > bytes) break;
		result += character;
		bytes -= size;
	}
	return result;
}

/** Decodes bounded Markdown project data; no frontmatter, links or commands are evaluated. */
export function parseContextMarker(body: Uint8Array): ContextGuidance {
	const fallback = defaults();
	if (body.byteLength > contextAccessLimits.markerBytes) return fallback;
	let markdown: string;
	try {
		markdown = new TextDecoder("utf-8", { fatal: true }).decode(body).trim();
	} catch {
		return fallback;
	}
	if (!markdown) return fallback;
	return {
		reason: fallback.reason,
		guidance: truncate(markdown, contextAccessLimits.guidanceBytes - Buffer.byteLength(fallback.reason)),
	};
}

function contains(root: string, path: string): boolean {
	const part = relative(root, path);
	return part === "" || (part !== ".." && !part.startsWith(`..${sep}`) && !isAbsolute(part));
}

function absent(error: unknown): boolean {
	return (error as NodeJS.ErrnoException).code === "ENOENT";
}

// Walk from the explicit policy root only. A marker is effective regardless of its type/body.
function findMarker(root: string, directory: string): string | undefined {
	const chain: string[] = [];
	for (let cursor = directory; ; cursor = dirname(cursor)) {
		chain.push(cursor);
		if (cursor === root) break;
		if (dirname(cursor) === cursor) throw new Error("Invalid policy scope");
	}
	for (const directory of chain.reverse()) {
		const marker = resolve(directory, contextAccessMarker);
		try {
			lstatSync(marker);
			return marker;
		} catch (error) {
			if (!absent(error)) throw error;
		}
	}
	return undefined;
}

function markerGuidance(marker: string): ContextGuidance {
	let fd: number | undefined;
	try {
		// Never follow a marker symlink or read special files (e.g. a FIFO).
		if (!lstatSync(marker).isFile()) return defaults();
		fd = openSync(marker, constants.O_RDONLY | constants.O_NOFOLLOW | constants.O_NONBLOCK);
		const info = fstatSync(fd);
		if (!info.isFile() || info.size > contextAccessLimits.markerBytes) return defaults();
		const buffer = Buffer.alloc(contextAccessLimits.markerBytes + 1);
		let length = 0;
		while (length < buffer.length) {
			const count = readSync(fd, buffer, length, buffer.length - length, null);
			if (count === 0) break;
			length += count;
		}
		return parseContextMarker(buffer.subarray(0, length));
	} catch {
		return defaults();
	} finally {
		if (fd !== undefined) closeSync(fd);
	}
}

/**
 * Context policy, not an OS sandbox. Existing files/directories only; missing targets,
 * broken links and filesystem errors fail closed. No cross-call cache or target content reads.
 */
export function checkContextAccess(
	projectRoot: string,
	targetPath: string,
): ContextAccessDecision {
	let path = targetPath;
	try {
		if (!isAbsolute(projectRoot)) {
			throw new Error("Policy root must be absolute");
		}
		const root = resolve(projectRoot);
		path = resolve(root, targetPath);
		if (!contains(root, path)) return { status: "outOfScope", path };
		if (!statSync(root).isDirectory()) throw new Error("Policy root must be a directory");
		const realRoot = realpathSync(root);
		// First inspect lexical ancestors, even when the target is a broken/outbound link.
		const lexicalParent = path === root ? root : dirname(path);
		const parentMarker = findMarker(root, lexicalParent);
		const excluded = (markerPath: string): ContextAccessDecision => ({
			status: "excluded", path, markerPath, source: "project_marker_data", ...markerGuidance(markerPath),
		});
		// A lexical chain can traverse an outbound directory link. Do not load its marker data.
		const inScopeMarker = (marker: string | undefined): string | undefined =>
			marker && contains(realRoot, realpathSync(dirname(marker))) ? marker : undefined;
		const lexicalAncestor = inScopeMarker(parentMarker);
		let realPath: string;
		try {
			realPath = realpathSync(path);
		} catch (error) {
			if (lexicalAncestor) return excluded(lexicalAncestor);
			throw error;
		}
		if (!contains(realRoot, realPath)) {
			return lexicalAncestor ? excluded(lexicalAncestor) : { status: "outOfScope", path };
		}
		const directory = statSync(path).isDirectory();
		const lexicalMarker = lexicalAncestor ?? (directory ? inScopeMarker(findMarker(root, path)) : undefined);
		const realMarker = findMarker(realRoot, directory ? realPath : dirname(realPath));
		// Compare canonical directory depths so a short symlink alias cannot promote a child marker.
		const candidates = [
			...(lexicalMarker ? [lexicalMarker] : []),
			...(realMarker ? [realMarker] : []),
		];
		const depth = (marker: string) => relative(realRoot, realpathSync(dirname(marker))).split(sep).filter(Boolean).length;
		candidates.sort((a, b) => depth(a) - depth(b));
		if (candidates[0]) return excluded(candidates[0]);
		return { status: "allow", path, realPath };
	} catch {
		return { status: "policyError", path, reason: "Unable to determine context access; content must not be returned." };
	}
}
