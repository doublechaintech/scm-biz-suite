// Use as node --test --test-reporter=/absolute/path/to/node-test-jsonl.mjs ...
// Test names, assertions, stack traces and test stdout/stderr are deliberately not forwarded.
export default async function* reporter(events) {
  let counts;
  for await (const event of events) {
    if (event.type === "test:summary") counts = event.data.counts;
    if (event.type !== "test:fail") continue;
    const data = event.data;
    yield JSON.stringify({
      version: 1, type: "diagnostic", code: "TEST_FAILURE", severity: "error",
      ...(typeof data.file === "string" ? { path: data.file } : {}),
      ...(Number.isSafeInteger(data.line) && data.line > 0 ? { line: data.line } : {}),
      ...(Number.isSafeInteger(data.column) && data.column > 0 ? { column: data.column } : {}),
    }) + "\n";
  }
  if (counts) {
    yield JSON.stringify({
      version: 1, type: "testSummary",
      passed: counts.passed, failed: counts.failed, skipped: counts.skipped,
    }) + "\n";
  }
}
