# Read guard

The read guard prevents an agent from spending time and tokens scanning files
whose useful business meaning is already present in trusted workspace context.
It is separate from the lifecycle protocol: the lifecycle controls what enters
the model request, while the read guard controls which tool requests are
allowed to fetch more context.

## Configure

Copy the example to the project root and adapt the paths and message:

```bash
cp examples/read-guard/agent-context-kit.json .agent-context-kit.json
```

```json
{
  "readGuard": {
    "workspaceRoot": ".",
    "paths": ["generated/library"],
    "message": "This is a generated library. TeaQL workspace context already provides the complete business model; use that context instead.",
    "bashMode": "literal"
  }
}
```

Relative protected paths are resolved from `workspaceRoot`, which itself is
resolved from the agent's starting directory. Pi, OpenCode, Kilo Code, Cline,
MiMo Code, Hermes Agent, Kimi Code, Qwen Code, GitHub Copilot CLI, Kiro CLI,
and Crush load this workspace file through their adapter or command hook. On a
blocked call, each adapter returns the configured message to the model; Pi also records an
`agent-context-kit-read-guard-v1` custom audit entry.

The Pi extension also supports a policy stored elsewhere through an explicit
path:

```bash
export AGENT_CONTEXT_KIT_CONFIG=/etc/teaql/agent-context-kit.json
pi
```

An explicitly configured file that is missing or invalid fails extension
startup instead of silently disabling the guard. For an enforced environment,
keep the file outside the agent-writable workspace or bake it into the runtime
image.

## Covered tools

| Tool | Behavior |
| --- | --- |
| `read` | Blocks a file or directory inside a protected path |
| `ls` | Blocks listing a protected path |
| `grep` | Blocks a protected target and any directory search that would traverse a protected subtree |
| `find` | Blocks a protected target and any search root that would traverse a protected subtree |
| `bash` | Controlled by `bashMode` |

The cross-host matcher also recognizes common aliases such as `read_file`,
`read_files`, `read_many_files`, `fs_read`, `view`, `list_directory`, `glob`,
`search_files`, `grep_search`, `rg`, `shell`, `execute_bash`, `run_commands`,
`run_shell_command`, `powershell`, `terminal`, and `exec_command`. It accepts
single-path fields plus `paths`, `files`, and `file_paths` arrays.

Existing paths are resolved through symlinks before matching. Recursive
workspace-wide `grep` and `find` calls are blocked when they would cross a
protected subtree; the feedback tells the model to use a narrower allowed
scope.

`bashMode` has three values:

- `literal` (default) blocks shell commands that explicitly contain a
  protected absolute or relative path;
- `block` blocks every model-issued shell command while the read guard is
  active; and
- `allow` does not inspect shell commands.

Shell syntax, variables, aliases, subprocesses, and custom tools make literal
inspection unsuitable as a security boundary. Use `block` when Pi must not
have shell access, or combine the guard with an operating-system sandbox.

## OpenShell enforcement

Use the Pi guard to give the model the TeaQL-specific explanation and use an
[OpenShell filesystem policy](https://docs.nvidia.com/openshell/latest/how-it-works/policies/schema)
as the non-bypassable boundary.

OpenShell's filesystem policy is an allowlist: paths absent from `read_only`
and `read_write` are inaccessible. To exclude a generated subtree, do not grant
its parent as a broad readable or writable root. In particular,
`include_workdir: true` grants the complete working directory and cannot then
be reduced with a child deny rule. Arrange or mount the workspace so allowed
source roots can be listed separately:

```yaml
version: 1

filesystem_policy:
  include_workdir: false
  read_only:
    - /usr
    - /lib
    - /etc
    - /workspace/src
    - /workspace/docs
    - /workspace/package.json
    - /etc/teaql/agent-context-kit.json
  read_write:
    - /tmp
    - /dev/null
    - /workspace/output

landlock:
  compatibility: hard_requirement
```

The generated library is deliberately absent. Adapt the allowed roots to the
actual project layout and pass the policy when creating the sandbox. Bake the
same feedback configuration into the Pi image:

```dockerfile
COPY agent-context-kit.json /etc/teaql/agent-context-kit.json
ENV AGENT_CONTEXT_KIT_CONFIG=/etc/teaql/agent-context-kit.json
```

```bash
openshell sandbox create \
  --name teaql-pi \
  --from pi-agent:local \
  --policy ./pi-policy.yaml \
  --provider openrouter \
  -- pi
```

Filesystem fields are fixed when the sandbox starts, so changing protected
paths requires recreating the sandbox. Use `hard_requirement` when starting
without Landlock enforcement would violate the intended boundary.

## Boundary

The adapters are deterministic for the recognized tool names listed above and
provide the model-facing redirect. They do not claim to mediate arbitrary
extension tools, MCP servers, language servers, or processes launched outside
the host. The OpenShell allowlist (or another OS-level sandbox) is the
authority for those paths.
