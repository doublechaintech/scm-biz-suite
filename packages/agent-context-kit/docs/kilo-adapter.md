# Kilo Code adapter

Kilo Code uses the same server-plugin hook contract as OpenCode. The package
exports `./server` for Kilo discovery and keeps a separate plugin identity.

## Install

Install directly from the Git repository:

```bash
kilo plugin install git:github.com/teaql/agent-context-kit
```

Alternatively, add the Git spec to the project plugin configuration described
by Kilo Code. Restart Kilo after installation.

Put trusted lifecycle declarations and discards in
`.agent-context-kit.md`. Put the read policy in `.agent-context-kit.json`.

The adapter uses `experimental.chat.messages.transform` and
`experimental.chat.system.transform` for the request-local view, and
`tool.execute.before` for protected reads. Because Kilo labels the message
transform API experimental, this adapter is full V1 but experimental until the
host stabilizes that hook.

Official reference: [Kilo Code plugins](https://kilo.ai/docs/automate/extending/plugins).
