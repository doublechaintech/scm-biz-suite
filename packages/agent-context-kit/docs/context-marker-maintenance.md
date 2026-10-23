# Deterministic context-marker maintenance

Phase 4 adds a trusted maintenance entry point for `.agent-no-read.md`. A skill or
host workflow calls a script; the script creates and updates the actual marker
files. The marker body remains Markdown. A separate, explicitly selected JSON
manifest describes the output directories, durable guidance sources and optional
fixed generator. No manifest is automatically discovered or trusted by the Pi
harness.

## Manifest and durable guidance

Keep these inputs outside every output directory that generation may rebuild:

```text
project/
  context-markers.json
  docs/generated-guidance.md
  docs/runtime-api.md
  src/
  scripts/generate.mjs
  generated/                    # may be deleted and recreated
```

```json
{
  "version": 1,
  "markers": [
    { "directory": "generated", "guidanceFile": "docs/generated-guidance.md" }
  ],
  "generator": {
    "executable": "node",
    "args": ["scripts/generate.mjs"],
    "timeoutMs": 120000
  }
}
```

`docs/generated-guidance.md` might contain:

```markdown
# Generated runtime

- Read docs/runtime-api.md for the public interface.
- Edit src/ for application changes.
- Use the configured build/test tools to regenerate and verify the runtime.
```

The manifest is UTF-8 JSON, at most 64 KiB, with version 1 and 1–64 marker entries.
Each entry requires `directory` and `guidanceFile`. All manifest, directory and
source paths are project-relative and must remain in the configured project scope,
both lexically and canonically. The project root itself is not an output target:
this maintenance workflow requires durable in-project inputs outside all output
directories. The read-policy module still supports project-root markers separately.
Duplicate targets and targets containing a `.agent-no-read.md` path component are
rejected. Nested targets are supported; parent guidance still wins under the
normal context policy.

Guidance must be valid UTF-8 and fit within 8 KiB after normalization. The script
normalizes CRLF/CR to LF, trims outside whitespace and adds one final newline for
nonempty text. Empty guidance produces an empty, effective marker. Body content
is copied literally: no Markdown parsing, includes, links, frontmatter or commands
are evaluated. Keep guidance short: model-facing reason plus guidance is still
limited to 1 KiB by the [read policy](context-access.md).

## Script and exit codes

From the project root, use the installed package bin:

```sh
agent-context-markers apply --manifest context-markers.json
agent-context-markers check --manifest context-markers.json
agent-context-markers generate --manifest context-markers.json
```

In a source checkout, the equivalent script is:

```sh
node /absolute/agent-context-kit/skills/context-exclusion/scripts/markers.mjs apply --manifest context-markers.json
```

There is no working-directory option. The script uses its process cwd as project
root. It accepts only the operation and `--manifest`; extra command, path, guidance,
environment or shell overrides are rejected. `apply` and `check` do not run the
manifest's generator. There is no delete, unmark or parent-override operation.
Removing an entry from a manifest does not remove an existing marker.

| Operation | Behavior |
| --- | --- |
| `apply` | Create missing output directories and markers; atomically replace outdated marker bodies; preserve unchanged files |
| `check` | Read-only verification; report `missing`, `outdated` or `unchanged`, without creating directories |
| `generate` | Snapshot the plan, apply it, run the fixed generator, restore the same snapshot in `finally` |

Every invocation prints one JSON result with paths, statuses and optional generator
status/exit code. It never prints existing marker bodies, guidance source bodies,
generated source, raw subprocess output or stack traces. Success exits 0; a failed
check, generator or restoration exits 1; invalid invocation/configuration, unsafe
paths or runtime/maintenance exceptions exit 2. Treat every nonzero exit as a
failed workflow step.

All entries are validated before writes begin. Output-directory symlinks, symlink
ancestors below the project root, marker symlinks and special marker files are
rejected; their destinations are not modified. A symlinked project root is allowed,
but cannot be replaced with a different root while a generation call runs.
Manifest/guidance leaf symlinks are rejected too, and canonical source locations
must remain outside every output directory. These rules reduce accidental writes
outside the intended targets; they do not claim protection against malicious races.

Each marker update uses an exclusive temporary file and a same-directory atomic
rename. Temporary files are removed on ordinary failure. A batch is not a
transaction: filesystem failure after one successful write may leave some entries
updated. Repair with an authorized `apply`, then verify with `check`. Unchanged
markers retain their inode and modification time. Other generated files are not
modified by `apply` or `check`.

