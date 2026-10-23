# Gemini CLI adapter

Gemini CLI runs `hooks/hooks.json` at `BeforeModel`. The adapter rewrites the
stable text-message view, persists lifecycle state next to the CLI transcript,
and returns a request override without changing the transcript.

Install or link this repository as an extension, then restart Gemini CLI:

```bash
gemini extensions link /absolute/path/to/agent-context-kit
```

Gemini CLI system messages are trusted block-definition and discard sources.
User and model messages are not trusted controls. Put declarations in a
`GEMINI.md` file that Gemini CLI loads into system context.

The stable hook contract explicitly filters non-text parts. Named blocks and
text-message ephemerals are supported; an ephemeral marker contained only in a
non-text tool payload cannot be observed or removed by this adapter. See the
official [hook reference](https://github.com/google-gemini/gemini-cli/blob/main/docs/hooks/reference.md)
and [extension reference](https://github.com/google-gemini/gemini-cli/blob/main/docs/extensions/reference.md).

The hook uses Node.js type stripping and therefore retains this package's
Node.js 22.19+ requirement.
