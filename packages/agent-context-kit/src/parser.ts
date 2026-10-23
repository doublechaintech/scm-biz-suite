import type {
	ContextBlockDefinition,
	LifecycleDiagnostic,
	ParsedMarkdown,
} from "./types.ts";

const EPHEMERAL = "<!--ephemeral-->";
const BLOCK_START = /^<!--BLOCK_ID:([a-z0-9_-]+)-->$/;
const BLOCK_END = /^<!--\/BLOCK_ID:([a-z0-9_-]+)-->$/;
const DISCARD = /^<!--DISCARD_BLOCK:([a-z0-9_-]+)-->$/;

interface SourceLine {
	text: string;
	full: string;
	line: number;
	start: number;
	end: number;
}

interface OpenBlock {
	id: string;
	line: number;
	startOffset: number;
	contentOffset: number;
	invalid: boolean;
}

function linesOf(markdown: string): SourceLine[] {
	const lines: SourceLine[] = [];
	const expression = /([^\r\n]*)(\r\n|\n|\r|$)/g;
	let line = 1;
	let match: RegExpExecArray | null;
	while ((match = expression.exec(markdown)) !== null) {
		const full = `${match[1] ?? ""}${match[2] ?? ""}`;
		if (full.length === 0) break;
		lines.push({
			text: match[1] ?? "",
			full,
			line,
			start: match.index,
			end: match.index + full.length,
		});
		line += 1;
		if ((match[2] ?? "") === "") break;
	}
	return lines;
}

function looksLikeLifecycleTag(line: string): boolean {
	return /<!--[^\r\n]*(?:ephemeral|\/?block_id|discard_block)[^\r\n]*-->/i.test(line);
}

function diagnostic(
	diagnostics: LifecycleDiagnostic[],
	source: string,
	line: SourceLine,
	code: LifecycleDiagnostic["code"],
	message: string,
): void {
	diagnostics.push({ code, message, source, line: line.line, text: line.text });
}

/**
 * Parse V1 lifecycle declarations without trimming, repairing, or fuzzy
 * matching. Invalid declarations remain ordinary Markdown.
 */
export function parseMarkdown(markdown: string, source = "unknown"): ParsedMarkdown {
	const lines = linesOf(markdown);
	const diagnostics: LifecycleDiagnostic[] = [];
	const blocks: ContextBlockDefinition[] = [];
	const discards: ParsedMarkdown["discards"] = [];
	const declaredIds = new Set<string>();
	const declarationCounts = new Map<string, number>();
	for (const line of lines) {
		const start = BLOCK_START.exec(line.text);
		if (!start) continue;
		const id = start[1] as string;
		declarationCounts.set(id, (declarationCounts.get(id) ?? 0) + 1);
	}
	const duplicateIds = new Set(
		[...declarationCounts].filter(([, count]) => count > 1).map(([id]) => id),
	);
	const removableRanges: Array<{ start: number; end: number }> = [];
	let ephemeral = false;
	let open: OpenBlock | undefined;

	for (const line of lines) {
		const start = BLOCK_START.exec(line.text);
		const end = BLOCK_END.exec(line.text);
		const discard = DISCARD.exec(line.text);

		if (line.text === EPHEMERAL) {
			ephemeral = true;
			continue;
		}

		if (start) {
			const id = start[1] as string;
			if (open) {
				open.invalid = true;
				diagnostic(
					diagnostics,
					source,
					line,
					"nested-block",
					`Block ${id} is nested inside ${open.id}; V1 blocks cannot be nested`,
				);
				continue;
			}

			const repeatedDeclaration = declaredIds.has(id);
			declaredIds.add(id);
			if (repeatedDeclaration) {
				diagnostic(
					diagnostics,
					source,
					line,
					"duplicate-block-id",
					`Block ${id} is defined more than once in the same document`,
				);
			}
			open = {
				id,
				line: line.line,
				startOffset: line.start,
				contentOffset: line.end,
				invalid: duplicateIds.has(id),
			};
			continue;
		}

		if (end) {
			const id = end[1] as string;
			if (!open) {
				diagnostic(
					diagnostics,
					source,
					line,
					"unexpected-block-end",
					`Block end ${id} has no matching start`,
				);
				continue;
			}
			if (id !== open.id) {
				open.invalid = true;
				diagnostic(
					diagnostics,
					source,
					line,
					"mismatched-block-end",
					`Block ${open.id} cannot be closed by ${id}`,
				);
				continue;
			}

			if (!open.invalid) {
				blocks.push({
					id: open.id,
					source,
					content: markdown.slice(open.contentOffset, line.start),
					startLine: open.line,
					endLine: line.line,
				});
				removableRanges.push({ start: open.startOffset, end: line.end });
			}
			open = undefined;
			continue;
		}

		if (discard) {
			discards.push({ blockId: discard[1] as string, line: line.line });
			continue;
		}

		if (looksLikeLifecycleTag(line.text)) {
			diagnostic(
				diagnostics,
				source,
				line,
				"invalid-lifecycle-tag",
				"Lifecycle-like comment does not match the strict V1 grammar",
			);
		}
	}

	if (open) {
		const line = lines.find((candidate) => candidate.line === open?.line);
		if (line) {
			diagnostic(
				diagnostics,
				source,
				line,
				"unclosed-block",
				`Block ${open.id} has no matching end`,
			);
		}
	}

	let cursor = 0;
	let ordinaryMarkdown = "";
	for (const range of removableRanges) {
		ordinaryMarkdown += markdown.slice(cursor, range.start);
		cursor = range.end;
	}
	ordinaryMarkdown += markdown.slice(cursor);

	return { source, ephemeral, blocks, discards, diagnostics, ordinaryMarkdown };
}

export const lifecycleSyntax = {
	ephemeral: EPHEMERAL,
	blockStart: BLOCK_START,
	blockEnd: BLOCK_END,
	discard: DISCARD,
} as const;
