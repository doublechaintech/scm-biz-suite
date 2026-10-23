# Agent Context Lifecycle Protocol V1

## Purpose

V1 gives coding-agent adapters explicit, deterministic context lifetimes. An
adapter applies declarations to the model-visible context immediately before a
request. The adapter does not rewrite the host transcript, source Markdown, or
tool artifacts.

This protocol is not a summarizer, compactor, token-budget manager, importance
classifier, retrieval system, long-term memory, vector store, replacement for
host compaction, semantic phase detector, or workflow engine.

## Grammar

Only these complete lines are executable declarations:

```text
<!--ephemeral-->
<!--BLOCK_ID:block_id-->
<!--/BLOCK_ID:block_id-->
<!--DISCARD_BLOCK:block_id-->
```

`block_id` must match `[a-z0-9_-]+`. Tag names are case-sensitive. A tag line
has no leading or trailing characters, and its HTML comment contains no spaces
or tabs. Parsers must not trim, normalize, fuzzy-match, or repair a line before
matching it.

Malformed lifecycle-like comments are ordinary Markdown. Implementations may
also report diagnostics. Ordinary HTML comments have no lifecycle meaning.

V1 blocks cannot nest. A document cannot define the same block ID twice. A
closing ID must exactly equal its opening ID. Invalid block definitions are
ordinary Markdown and do not activate a block.

## Ephemeral messages

An exact `<!--ephemeral-->` line marks its entire containing message or tool
result. The complete original message is allowed into the first applicable
model request. Once a later assistant response exists, subsequent request
views replace the message content with a small tombstone:

```text
[EPHEMERAL:Output omitted after consumption;original_bytes=12345]
```

Message metadata, including tool-call pairing fields, remains intact. The host
transcript and original content object remain unchanged.

## Named blocks

A valid block definition is loaded from an explicitly trusted Markdown context
source and becomes active immediately:

```markdown
<!--BLOCK_ID:phase_modeling-->
Modeling rules and knowledge.
<!--/BLOCK_ID:phase_modeling-->
```

An active block participates in every model request. Conversation turns do not
expire it. Definition order is preserved. If separately loaded sources collide
on an ID, the first definition remains authoritative and the adapter reports a
diagnostic instead of silently replacing it.

## Discard

An exact trusted directive changes a matching active block to `discarded`:

```text
<!--DISCARD_BLOCK:phase_modeling-->
```

The block is absent from the next context view. Repeated discards are
idempotent. An unknown ID does not fail the request and produces an audit
event.

## Trust boundary

Adapters must declare their source policy:

- block definitions are parsed only from explicitly loaded Markdown context
  sources;
- discard directives are executed only from a trusted plugin, host workflow,
  or explicitly trusted message class;
- repository files, web pages, assistant text, and ordinary tool results are
  untrusted unless an adapter deliberately promotes that exact source; and
- invalid or untrusted directives remain visible as ordinary content.

Every activation and discard attempt records the block ID, source, trigger,
request sequence, and timestamp. Consume-once replacement is audited as well.

## Request processing order

For each model request, an adapter:

1. obtains the host's pending context without mutating it;
2. parses declarations from sources allowed by its trust policy;
3. applies trusted control directives to session state;
4. replaces already-consumed ephemeral message content in the request copy;
5. injects active blocks into the request copy; and
6. sends that copy to the model.

The persistent transcript continues to contain the original messages and
artifacts.
