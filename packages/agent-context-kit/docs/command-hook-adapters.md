# Command-hook adapters

Kimi Code, Qwen Code, GitHub Copilot CLI, Kiro CLI, and Crush expose command
hooks rather than a stable full-history transform. Their adapters share the
same deterministic `.agent-context-kit.json` read policy, but their lifecycle
capabilities differ.

Node.js 22.19 or later is required because the shipped hook runner executes
the TypeScript source directly.

## Kimi Code

Install the repository from inside Kimi Code, then reload:

```text
/plugins install https://github.com/teaql/agent-context-kit
/plugins reload
```

The root `kimi.plugin.json` contributes `UserPromptSubmit`, `SubagentStart`,
and `PreToolUse` hooks. Active blocks are added to the current request and are
also supplied when a subagent starts. Protected reads are denied with the
configured TeaQL guidance. Arbitrary earlier history cannot be replaced, so
consume-once ephemeral rewriting is not claimed.

Reference: [Kimi Code plugins](https://github.com/MoonshotAI/kimi-code/blob/main/docs/en/customization/plugins.md)
and [hooks](https://github.com/MoonshotAI/kimi-cli/blob/main/docs/en/customization/hooks.md).

## Qwen Code

Install the native extension globally:

```bash
qwen extensions install teaql/agent-context-kit
```

Or scope it to the current project:

```bash
qwen extensions install teaql/agent-context-kit --scope project
```

Restart Qwen Code or run `/reload-plugins`. The root
`qwen-extension.json` loads `hooks/qwen-hooks.json`, which handles
`UserPromptSubmit`, `SubagentStart`, and `PreToolUse`. It provides active block
context and protected-read feedback, but does not claim arbitrary history
replacement.

Reference: [Qwen Code extensions](https://qwenlm.github.io/qwen-code-docs/en/users/extension/introduction/)
and [hooks](https://qwenlm.github.io/qwen-code-docs/en/users/features/hooks/).

## GitHub Copilot CLI

Install the package in the project and copy the project hook definition:

```bash
npm install --save-dev github:teaql/agent-context-kit
mkdir -p .github/hooks
cp node_modules/@teaql/agent-context-kit/integrations/copilot/agent-context-kit.json .github/hooks/
```

The hook uses `PreToolUse` to deny protected reads. Copilot's command hook API
does not provide a stable arbitrary-history transform, so this integration is
read-guard only. Installed-plugin hooks may also package the same file, but
repository-level installation is documented here because it works in both CLI
and cloud-agent repositories.

Reference: [GitHub Copilot hooks](https://docs.github.com/en/copilot/reference/hooks-reference).

## Kiro CLI

Install the package and copy the standalone V3 hook file:

```bash
npm install --save-dev github:teaql/agent-context-kit
mkdir -p .kiro/hooks
cp node_modules/@teaql/agent-context-kit/integrations/kiro/agent-context-kit.json .kiro/hooks/
```

`UserPromptSubmit` adds active blocks to the current agent context,
`SubagentStart` supplies them to delegated agents, and `PreToolUse` blocks
protected read and shell operations. Kiro does not expose a documented
arbitrary-history rewrite hook, so consume-once behavior is not claimed.

Reference: [Kiro CLI V3 hooks](https://kiro.dev/docs/cli/v3/hooks-migration/)
and [hook actions](https://kiro.dev/docs/hooks/actions/).

## Crush

Install the package, then merge the bundled `hooks` object into the project's
`crush.json`:

```bash
npm install --save-dev github:teaql/agent-context-kit
```

The source snippet is
`node_modules/@teaql/agent-context-kit/integrations/crush/hooks.json`.
Crush currently documents only `PreToolUse`, and it does not apply that hook
inside subagents. Consequently this integration provides protected-read
enforcement for the top-level agent only; it does not provide context
lifecycle injection.

Reference: [Crush hooks](https://github.com/charmbracelet/crush/blob/main/docs/hooks/README.md).
