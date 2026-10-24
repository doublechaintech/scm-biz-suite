# Trusted TeaQL tools for protected Pi

This optional Rust integration is separate from the generic Context Kit package.
It restores development capabilities without granting arbitrary Shell or generated
source access. Install `tools.mjs` and a `projects.json` in a host-owned directory
under the Pi agent directory, with dependencies resolving through the installed
Pi SDK. Register its absolute module path in `~/.pi/agent/context-kit-host-tools.json`:

```json
{"version":1,"modules":["/home/ai/.pi/agent/integrations/pi-teaql/tools.mjs"]}
```

Example host-owned `projects.json`:

```json
{
  "projects": [{
    "projectRoot": "/absolute/project",
    "cargoPath": "/absolute/bin/cargo",
    "contextKitPath": "/absolute/agent-context-kit/package",
    "model": "models/model.xml",
    "markerManifest": "context-markers.json",
    "outputs": ["rust-lib-core", "rust-app-console"],
    "appDirectory": "rust-app-console",
    "makePath": "/usr/bin/make"
  }]
}
```

The `teaql` tool accepts `operation=evaluate|services|assist|generate`. Assist also
accepts `action` and canonical `target` (entity or entity.field). The model path,
executable, output directories and marker manifest are fixed by the host. Every
TeaQL operation verifies cargo-teaql exactly 2.0.14 and uses `cargo teaql --input`.
No API key is requested or passed as a tool argument.

Generation requires zero-error semantic evaluation of the unchanged single-file
model in the current process, and a service inventory advertising `rust-lib-core`.
The tool runs the **rust-lib-core target** for every configured output root. With
the generated Rust layout, this refreshes `lib/` inside the existing application;
it does not run the rust-app-console workspace generator or rewrite application
`src/`/guides. Snapshot marker maintenance runs in finally even on failure. Raw
generation output and stderr do not enter model context. Multi-file models are
explicitly unsupported here until dependency-aware fingerprints are implemented.

`app_build` and `app_test` run only the configured application's `make build` and
`make test` targets through `rust-make.mjs` and the controlled task runner. Rust
error codes and source locations are returned with trusted fixed descriptions.
Permitted source excerpts are re-read from disk; excluded source, raw messages,
assertion values and test names are suppressed. Failed commands are actual Pi
tool errors. Test summaries include passed/failed/ignored counts; zero tests are
reported explicitly and do not establish business coverage.

An optional absolute `evidenceDirectory` saves bounded raw Make logs for host
review. Keep this directory under the protected agent directory and put a
`.agent-no-read.md` in it so raw logs cannot become an alternative source of
excluded implementation. Raw logs are never returned by the model tools. The
parser supports ordinary Rust Make output; this is not a complete seven-language
diagnostic integration. Executables under target/debug are not diagnostic logs.

Start a fresh ordinary `pi` session after configuring the host tools. They appear
in the tool catalog automatically for the configured project. The loader rejects
project-local modules, tool-name collisions and replacement of file/Shell tools.
The module and its config are trusted host code. They may execute project build
scripts; this remains a context boundary rather than a security sandbox.
## Recorded remote failure-recovery verification

On 2026-10-25 (Asia/Shanghai), ordinary Pi 1.4.0 in `/home/ai/t003`
used the real `local-rocm` Qwen3.6-35B-A3B model with package archive SHA-256
`88b75c97e151bd7097557a8cce2a0f8075aef363584434aa6c529187f9c5b5bf`.
It attempted each of four requested paths exactly once: a marked executable,
an unmarked 110 MiB ELF fixture, an oversized text fixture and a missing file.
All returned `isError=true` and `retryable=false`. It then called `app_build`
and `app_test`, reported the actual five E0599 locations in application-owned
`student.rs`, and exited normally after six tool calls with no repeated reads.
Compilation failed before tests could execute; this run does not establish
application test coverage. Model and application source hashes were unchanged,
and temporary input fixtures were removed. Host evidence is under
`~/.pi/agent/integrations/pi-teaql/evidence/failure-recovery-20261024T163757Z/`.
This is evidence for this observed run, not a guarantee of every model's behavior.
