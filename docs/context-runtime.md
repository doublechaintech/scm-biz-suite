# Context runtime workspace

This repository contains TeaQL workflow Skills and an independent generic runtime.
The workspace root is private; the runtime package retains its existing identity.

| Path | Responsibility |
| --- | --- |
| `skills/build-teaql-app/` | TeaQL model/evaluate/generate/Assist/application workflow |
| `tools/teaql_workspace.py` | Existing seven-language runtime-source verification |
| `packages/agent-context-kit/` | Generic lifecycle, exclusion policy, host adapters, controlled diagnostics and marker maintenance |
| `tests/context-runtime/` | Cross-boundary contracts using the actual TeaQL Skill |

## Develop

Node.js 22.19+ and Python 3 are needed for the full development check. Pi development
dependencies are pinned to 1.4.0 in the child package. These do not become
requirements for users who only install the ordinary TeaQL Skill.

```sh
npm ci
npm run check
npm run example:context-markers
```

`npm run check` runs the package typecheck and Node tests, the root Skill/parser
contract, Python runtime-source tests, and Python Hermes adapter tests. No TeaQL
network service, remote model credentials or AMD deployment is involved. The root
`package-lock.json` is authoritative; the imported child lockfile was consolidated
into it without changing the imported dependency versions.

For focused work:

```sh
npm run check:context
npm run test:contracts
npm run test:python
```

## Install and publish the child package

The package remains `@teaql/agent-context-kit` at version 0.5.0 with its existing
public exports, CLI name, package-local host manifests, examples and tests. This
working-tree import is unreleased; no npm version or remote installation has been
changed by the migration.

To create the child tarball from the workspace root:

```sh
npm pack --workspace @teaql/agent-context-kit
```

The child prepack builds its dependency-free JavaScript marker CLI runtime. The
root workspace is private and is not the publishable package. Publish explicitly
from the child package only when a release is authorized; this migration performs
no publish operation.

For a local Pi extension installation, point Pi at the absolute child directory:

```sh
pi install /absolute/path/to/teaql-agent-kit/packages/agent-context-kit
```

This enables the ordinary lifecycle adapter. The dedicated read-policy harness is
a separate SDK entry point; see the child
[Pi context-policy guide](../packages/agent-context-kit/docs/pi-context-policy.md).
Other host manifests are also rooted in the child directory. Do not substitute the
repository root for their package root. Legacy Git installation URLs in imported
plugin catalogs and guides continue to point to the original repository; changing
those remote installation routes needs host-specific subdirectory validation and
is not silently claimed complete here. Existing npm exports keep their names.

The existing Skill command remains:

```sh
npx skills add teaql/teaql-agent-kit --skill build-teaql-app
```

The generic package Skills remain with their package runtime. Do not copy only the
context-exclusion Skill folder and lose its relative runtime imports. Use the
packaged marker CLI or a trusted fixed build wrapper; see
[marker maintenance](../packages/agent-context-kit/docs/context-marker-maintenance.md).

## Licensing and import provenance

The repository root keeps its existing MIT license. The complete imported package
keeps its Apache-2.0 LICENSE and all bundled asset license files. The workspace
does not relabel those files under the root license.

The import includes 121 source working-tree files from `teaql/agent-context-kit`,
including the uncommitted phase-1–4 implementation. Source HEAD at import was
`1ad889a2b986bee7250e5373fd12c9912046a87a`. The original source checkout remains unchanged; its Git history has
not been rewritten or imported into this repository. The source child lockfile is
represented by the root workspace lock. Package metadata gains the destination
repository/directory and a Python test script. Other copied file bytes are
preserved. Root changes are localized to workspace configuration/documentation
and four lifecycle-comment spellings in the TeaQL Skill.

## Integration boundary and next steps

The Skill phase comments now match the strict V1 grammar, enforced by a root
contract test. This does not automatically load the Skill into a protected harness,
recognize phase-complete text as a trusted event, or activate lifecycle discard.

The generic policy session still has only guarded read/search/list plus optional
fixed build/test commands. It disables automatic Skill loading and ordinary shell
and mutation tools. The full TeaQL workflow still needs a separately reviewed
integration layer for:

- policy-checked business-source/KSML editing;
- trusted evaluate, generate and progressive Assist tools;
- lifecycle/policy composition and trusted stage transitions;
- explicit handling of the authorized 80-line source-fallback policy;
- language-native diagnostic adapters beyond the current TypeScript/Node examples.

Generated-library markers must not exclude the editable application workspace or
its required project guide. Full workflow enforcement and context/token savings on
a real generated TeaQL project remain separate verification work. No complete
TeaQL harness or remote deployment is claimed by moving the package here.
