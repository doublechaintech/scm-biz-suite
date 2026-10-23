# DeepSeek Harness adapter

The export `@teaql/agent-context-kit/deepseek-harness` is a Harness function
plugin. It uses:

- a dynamic system-prompt section for active named blocks;
- `agent/pre-step` to detect a completed consume-once lifecycle; and
- a durable message projection event to replace consumed message content in
  derived requests without changing the original message event.

Add the module to a Harness `cordis.yml` overlay using the absolute resolved
path required by Harness. For a source checkout:

```yaml
- insert:
    - id: agent-context-kit
      name: '/absolute/path/to/agent-context-kit/src/adapters/deepseek-harness.ts'
```

Put trusted declarations in `.agent-context-kit.md` at the session working
directory. Keep that source available when sessions may be resumed; the durable
consume projection replays from the event log, while named block state is
reconstructed from this trusted file.

Harness documents function plugins in its
[plugin tutorial](https://deepseek-harness.github.io/deepseek-harness/en/develop/basic/),
dynamic prompt sections in the
[system-prompt reference](https://github.com/deepseek-ai/deepseek-harness/blob/master/docs/subsystems/system-prompt.md),
and durable projections in the
[session subsystem](https://github.com/deepseek-ai/deepseek-harness/blob/master/docs/subsystems/session.md).
