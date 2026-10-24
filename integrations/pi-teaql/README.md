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
`make test` targets, through the controlled task runner. Raw compiler/test stdout
and stderr are suppressed. Without a diagnostic adapter these tools report exit
status rather than detailed Rust compiler diagnostics. This does not claim a
complete language-native diagnostic or seven-language workflow integration.

Start a fresh ordinary `pi` session after configuring the host tools. They appear
in the tool catalog automatically for the configured project. The loader rejects
project-local modules, tool-name collisions and replacement of file/Shell tools.
The module and its config are trusted host code. They may execute project build
scripts; this remains a context boundary rather than a security sandbox.
