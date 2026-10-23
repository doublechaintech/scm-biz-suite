# Marker-based context access policy

`checkContextAccess(projectRoot, targetPath)` is an independent synchronous policy
module. Phase 2 connects it to controlled file tools and automatic context loading
through the dedicated [Pi 1.4 harness](pi-context-policy.md). The normal Pi lifecycle
extension and existing read guard remain separate. No remote installation is included.

```ts
import { checkContextAccess } from "@teaql/agent-context-kit/context-access";

const decision = checkContextAccess("/absolute/project", "generated/runtime/index.ts");
// Only status === "allow" permits the caller to return content.
```

The project root must be absolute. Relative targets resolve against that root;
there is no separate working-directory option. Multiple projects require explicit
calls with their respective roots. The module checks normalized request-path and
canonical real-path ancestors, including a directory target itself. It never
inherits markers above the configured root. Outbound links and paths outside the
root return `outOfScope`, unless an in-scope request-path ancestor already excludes
the target. Missing targets, broken links, link loops and filesystem errors return
`policyError` unless an ancestor marker already determines exclusion. There is no
cross-call cache, and the module never reads target source content.

A `.agent-no-read.md` entry excludes its directory and all descendants. Empty,
oversized, invalid UTF-8 or unreadable marker bodies still exclude.
Directories and symlinks used as marker entries exclude too, with default guidance;
the parser never follows a marker symlink. Request-path and real-path markers are
compared by their canonical directory depth; the marker nearest the policy root
wins, with request-path order breaking ties. A child cannot override its parent.
Explicit marker reads return the same limited exclusion result, not an unrestricted file read.

The fixed filename is `.agent-no-read.md`. The earlier proposed extensionless
`.agent-no-read` JSON marker is no longer recognized by this module.
Marker bodies are ordinary UTF-8 Markdown project data, for example:

```markdown
# Generated runtime

This directory contains generated implementation details.

- Read docs/api/runtime.md for the public interface.
- Edit src/ and use the harness build/test tools to verify changes.
```

No JSON schema, version field, frontmatter or Markdown parsing is required. The
body itself becomes the `guidance` string, preserving headings, paragraphs, lists
and code blocks. Leading and trailing whitespace is trimmed. Links, includes,
frontmatter and commands are returned literally, without evaluation.

Bodies are read only up to 8 KiB plus one overflow detection byte. Empty,
whitespace-only, oversized and invalid UTF-8 bodies use default guidance; existence
of the marker still excludes the directory. The `reason` is a fixed harness
explanation. Combined reason and Markdown guidance text is capped at 1 KiB without
splitting Unicode code points. Paths and response framing are outside this text
budget. A long body is truncated; the marker file itself is never modified.

Results have one of four discriminants:

- `allow`: absolute `path` and canonical `realPath`.
- `excluded`: absolute `path`, `markerPath`, fixed `reason`, Markdown `guidance` string, and
  `source: "project_marker_data"` identifying the optional text's provenance.
- `outOfScope`: absolute `path`; external content is denied by default.
- `policyError`: `path` and a short generic `reason`; content must not be returned.

Marker guidance is data, never system/developer instructions. No commands,
includes or referenced documents are executed or loaded. Any later documentation
read must independently pass the policy. Consumers must preserve provenance and
handle `excluded` as a recoverable policy decision rather than a transient error.

This is context management, not an OS security sandbox. Concurrent file replacement,
hard links and duplicate content are outside v1's guarantees. A marker cannot
remove content already sent to a model. The dedicated harness covers read, search,
list, controlled automatic context loading and optional
[build/test diagnostics](controlled-tasks.md). Mutation previews/diffs and direct
host-side arbitrary Bash/process APIs remain outside the covered path. See the
harness guide for the exact supported entry points and limits.
