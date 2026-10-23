export type DiagnosticCode =
	| "invalid-lifecycle-tag"
	| "nested-block"
	| "duplicate-block-id"
	| "mismatched-block-end"
	| "unexpected-block-end"
	| "unclosed-block"
	| "block-id-conflict";

export interface LifecycleDiagnostic {
	code: DiagnosticCode;
	message: string;
	source: string;
	line: number;
	text: string;
}

export interface ContextBlockDefinition {
	id: string;
	source: string;
	content: string;
	startLine: number;
	endLine: number;
}

export interface DiscardDirective {
	blockId: string;
	line: number;
}

export interface ParsedMarkdown {
	source: string;
	ephemeral: boolean;
	blocks: ContextBlockDefinition[];
	discards: DiscardDirective[];
	diagnostics: LifecycleDiagnostic[];
	/** The input with only valid named block definitions removed. */
	ordinaryMarkdown: string;
}

export type BlockStatus = "active" | "discarded";

export interface LifecycleBlock extends ContextBlockDefinition {
	status: BlockStatus;
	activatedAtRequest: number;
	discardedAtRequest?: number;
}

export type AuditAction =
	| "block_activated"
	| "block_discarded"
	| "discard_already_applied"
	| "discard_unknown"
	| "discard_denied"
	| "ephemeral_consumed";

export interface AuditEvent {
	action: AuditAction;
	blockId?: string;
	source: string;
	trigger: string;
	requestSequence: number;
	timestamp: string;
	details?: Record<string, string | number | boolean>;
}

export interface LifecycleMessage {
	role?: unknown;
	content?: unknown;
	toolCallId?: unknown;
	timestamp?: unknown;
	customType?: unknown;
	[key: string]: unknown;
}

export interface LifecycleSnapshot {
	requestSequence: number;
	blocks: LifecycleBlock[];
	audit: AuditEvent[];
	/** Adapter bookkeeping needed when a hook process is recreated per request. */
	loadedSourceDocuments?: string[];
	processedControls?: string[];
	consumedEphemeral?: string[];
}

export interface ControlSource {
	source: string;
	trigger: string;
	trusted: boolean;
}
