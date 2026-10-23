# Pi adapter

The Pi adapter uses `context`, Pi's request-local context transform,
immediately before every model call. It clones only messages that need a
lifecycle change. Pi's stored transcript is not rewritten. This integration targets Pi 1.4 and later. The dedicated
[marker-policy harness](pi-context-policy.md) uses `context_with_system` and a
controlled resource loader for file exclusion.

## Trusted sources

The default adapter policy is intentionally narrow:

| Operation | Accepted source |
| --- | --- |
| Define a block | Pi `systemPromptOptions.contextFiles` |
| Define a block | A `/skill:name` invocation whose expanded wrapper, registered path, and disk body all match |
| Discard a block | `PiLifecycleAdapter.acceptTrustedControl(...)` |
| Discard a block | `/context-discard block_id` |
| Discard a block | A `custom` message with custom type `agent-context-kit-control` |

Ordinary `user`, `assistant`, and `toolResult` messages are not trusted discard
sources. A host can add another message policy through
`PiAdapterOptions.trustedDiscardSource`; doing so is an explicit trust-boundary
change.

Valid named blocks are removed from Pi's request-local copy of their original
context file or expanded skill. Before each model request, active blocks are
re-injected as a hidden `agent-context-kit-active-v1` custom context message,
which Pi converts to model-visible user context but does not persist. This is
why a discarded block actually disappears rather than surviving in its
original source text.

## Host workflow API

```ts
import { PiLifecycleAdapter } from "@teaql/agent-context-kit/pi";

const adapter = new PiLifecycleAdapter(pi);
adapter.acceptTrustedControl(
  "<!--DISCARD_BLOCK:phase_modeling-->",
  "my-workflow:model-validator",
  "model_validation_passed",
);
```

The adapter appends audit and state snapshot entries as Pi custom entries.
Custom entries do not enter model context, but allow lifecycle state to be
restored when a Pi session is resumed.

## Runtime integration trace

`npm run trace:pi` runs the adapter inside Pi's real `AgentSession`, including
the extension runner, context event, tool execution loop, and provider call.
The provider itself is Pi's deterministic local faux provider so the test has
no credentials, network dependency, or nondeterministic model output.

Each `provider_request` JSONL record captures:

- the lifecycle request sequence and active block IDs;
- whether the block is actually visible at the provider boundary;
- whether the original context-file copy leaked into the system prompt;
- whether ephemeral content is absent, original, or tombstoned;
- the complete provider-visible message list; and
- lifecycle audit events observed so far.

The last `persistent_transcript` record independently checks that the original
ephemeral tool result remains stored and the tombstone was never persisted.
The generated trace lives at `.artifacts/pi-context-trace.jsonl`; it is ignored
by Git because it is a local test artifact.

## Protected read paths

The same Pi extension can block built-in read-oriented tools before execution
and return a configured redirect to the model. This is useful when TeaQL
workspace context already contains the business meaning of generated
libraries. Configure `.agent-context-kit.json` or set
`AGENT_CONTEXT_KIT_CONFIG` to a policy outside the writable workspace. See the
[read-guard guide](read-guard.md).

This hook supplies contextual feedback; it is not a complete operating-system
permission boundary. Use OpenShell or another sandbox to exclude protected
paths from arbitrary processes and custom tools.
