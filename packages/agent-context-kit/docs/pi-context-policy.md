# Dedicated Pi context exclusion harness

This SDK entry point targets Pi **1.4+**, tested against exactly **1.4.0**. It adds
`.agent-no-read.md` enforcement to read/grep/find/ls, automatic project context,
and optional controlled build/test diagnostics.
It is separate from the ordinary lifecycle extension at `@teaql/agent-context-kit/pi`.
Installing that extension alone does not enable this harness. No AMD deployment is
part of this implementation.

## Start a session

```ts
import { createContextPolicyPiSession } from "@teaql/agent-context-kit/pi-context";

const { session } = await createContextPolicyPiSession({
  projectRoot: "/absolute/path/to/project",
  agentDir: "/absolute/path/to/pi/agent",
  // Optional additional project notes, text attachments or indexes:
  contextPaths: ["docs/api/runtime.md"],
  // Optional: model, modelRuntime, thinkingLevel (Pi SDK values).
});

try {
  await session.prompt("Inspect the project and explain the runtime interface.");
} finally {
  session.dispose();
}
```

Use an installed `@earendil-works/pi-coding-agent` 1.4+ runtime. Repository development
pins both Pi coding-agent and pi-ai to 1.4.0. The factory uses the project root as
its working directory and every relative context/tool path resolves against that
root. It exposes guarded `read`, `grep`, `find` and `ls`, plus optional fixed
`build`/`test` tools configured by trusted host code. See the
[controlled-task guide](controlled-tasks.md) for command setup, adapter examples
and the exact diagnostic protocol. The factory does not enable arbitrary Bash,
edit, write, MCP or codemode tools.

Create `.agent-no-read.md` in a generated directory using the
[marker format](context-access.md). A denial returns a normal text tool result
containing structured `status: "excluded"`, marker provenance and limited Markdown
guidance. The result is recoverable and should not be retried as a transient failure.

## File tools

The implementations share `ContextFiles` and `checkContextAccess`. No cross-call
allow, source-body or search-result caches are used.

- **read** checks the request path, checks again in native read operations, and
  checks before returning the result. Pi's line ranges, pagination, image handling
  and normal output limits are retained. Ordinary file reads have a 10 MiB input
  cap. Explicit marker reads return limited guidance rather than unrestricted text.
- **grep/find** use controlled local traversal. Every directory is checked before
  `readdir`; excluded subtrees are never enumerated or searched. Allowed file
  contents are checked immediately before reading. Symlink targets are checked,
  and directory cycles are deduplicated. No full-tree rg/fd command is run.
- **ls** returns the excluded directory entry with exclusion status and guidance;
  it never expands that entry. Explicit listing inside it returns a denial.

Search output includes at most five unique skipped-marker summaries, deduplicated
by canonical marker directory. It never returns excluded descendant names, match
counts or source excerpts. Files are checked again before search results are
returned. Explicit out-of-scope paths are denied rather than treated as unmarked.

Search intentionally includes hidden and ignored files in traversal; `.gitignore`
is not a policy control. Filename glob semantics use Node's `path.matchesGlob`:
wildcards do not implicitly match leading dots, so name dotfiles explicitly (for
example `.hidden` or `**/.hidden`). A pattern without `/` also matches basenames.
Grep without a filename glob searches hidden files too. Parameters such as shell
flags, `--no-ignore` or hidden-file switches cannot disable policy checks.

Grep uses JavaScript regular expressions (or `literal: true`), with `ignoreCase`
and up to 10 lines of context on each side. It skips NUL-containing binary files;
files above 2 MiB or unreadable files produce a bounded `policyError` skip summary.
The default result limit is 100 and the hard cap is 1000. Grep text excerpts have a
combined 32K character budget and 500 characters per line. These are context-volume
limits, not a claim that arbitrary process output can be filtered reliably.

## Automatic context before each model request

Pi's default context-file, skill, prompt-template, theme and extension discovery is
disabled **before** resource loading. SYSTEM.md and APPEND_SYSTEM.md discovery is
also suppressed. The loader uses in-memory settings instead of project/global
settings that could re-enable resources. No ancestor or global AGENTS files are
automatically included.

A trusted harness extension uses Pi 1.4's `context_with_system` event to build
fresh context at every model request, including follow-up calls after tools. It
loads the first existing project-root file from Pi's usual priority list:
`AGENTS.override.md`, `AGENTS.md`, `AGENTS.MD`, `CLAUDE.md`, `CLAUDE.MD`. Additional
notes, indexes and text attachments can be explicitly listed in `contextPaths`.
All are checked before file contents are read. Native `/skill:name` and prompt
expansion have no discovered files to read. To use skill text as project context,
list the permitted file explicitly; it remains project data.

At most 32 candidate files are considered, with 32 KiB per file and 64 KiB combined
input limits. Unsupported, oversized or invalid UTF-8 sources are omitted with a
bounded status summary. Context file bodies are sent as a request-local hidden
custom message with `source: "project_file_data"`, not promoted to system/developer
instructions and not persisted in the transcript. Marker guidance retains its own
`source: "project_marker_data"`. Links and commands are never followed or executed.
Automatic binary attachments are not discovered; images use the guarded read tool.

New markers affect the next tool call and next automatic context load. Previously
sent ordinary tool results or user messages can still remain in conversation
history; this implementation does not claim to erase historical exposure. Begin a
fresh session when adopting the policy for an existing conversation.

## Scope and remaining work

`createContextPolicyTools` and `loadContextPolicyFiles` are available separately for
trusted hosts, but installing only the tool replacements does not control automatic
loading. The complete session factory is the supported path for guarded model access.

This is context management, not an OS sandbox. Host code with the returned raw Pi
session can still call process APIs, submit pre-read text/images, enable unguarded
tools, import old transcripts or replace the loader. Those host entry points are
outside the covered path and must not be presented as protected. Arbitrary Bash is
not a model tool in this factory, and Pi `user_bash` events are refused. Direct
host-side Bash/process APIs remain uncovered; see the explicit
[Bash coverage table](controlled-tasks.md#bash-coverage). Fixed build/test tools
use a closed diagnostic protocol, suppress raw output and recreate optional
source excerpts from allowed files only. Mutation previews/diffs remain disabled
and need separate policy work. [Deterministic marker maintenance](context-marker-maintenance.md)
provides phase-4 scripts, a skill and a regeneration wrapper. Concurrent malicious filesystem replacement, hard links and copies
remain outside the v1 guarantees.

## Verification

`npm run check` runs policy, filesystem and real Pi 1.4 runtime tests. Tests inspect
provider-visible messages, verify excluded directories are never passed to
`readdir`, verify excluded source files are never opened, cover image and paginated
reads, and add markers while the session is running. Controlled-task tests run
real TypeScript builds and Node tests against excluded files and check the
provider boundary, fixed arguments, timeouts, cancellation and Bash coverage. Marker
lifecycle tests rebuild the entire output directory twice and verify restoration
before the next model request. The model provider is Pi's
local deterministic faux provider; no model credentials or network are required.
