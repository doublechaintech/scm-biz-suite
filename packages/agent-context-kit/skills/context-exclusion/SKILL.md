---
name: context-exclusion
description: Maintain .agent-no-read.md markers for approved generated directories using deterministic scripts. Use when configuring generated-code context exclusion or restoring markers after regeneration, not for ordinary ignore rules or OS permissions.
---

# Generated context exclusion

Use the packaged `scripts/markers.mjs` entry point to maintain `.agent-no-read.md`.
Resolve that script relative to this skill directory; it uses the package's
compiled CLI runtime (or source modules in a checkout), so keep the installed
Agent Context Kit layout intact.

Run from the project root with an explicitly approved project-relative manifest:

```sh
agent-context-markers apply --manifest context-markers.json
agent-context-markers check --manifest context-markers.json
agent-context-markers generate --manifest context-markers.json
```

If the package bin is unavailable, invoke the resolved script with `node` and the
same arguments. No cwd, target-directory, guidance-text or shell-command overrides
are accepted. `apply` creates or updates markers, `check` performs no writes, and
`generate` runs the manifest's fixed generator and restores snapshotted markers in
`finally`, including after command failure or cancellation.

Use existing user/host authorization for the manifest and target directories; this
skill does not authorize arbitrary configuration changes or removal of markers.
Keep the manifest and Markdown guidance outside every generated output directory.
Put stable interface locations, editable source locations and build/test guidance
in the Markdown source. Do not copy implementation details into guidance.

In the dedicated Pi harness, call an already configured fixed build/generation
operation that embeds this script or its SDK helper. This skill does not install a
model-controlled maintenance tool, enable Bash, or bypass the tool allowlist. Treat
`maintenanceFailed` as a failed operation even if generation succeeded; verify or
repair the marker state through the authorized maintenance entry point before
continuing model access. Do not manually read excluded source to diagnose failure.

Read the [maintenance guide](../../docs/context-marker-maintenance.md) for manifest
format, exit codes, regeneration limits and the runnable end-to-end example.
