# Hermes Agent adapter

Hermes Agent documents the three native plugin surfaces needed by this
adapter: `pre_llm_call` for request-local context, `pre_tool_call` for tool
vetoes, and `register_command()` for a trusted in-session discard action. The
same plugin runs in CLI, TUI, Desktop, and gateway sessions.

## Install

Install the repository as a custom Hermes plugin and enable it:

```bash
hermes plugins install teaql/agent-context-kit --enable
```

For a reproducible deployment, pin a full commit SHA:

```bash
hermes plugins install teaql/agent-context-kit \
  --ref <full-40-character-commit-sha> \
  --enable
```

Confirm the plugin is active, then start a new session in the target project:

```bash
hermes plugins list
hermes chat
```

Hermes plugins execute in-process with the user's permissions. Review the
source before enabling a custom Git plugin.

## Workspace context

Put trusted declarations in `.agent-context-kit.md` at the session workspace:

```markdown
<!--BLOCK_ID:phase_modeling-->
Use the TeaQL workspace model as the business-context authority.
<!--/BLOCK_ID:phase_modeling-->
```

The `pre_llm_call` hook injects active blocks only into the current LLM call.
Hermes documents that this injected context is not written to conversation
history, preserving both the host transcript and its prompt cache.

Discard a block explicitly for only the calling session:

```text
/context-discard phase_modeling
```

The command is the trusted discard boundary. Ordinary model messages are not
treated as trusted discard controls.

## Protected reads

The shared `.agent-context-kit.json` format enables the read guard:

```json
{
  "readGuard": {
    "paths": ["generated/library"],
    "message": "TeaQL workspace context already provides the complete business model; use it instead.",
    "bashMode": "literal"
  }
}
```

The documented `pre_tool_call` hook blocks matching `read_file` and
`search_files` calls before execution. It also handles Hermes's `terminal`
tool according to `bashMode`. Invalid guard configuration fails closed for
those three tools instead of silently disabling the policy.

This guard is model-facing policy, not a filesystem security boundary.
`execute_code`, third-party tools, MCP servers, remote terminal backends, and
processes outside Hermes may access paths independently. Use OpenShell or
another OS-level sandbox for non-bypassable enforcement; see the
[read-guard guide](read-guard.md).

## Host limit

Hermes passes a copy of conversation history to `pre_llm_call` and documents
only a returned context string; it does not document arbitrary replacement of
earlier messages. The adapter therefore supports persistent workspace blocks,
trusted discard, and protected-read feedback, but does not claim V1
consume-once ephemeral transcript rewriting.

Official references:

- [Hermes plugins](https://hermes-agent.nousresearch.com/docs/user-guide/features/plugins)
- [Hermes event hooks](https://hermes-agent.nousresearch.com/docs/user-guide/features/hooks)
- [Hermes tools reference](https://hermes-agent.nousresearch.com/docs/reference/tools-reference)
