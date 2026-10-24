# Unified file policy

`@teaql/agent-context-kit/file-policy` exports `FileAccessPolicy`. Its trusted host
configuration accepts an absolute `projectRoot`, `writeRoots`, and `readOnlyPaths`.
Arrays are copied at construction. No write roots means all agent writes are denied.

```ts
import { FileAccessPolicy } from "@teaql/agent-context-kit/file-policy";
const policy = new FileAccessPolicy({
  projectRoot: "/absolute/project",
  writeRoots: ["models", "app/src"],
  readOnlyPaths: ["generated", "policy/context-markers.json"],
});
policy.checkRead("generated/library.ts");
policy.checkMutation("move", "app/src/old.ts", "app/src/new.ts");
```

Only `status: "allow"` grants permission. Read checks delegate to the existing
marker policy, including request/real-path ancestors and bounded untrusted marker
guidance. **Read and write permissions are independent**: `.agent-no-read.md`
does not itself prohibit deletion or creation. Declare generated libraries in
`readOnlyPaths` to prohibit all agent mutations, independently of read exclusion.

Mutation checks support create, overwrite, exact edit, delete and move. Moves
validate both endpoints before effects and require nonexistent destinations.
Moving, editing or overwriting existing content requires read permission, preventing
relocation of excluded content into readable paths. All mutation targets must be
inside an approved write root and outside read-only paths. Prefix siblings do not
match; path escapes fail closed. Symlink mutation paths, including ancestor and
dangling links, are rejected. Parent directories must already exist. Directory
mutation/recursive deletion is unsupported, so protected descendants cannot be
removed by deleting or moving a parent directory.

Standard control files/directories cannot be mutated even with `writeRoots: ["."]`:
`.git`, `.pi`, `.opencode`, `.agents`, `.codex`, `.claude`, project instruction files,
lifecycle configuration, markers and `context-markers.json`. Custom host policy
files must be listed in `readOnlyPaths`. The OpenCode factory protects its configured
`lifecycleFile` automatically. `.agent-no-write.md` is reserved against agent
mutation only; no write-marker behavior is introduced.

`@teaql/agent-context-kit/workspace-files` exports `WorkspaceFiles`, owning the
checked filesystem effects and exposing guarded `ContextFiles` as `context`.
It supports bounded UTF-8 create/overwrite, single exact-match edit, ordinary-file
delete and no-clobber move. Overwrite/edit stage a file in the same directory,
recheck policy before rename and preserve permission bits. Responses contain status
only, never source, previews or diffs. Failed preconditions leave originals intact.
Moves use link/unlink; cross-filesystem moves fail.

This is agent-tool/context policy, not an OS sandbox. Concurrent filesystem
replacement, hard-link aliases, other processes, privileged host tools and copies
of protected content elsewhere are outside its guarantees. Create/move IO failures
can leave partial effects: `policyError` does not promise transaction rollback.
Trusted build/generation tools do not grant file-tool permission to the agent.
