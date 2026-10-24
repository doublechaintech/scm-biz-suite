# Ordinary Pi: t003 business compilation repair

On 2026-10-25 (Asia/Shanghai), a fresh ordinary Pi 1.4.0 session in
`/home/ai/t003` used the real `local-rocm` Qwen3.6-35B-A3B model to repair the
existing application. This was the actual project, not a standalone fixture.

## Outcome

The successful run started at 2026-10-24 17:18:30 UTC and finished at
17:20:24 UTC, exiting 0. One user prompt produced 27 tool calls, including
10 TeaQL calls, two builds, one edit and one test invocation. No manual
continuation prompt or manual business-code repair occurred during this run.

- Saved model: `/home/ai/t003/models/school-service.xml`, unchanged.
- Evaluation: 0 errors, 16 warnings, 4 suggestions.
- Current query, create/update and required field Assist were obtained through
  the registered TeaQL tool; it checks cargo-teaql 2.0.14 before each operation.
- Initial compilation: five E0599 errors on `PurposedQuery<T>`.
- Source repair: only `rust-app-console/src/student.rs` changed. Pi moved
  `purpose(...)` after conditional filters, ordering and the bounded limit.
  The existing `Q::students()` projection, filters, comment, purpose text and
  audited saves were preserved. The final diff removes two lines and adds two.
- Final `app_build`: passed, exit 0 (`cargo check && cargo build`).
- `app_test`: passed, exit 0 (`cargo test`), **0 passed, 0 failed, 0 skipped**.
  No test cases executed; this is not evidence of business-test coverage.
- Model, Cargo.toml, Makefile and all other snapshotted application source were
  unchanged. The successful run made no generation calls or generated-source
  read attempts. It did not run the application against a database.
- Token usage was not reported by the provider; context savings were not measured.

## Why the first attempt failed

The preceding run received only a generic "method unavailable" description
for E0599. It incorrectly changed the query entry point and regenerated the
library, then stopped with the same errors. The completion guard did run the
missing test command, but could not correct that reasoning error by itself.

The compiler's actual receiver type was `PurposedQuery<T>`: the code had
entered the executable stage before adding filters. The Rust diagnostic
adapter now recognizes this exact E0599 receiver shape and emits the fixed
`E0599_PURPOSED_QUERY` description. It explains the stage ordering and preserves
the original query entry point, without forwarding arbitrary compiler text or
excluded source. Other receiver types retain the ordinary E0599 classification.

The mistaken entry-point edit was rolled back only after checking that the
file exactly matched that single mistaken change. The successful run then
started from the original application source with the same task prompt.
Both attempts are retained as evidence; the first is not counted as success.

The updated diagnostic regression and the complete repository checks passed:
113 package unit tests, 20 integration tests, 8 root contract tests and 7 Python
tests, **148 total**.

## Evidence and deployment

Host evidence:

```text
~/.pi/agent/integrations/pi-teaql/evidence/
  t003-business-repair-20261024T171357Z/                   # failed attempt
  t003-business-repair-typed-diagnostic-20261024T171830Z/  # successful run
```

The successful directory contains `events.jsonl`, `summary.json`,
`student.diff`, before/after application source, UTC timestamps and exit status.
Raw compiler logs remain in the host-owned, excluded diagnostics directory.

The generic Context Kit package remains release `2f4e7ed0cb14a022`.
The independently deployed TeaQL `rust-make.mjs` adapter has SHA-256:

```text
29497886a2d6bde8f2602223ca40c5259f670d0c2cd3cfcb4f6cda012e724b54
```

New ordinary `pi` sessions load the new diagnostic descriptions. Existing
sessions must restart once to refresh their imported host-tool modules.
Future tasks can start with `cd ~/t003 && pi` and request a localized business
change; completion checks use the actual build and test results.
