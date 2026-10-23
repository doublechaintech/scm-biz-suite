import { GeminiCliLifecycleAdapter } from "./gemini-cli.ts";
import type { GeminiBeforeModelInput } from "./gemini-cli.ts";

async function readStdin(): Promise<string> {
	const chunks: Buffer[] = [];
	for await (const chunk of process.stdin) chunks.push(Buffer.from(chunk));
	return Buffer.concat(chunks).toString("utf8");
}

try {
	const input = JSON.parse(await readStdin()) as GeminiBeforeModelInput;
	const output = new GeminiCliLifecycleAdapter().handleBeforeModel(input);
	process.stdout.write(JSON.stringify(output));
} catch (error) {
	process.stderr.write(`agent-context-kit: ${error instanceof Error ? error.message : String(error)}\n`);
	process.exitCode = 1;
}
