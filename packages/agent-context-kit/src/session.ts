import { parseMarkdown } from "./parser.ts";
import type {
	AuditEvent,
	ContextBlockDefinition,
	ControlSource,
	LifecycleBlock,
	LifecycleDiagnostic,
	LifecycleMessage,
	LifecycleSnapshot,
	ParsedMarkdown,
} from "./types.ts";

export interface LifecycleSessionOptions {
	clock?: () => Date;
	onAudit?: (event: AuditEvent) => void;
}

export interface BuildContextOptions {
	isTrustedDiscardSource?: (message: LifecycleMessage, index: number) => ControlSource | undefined;
}

export interface BuiltContext<T extends LifecycleMessage> {
	messages: T[];
	requestSequence: number;
}

function contentText(content: unknown): string {
	if (typeof content === "string") return content;
	if (!Array.isArray(content)) return "";
	return content
		.flatMap((part) => {
			if (typeof part !== "object" || part === null) return [];
			const candidate = part as { type?: unknown; text?: unknown };
			return candidate.type === "text" && typeof candidate.text === "string" ? [candidate.text] : [];
		})
		.join("\n");
}

function byteLength(content: unknown): number {
	const serialized = typeof content === "string" ? content : JSON.stringify(content);
	return new TextEncoder().encode(serialized ?? "").byteLength;
}

function hash(input: string): string {
	let value = 0x811c9dc5;
	for (let index = 0; index < input.length; index += 1) {
		value ^= input.charCodeAt(index);
		value = Math.imul(value, 0x01000193);
	}
	return (value >>> 0).toString(16).padStart(8, "0");
}

function messageKey(message: LifecycleMessage, index: number, text: string): string {
	return [
		String(message.role ?? ""),
		String(message.toolCallId ?? ""),
		String(message.timestamp ?? ""),
		String(index),
		hash(text),
	].join(":");
}

function tombstoneContent(content: unknown, bytes: number): unknown {
	const text = `[EPHEMERAL:Output omitted after consumption;original_bytes=${bytes}]`;
	return typeof content === "string" ? text : [{ type: "text", text }];
}

function cloneBlock(block: LifecycleBlock): LifecycleBlock {
	return { ...block };
}

export class LifecycleSession {
	readonly diagnostics: LifecycleDiagnostic[] = [];
	readonly audit: AuditEvent[] = [];

	private readonly blocks = new Map<string, LifecycleBlock>();
	private readonly loadedSourceDocuments = new Set<string>();
	private readonly processedControls = new Set<string>();
	private readonly consumedEphemeral = new Set<string>();
	private readonly clock: () => Date;
	private readonly onAudit: ((event: AuditEvent) => void) | undefined;
	private requestSequenceValue = 0;

	constructor(options: LifecycleSessionOptions = {}) {
		this.clock = options.clock ?? (() => new Date());
		this.onAudit = options.onAudit;
	}

	get requestSequence(): number {
		return this.requestSequenceValue;
	}

	loadMarkdownSource(source: string, markdown: string, trigger = "source_loaded"): ParsedMarkdown {
		const parsed = parseMarkdown(markdown, source);
		this.diagnostics.push(...parsed.diagnostics);
		const sourceDocumentKey = `${source}:${hash(markdown)}`;
		if (this.loadedSourceDocuments.has(sourceDocumentKey)) return parsed;
		this.loadedSourceDocuments.add(sourceDocumentKey);

		for (const definition of parsed.blocks) {
			this.activate(definition, trigger);
		}
		return parsed;
	}

	applyControlMarkdown(markdown: string, control: ControlSource): void {
		const parsed = parseMarkdown(markdown, control.source);
		this.diagnostics.push(...parsed.diagnostics);
		for (const directive of parsed.discards) {
			if (!control.trusted) {
				this.record({
					action: "discard_denied",
					blockId: directive.blockId,
					source: control.source,
					trigger: control.trigger,
					requestSequence: this.requestSequenceValue,
				});
				continue;
			}
			this.discard(directive.blockId, control.source, control.trigger);
		}
	}

	discard(blockId: string, source: string, trigger: string): boolean {
		const block = this.blocks.get(blockId);
		if (!block) {
			this.record({
				action: "discard_unknown",
				blockId,
				source,
				trigger,
				requestSequence: this.requestSequenceValue,
			});
			return false;
		}
		if (block.status === "discarded") {
			this.record({
				action: "discard_already_applied",
				blockId,
				source,
				trigger,
				requestSequence: this.requestSequenceValue,
			});
			return false;
		}
		block.status = "discarded";
		block.discardedAtRequest = this.requestSequenceValue;
		this.record({
			action: "block_discarded",
			blockId,
			source,
			trigger,
			requestSequence: this.requestSequenceValue,
		});
		return true;
	}

