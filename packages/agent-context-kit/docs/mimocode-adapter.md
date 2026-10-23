# MiMo Code adapter

MiMo Code's maintained plugin SDK source exposes the hooks needed for the V1
lifecycle protocol. The message and system transforms are still named
`experimental`, so this adapter is source-verified but remains experimental.

## Install

MiMo Code 0.1.15 or later is required. From the target project:

```bash
mkdir -p .mimocode/plugins
npm install --prefix .mimocode github:teaql/agent-context-kit
cp .mimocode/node_modules/@teaql/agent-context-kit/integrations/mimocode/agent-context-kit.ts \
  .mimocode/plugins/agent-context-kit.ts
```

Restart `mimo` after installation. The copied file exports the adapter from
the locally installed package, so package updates do not require editing the
entry file.

The `.mimocode/plugins/` path is intentional. MiMo Code's loader source scans
that project directory and the global `~/.config/mimocode/plugins/` directory;
an inherited public page still showing `.opencode/plugins/` is not accurate for
MiMo Code.

## Context lifecycle

Keep trusted declarations in `.agent-context-kit.md` at the project root. The
adapter infers the session ID from each message envelope, keeps independent
state for concurrent main and subagent sessions, transforms only the outgoing
message view, and appends active blocks to the outgoing system prompt.

Trusted discard directives also belong in `.agent-context-kit.md`. Discard
directives appearing in model-visible messages are denied.

## Protected reads

Add `.agent-context-kit.json` as described in the
[read-guard guide](read-guard.md). MiMo Code's typed
`tool.execute.before` result includes `cancel` and `cancelReason`; the adapter
uses both, so a protected read is skipped and the configured TeaQL guidance is
returned to the agent.

This remains a model-facing guard rather than an OS security boundary. Pair it
with OpenShell when bypass prevention is required.
