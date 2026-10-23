# Controlled build and test tools

The dedicated [Pi 1.4 harness](pi-context-policy.md) can expose fixed `build` and
`test` tools. Trusted host code supplies their executable and argument arrays;
the model passes `{}` only. Both fixed task tools declare sequential execution
so model file-tool calls do not overlap a regenerating build. There is no command discovery from package scripts,
marker guidance, project JSON or natural-language skill instructions.

```ts
const { session } = await createContextPolicyPiSession({
  projectRoot: "/absolute/project",
  agentDir: "/absolute/pi/agent",
  commands: {
    build: {
      executable: process.execPath,
      args: ["/absolute/trusted-adapters/typescript-build.mjs"],
      includeAllowedSource: true,
    },
    test: {
      executable: process.execPath,
      args: [
        "--test",
        "--test-reporter=/absolute/trusted-adapters/node-test-jsonl.mjs",
        "test/runtime.test.mjs",
      ],
    },
  },
});
```

Copy or reference the supplied example adapters:

- [TypeScript build/check adapter](../examples/pi-context/typescript-build.mjs):
  loads the project's tsconfig.json, runs TypeScript diagnostics and emit according
  to its options (including `noEmit`), and emits diagnostic metadata. It requires
  `typescript` resolvable from the adapter's installation. TypeScript is a dev
  dependency here, not a new runtime dependency of the core policy package.
- [Node test reporter](../examples/pi-context/node-test-jsonl.mjs): used with
  `node --test --test-reporter=...`; emits failure locations and final counts,
  discarding test names, assertion values, stack traces and test stdout/stderr.

Other build systems can use the small protocol below. A fixed plain command such
as `npm run build` also works, but returns only its exit status unless a trusted
adapter emits protocol records. Unrecognized output is suppressed, not shown as a
fallback. For a generator that removes its output directory, use the
[marker-restoring wrapper](context-marker-maintenance.md) inside the fixed build
adapter. No AMD installation is included.

## Command execution

`commands.build` and `commands.test` are optional. Only configured tools are
registered. Commands and summary maps are validated and copied before tools are
created, so later mutations of the caller's arrays do not change the command.
Both tools have an empty-object schema and also validate direct SDK calls. Model
inputs cannot add arguments, environment variables, stdin, output paths or a
working directory. The working directory is always the configured project root.

The runner uses `spawn` with `shell: false`, ignored stdin, piped stdout/stderr,
and the host environment (excluding Node's internal `NODE_TEST_CONTEXT` transport
flag so nested Node test commands run independently). A configured executable may
internally invoke compilers, test runners or shells and access the full project,
including excluded files. This is an intentional build/test capability; it is not
arbitrary model-selected Bash.

Limits are host configuration only:

| Setting | Default | Maximum |
| --- | --- | --- |
| `timeoutMs` | 120 seconds | 15 minutes |
| `maxOutputBytes` | 1 MiB combined stdout/stderr | 16 MiB |
| Protocol record size | 64 KiB | fixed |
| Returned diagnostics | 64 | fixed |
| Unique exclusion guidance entries | 5 | fixed |
| Optional permitted excerpts | 3 lines, 200 characters per line | fixed |

Timeout, cancellation and output overflow terminate the process. POSIX processes
run in their own process group, terminated with SIGTERM then SIGKILL after 250 ms;
on Windows only the direct child is terminated, so process-tree cleanup requires
a host facility if Windows support is needed. No raw output is streamed through
Pi updates, logged, persisted as a tool result, or saved to an output artifact by
the runner. Fixed project commands may write their own artifacts internally.

## JSONL protocol v1

Only stdout is parsed. Stderr is drained and suppressed. Each stdout record is
one JSON object on one line with `version: 1` and a recognized `type`.

```json
{"version":1,"type":"diagnostic","path":"generated/runtime.ts","line":12,"column":7,"severity":"error","code":"TS2322"}
{"version":1,"type":"testSummary","passed":18,"failed":1,"skipped":2}
```

