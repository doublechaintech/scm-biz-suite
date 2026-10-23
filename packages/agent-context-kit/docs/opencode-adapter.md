# OpenCode adapter

The package root is an OpenCode plugin with separate implementations for the
current V2 API and the documented V1 compatibility entry point.

## Install

Install globally from GitHub:

```bash
opencode plugin add github:teaql/agent-context-kit
opencode plugin list
```

Or configure the Git package for one project:

```jsonc
{
  "$schema": "https://opencode.ai/config.json",
  "plugins": ["github:teaql/agent-context-kit"]
}
```

OpenCode V2 is the primary target. V1 package-object compatibility requires
OpenCode 1.18.29 or later.

## Trusted context

Put lifecycle declarations in `.agent-context-kit.md` at the project root:

```markdown
<!--BLOCK_ID:phase_modeling-->
Keep these modeling rules active.
<!--/BLOCK_ID:phase_modeling-->
```

The adapter loads that file as the trusted definition and discard source. It
injects active blocks into the request-local system context and replaces
already-consumed ephemeral message content with a tombstone without changing
the stored transcript. State is isolated by OpenCode session ID.

To discard a block, update the trusted file:

```markdown
<!--DISCARD_BLOCK:phase_modeling-->
```

Ordinary user, assistant, and tool messages cannot discard a trusted block.

## Protected reads

Use the same `.agent-context-kit.json` format described in the
[read-guard guide](read-guard.md). The V2 adapter rejects a matching tool call
from `execute.before`; the V1 adapter throws from its documented blocking hook.
The error contains the configured TeaQL redirect message seen by the model.

The tool hook is not an operating-system sandbox. Use OpenShell or another
filesystem boundary when the restriction must be non-bypassable.