## Regeneration and failure handling

The generator command is fixed by trusted host configuration, not model arguments.
Only `executable`, string-array `args`, `timeoutMs` and `maxOutputBytes` are used.
It runs with full project access through the controlled process runner; raw stdout
and stderr are suppressed. The wrapper returns only its status and exit code, not
process diagnostic bodies. Default process limits are 120 seconds and 1 MiB output;
see the [controlled-task guide](controlled-tasks.md) for caps and process-tree scope.

The plan and guidance are read before launching the generator. The final restore
uses this snapshot even if the generator changes a guidance file or manifest.
After a complete output-directory deletion, restoration recreates the directory
and marker. Nonzero exits, spawn failures, timeout, output overflow and cancellation
still enter the restore path. The CLI handles SIGINT and SIGTERM as cancellation.
If generation fails, its status remains a failure even when restoration succeeds.
If restoration fails, `status: "maintenanceFailed"` takes precedence over generator
success. Do not resume model access until authorized repair/check succeeds.

SIGKILL, a host crash or power loss cannot run `finally`. Run `apply` and `check`
before resuming such a workflow. A marker inside a deleted directory is temporarily
absent during reconstruction; no script can make that marker continuously exist
while its parent is deleted. The dedicated Pi build/test tools run sequentially so
other model tool calls do not overlap generation. Hosts must also serialize external
regeneration with model access, or place a marker on a stable ancestor outside the
subtree being rebuilt. Arbitrary concurrent host processes remain outside the v1
context-policy guarantees.

## Trusted host integration

The package exports the helpers from `@teaql/agent-context-kit/context-markers`:

```ts
import {
  generateWithContextMarkers,
  maintainContextMarkers,
} from "@teaql/agent-context-kit/context-markers";

maintainContextMarkers(projectRoot, "context-markers.json", "apply");
const report = await generateWithContextMarkers(projectRoot, "context-markers.json", signal);
if (report.status !== "ok") throw new Error("Generation or marker restoration failed");
maintainContextMarkers(projectRoot, "context-markers.json", "check");
```

Only after the wrapper succeeds should a fixed build adapter load generated code
or continue compilation. The [marked build adapter](../examples/pi-context/marked-build.mjs)
shows this sequence, converting failure into the controlled `BUILD_FAILURE`
diagnostic rather than returning implementation output.

The dedicated Pi harness does **not** add a generic model maintenance tool, grant
Bash access, or trust a manifest merely because a skill mentions it. The host chooses
the manifest and embeds the wrapper in its fixed build task. Other skill hosts may
invoke the CLI through an already authorized script operation. Marker/configuration
writes remain controlled operations, not a relaxation of ordinary model read/write
policy. See the [context-exclusion skill](../skills/context-exclusion/SKILL.md).

## Runnable end-to-end example

In this repository:

```sh
npm run example:context-markers
```

The demo copies [the example project](../examples/pi-context/generated-runtime/)
into a temporary directory, then:

1. Runs the fixed generator twice, deleting and recreating `generated/` on each run.
2. Confirms `.agent-no-read.md` is restored and current after rebuilding.
3. Verifies read exclusion and search pruning while public docs and src/ remain readable.
4. Runs a fixed build adapter and Node tests that internally use the generated runtime.
5. Prints only maintenance reports, policy decisions and controlled build/test results,
   then removes the temporary project.

The Pi integration test uses the same project and fixed adapters with Pi 1.4's local
faux provider. It executes build → test → rebuild → read/search and checks actual
provider requests and stored tool results for source leakage. No model credentials,
network or AMD machine are needed. Performance/context-volume comparisons on a
real generated library/runtime project remain phase 5.

## Packaging

`npm run build:marker-cli` compiles the four built-in-only CLI modules to
`dist/marker-cli/` and creates a marker there directing readers to src/ and docs/.
`npm pack` runs this build automatically through `prepack`; the compiled runtime,
executable CLI, skill, sources and examples are included in the package.

A source checkout loads current TypeScript sources. Inside `node_modules`, the CLI
and marked-build example load compiled JavaScript, avoiding Node's restriction on
native TypeScript stripping in installed packages. The installed maintenance CLI
needs no Pi, TypeScript compiler or third-party runtime dependencies. Keep the
package layout intact; copying only the skill folder omits its runtime. A missing
installed runtime fails with a fixed `runtimeUnavailable` result instead of falling
back to reading/executing arbitrary project files.