	buildContextView<T extends LifecycleMessage>(
		messages: readonly T[],
		options: BuildContextOptions = {},
	): BuiltContext<T> {
		this.requestSequenceValue += 1;

		for (let index = 0; index < messages.length; index += 1) {
			const message = messages[index];
			if (!message) continue;
			const text = contentText(message.content);
			if (!text) continue;
			const parsed = parseMarkdown(text, `message:${index}`);
			if (parsed.discards.length === 0) continue;
			const key = messageKey(message, index, text);
			if (this.processedControls.has(key)) continue;
			this.processedControls.add(key);
			const control = options.isTrustedDiscardSource?.(message, index) ?? {
				source: `message:${String(message.role ?? "unknown")}`,
				trigger: "message_context",
				trusted: false,
			};
			this.applyControlMarkdown(text, control);
		}

		let latestAssistant = -1;
		for (let index = messages.length - 1; index >= 0; index -= 1) {
			if (messages[index]?.role === "assistant") {
				latestAssistant = index;
				break;
			}
		}

		const view = messages.map((message, index) => {
			if (latestAssistant < 0 || index >= latestAssistant) return message;
			const text = contentText(message.content);
			if (!text || !parseMarkdown(text, `message:${index}`).ephemeral) return message;
			const bytes = byteLength(message.content);
			const key = messageKey(message, index, text);
			if (!this.consumedEphemeral.has(key)) {
				this.consumedEphemeral.add(key);
				this.record({
					action: "ephemeral_consumed",
					source: `message:${String(message.role ?? "unknown")}`,
					trigger: "assistant_response_completed",
					requestSequence: this.requestSequenceValue,
					details: { originalBytes: bytes },
				});
			}
			return { ...message, content: tombstoneContent(message.content, bytes) } as T;
		});

		return { messages: view, requestSequence: this.requestSequenceValue };
	}

	activeBlocks(): LifecycleBlock[] {
		return [...this.blocks.values()].filter((block) => block.status === "active").map(cloneBlock);
	}

	renderActiveBlocks(): string {
		return this.activeBlocks()
			.map((block) => {
				const content = block.content.endsWith("\n") ? block.content : `${block.content}\n`;
				return `<!--BLOCK_ID:${block.id}-->\n${content}<!--/BLOCK_ID:${block.id}-->`;
			})
			.join("\n\n");
	}

	snapshot(): LifecycleSnapshot {
		return {
			requestSequence: this.requestSequenceValue,
			blocks: [...this.blocks.values()].map(cloneBlock),
			audit: this.audit.map((event) => ({ ...event, ...(event.details ? { details: { ...event.details } } : {}) })),
			loadedSourceDocuments: [...this.loadedSourceDocuments],
			processedControls: [...this.processedControls],
			consumedEphemeral: [...this.consumedEphemeral],
		};
	}

	restore(snapshot: LifecycleSnapshot): void {
		this.blocks.clear();
		for (const block of snapshot.blocks) this.blocks.set(block.id, cloneBlock(block));
		this.loadedSourceDocuments.clear();
		for (const key of snapshot.loadedSourceDocuments ?? []) this.loadedSourceDocuments.add(key);
		this.processedControls.clear();
		for (const key of snapshot.processedControls ?? []) this.processedControls.add(key);
		this.consumedEphemeral.clear();
		for (const key of snapshot.consumedEphemeral ?? []) this.consumedEphemeral.add(key);
		this.requestSequenceValue = snapshot.requestSequence;
		this.audit.splice(0, this.audit.length, ...snapshot.audit.map((event) => ({ ...event })));
	}

	private activate(definition: ContextBlockDefinition, trigger: string): void {
		const existing = this.blocks.get(definition.id);
		if (existing) {
			if (existing.source === definition.source && existing.content === definition.content) return;
			this.diagnostics.push({
				code: "block-id-conflict",
				message: `Block ${definition.id} conflicts with a previously loaded source`,
				source: definition.source,
				line: definition.startLine,
				text: `<!--BLOCK_ID:${definition.id}-->`,
			});
			return;
		}
		this.blocks.set(definition.id, {
			...definition,
			status: "active",
			activatedAtRequest: this.requestSequenceValue,
		});
		this.record({
			action: "block_activated",
			blockId: definition.id,
			source: definition.source,
			trigger,
			requestSequence: this.requestSequenceValue,
		});
	}

	private record(event: Omit<AuditEvent, "timestamp">): void {
		const complete: AuditEvent = { ...event, timestamp: this.clock().toISOString() };
		this.audit.push(complete);
		this.onAudit?.(complete);
	}
}

export function getMessageText(message: LifecycleMessage): string {
	return contentText(message.content);
}