Diagnostic paths are optional, relative to the fixed project root or absolute.
Line/column numbers must be positive integers; summary counts must be nonnegative
integers, each at most one billion. Severity is `error`, `warning` or `info`, with
`error` as the default. The last valid test-summary record supplies final counts.
A command is successful only if it exits zero, reports no error diagnostics, and
reports no failing tests. Cancellation, timeout, overflow and spawn errors have
distinct result statuses.

No child-provided `message`, `summary`, `excerpt`, `source`, test name, assertion
body, stack trace, nested related location or unknown property is forwarded. ANSI
output, ordinary compiler headers, malformed JSON, unknown versions/types and
oversized records are discarded. Partial lines and UTF-8 chunk boundaries are
handled without forwarding incomplete raw output. Record/output limits bound
resource use; they are not the filtering mechanism.

## Error summaries and source handling

The harness creates summaries from a trusted finite code-to-description map,
never by redacting arbitrary child messages. Built-in codes include TS1005,
TS2307, TS2322, TS2339, TS2345, TEST_FAILURE and BUILD_FAILURE. Additional stable
codes can be configured with `diagnosticSummaries`, for example:

```ts
diagnosticSummaries: {
  API_COMPATIBILITY: "The generated interface does not satisfy its compatibility contract.",
}
```

Codes must match `[A-Z0-9_]{1,32}` and descriptions must be nonempty, at most 512
UTF-8 bytes. Unknown codes produce a generic fixed summary and the original code
is not echoed. This sacrifices arbitrary compiler-message detail to avoid
returning source embedded in identifiers, literal values or assertion messages.
Register useful summaries for the diagnostics emitted by each trusted adapter.

After the command ends, each diagnostic path passes the same `.agent-no-read.md`
policy as file tools. Canonical absolute paths emitted under a symlinked project
root are mapped back to the configured root before checking. Existing in-scope
file locations can be returned even when excluded, as required for diagnostics;
nonexistent or out-of-scope paths are not echoed as arbitrary process strings.

- Excluded files retain location, severity, registered code and fixed summary,
  with `access: "excluded"`. Their source is never read for excerpts. Bounded,
  deduplicated marker guidance appears in the result's `exclusions` field.
- Allowed files have no excerpt by default. With `includeAllowedSource: true`,
  the harness reads up to three nearby lines from the actual policy-checked file,
  not from process output. Unsupported, oversized or unreadable files omit source.
- Policy errors and external locations omit excerpts and unverified locations.

New markers written while a command runs affect the diagnostics returned from that
command. There is no cross-call diagnostic or permission cache. Already returned
history is not erased. Generated artifacts or copies outside marked directories
need their own markers; content identity tracking is outside this policy.

The SDK also exports `runControlledTask` from `@teaql/agent-context-kit/controlled-tasks`
and `createContextPolicyTaskTools` from `@teaql/agent-context-kit/pi-context` for
trusted hosts. Installing only those helpers does not cover other tools or auto
context loading; the complete session factory is the supported harness path.

## Bash coverage

| Entry point | Status |
| --- | --- |
| Model `bash`/PowerShell tools | Not registered by the factory |
| Model tools outside guarded files and configured tasks | Rejected by a tool-call allowlist |
| Pi `user_bash` event (`!`/`!!` through integrations that emit it) | Replaced with a fixed refusal; command is not executed |
| Fixed build/test executables, including internal shell use | Allowed; only the controlled result reaches model context |
| Direct host `session.executeBash()`, `pi.exec()`, external shell/process APIs | **Uncovered**; must not feed their output into a protected model session |
| Host replacing the loader, injecting pre-read data or importing old transcripts | **Uncovered** |

Tests verify both refusal paths and demonstrate that raw host `executeBash()` can
still execute. This is deliberate disclosure of the SDK trust boundary, not an OS
sandbox claim. No regex scan of shell commands or arbitrary output is used as a
security boundary. Future trusted integrations must use the controlled tools or
implement and verify their own complete context boundary. Write/edit previews and
diffs remain disabled in this factory and need separate read/write policy work.
