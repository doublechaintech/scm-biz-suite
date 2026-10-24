# Directory protection in the ordinary Pi command

`scripts/pi-context-cli.mjs` runs native Pi **1.4.0** with the shared marker policy,
retaining the TUI, model/auth configuration and print/JSON/RPC modes. It is separate
from ordinary lifecycle installation and must be wired into the host's `pi` launcher.

```sh
node --experimental-strip-types /absolute/package/scripts/pi-context-cli.mjs
```

Use an extracted package outside `node_modules` with Node 22.19+ and a resolvable
matching Pi SDK. The server deployment links its `node_modules` to managed Pi
1.4.0 and checks that version in the shell launcher. Keep the launcher/package
host-owned. Guarded writes deny `.pi` and this installed package when in scope.
The existing lifecycle package can remain registered: native extension discovery
is disabled and lifecycle handling is loaded inline, avoiding duplicate adapters.

## Behavior

- Start with `cd project; pi`. The policy root is the startup directory. Use a fresh
  session when adopting markers; previously exposed transcript content is not erased.
  Restart Pi to change directory scope.
- `read`, `grep`, `find`, `ls` use shared policy tools; excluded subtrees are pruned
  before enumeration. Markers are checked afresh.
- `write`/`edit` retain native input schemas and permit application-source changes.
  Excluded directories/files and control files are protected. Parent directories
  must exist. Edits require unique exact non-overlapping matches applied together.
  No source previews/diffs are returned. Symlink mutations remain prohibited.
- Arbitrary Shell, user `!` commands, MCP, codemode, delegation and external tools
  are disabled. Build/generation/Assist currently run from a trusted external terminal;
  full TeaQL tool integration is separate work.
- Native context-file, Skill/template/theme and extension discovery are disabled
  before loading. Root guidance is reloaded through the checked bounded loader as
  project data before each provider request. Explicit CLI `@files`, resource paths
  and system-prompt overrides are rejected to prevent alternate-loader bypasses.
  Use guarded reads for project documents, Skills and images.
- Package/auth/configuration subcommands remain native host operations. The old
  `pi-context` command can remain available, but ordinary `pi` no longer needs it.

This controls model-context entry points, not OS access. Direct native binaries,
other processes/host APIs, races, hard links, content copies and pre-read user
messages remain outside the v1 guarantee. Do not re-enable arbitrary extensions
or Shell and continue claiming the same boundary.

## Tests

Direct `excluded`/`outOfScope` file-tool results preserve their status and include
`blocked: true`, `retryable: false`, `code: "CONTEXT_ACCESS_DENIED"` and host-authored
English feedback. A Pi `tool_result` hook sets the actual `isError` flag; returning
an `isError` property from an executor alone is not the supported Pi mechanism.
Marker guidance stays separately identified as project data and is retained on
the first denial. Later attempts within the same canonical directory (including
aliases and different tools) include `previouslyBlocked` and a scope counter, omit
repeated guidance and instruct the model to use permitted alternatives.

A bounded request-local host-policy reminder records denied scopes. It is never
an authorization cache: every tool call rechecks markers, and reminders are removed
when the host policy allows the scope. Broad searches which skip excluded subtrees
remain successful and do not count as direct retries. Returned file text cannot
create denial controls. This feedback reduces ambiguous retries but cannot guarantee
that every model will never attempt another call; all such calls remain blocked.
The task is not automatically terminated after two denials.

The integration test runs native Pi `main` in a separate process with a real local
faux provider, using the same flags and inline policy extension. It verifies denied
generated reads, pruned searches, permitted writes/edits, disabled Shell and absent
native SYSTEM/APPEND_SYSTEM context. Root `npm ci` and `npm run check` include this
test and the existing Pi/OpenCode regressions. No paid provider is required.
