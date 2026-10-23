# Cline adapter

The Cline plugin registers a message builder for provider-bound history and a
`beforeTool` policy hook. It supports consume-once ephemeral messages,
persistent blocks, trusted discard, and protected reads.

## Install

Install the repository as a global Cline plugin:

```bash
cline plugin install --git github.com/teaql/agent-context-kit
```

For the current project only:

```bash
cline plugin install --git github.com/teaql/agent-context-kit --cwd .
```

Confirm it appears in `cline config`, then start a new Cline session. Put
trusted declarations in `.agent-context-kit.md` and the protected-read policy
in `.agent-context-kit.json`.

Cline's current public plugin documentation limits this installation path to
the SDK, CLI, and Kanban surfaces. This project does not claim that the adapter
loads in the VS Code or JetBrains extensions until Cline documents that path.

Official references:

- [Cline plugin installation](https://github.com/cline/cline/blob/main/docs/sdk/plugin-install.mdx)
- [Cline plugin API examples](https://github.com/cline/cline/blob/main/sdk/examples/plugins/README.md)
