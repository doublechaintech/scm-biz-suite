import { lstatSync, readFileSync, realpathSync } from "node:fs";
import { isAbsolute, join, relative, resolve, sep } from "node:path";
import { pathToFileURL } from "node:url";
import type { ToolDefinition } from "@earendil-works/pi-coding-agent";

/** Host-owned capabilities, never discovered from a project, Skill or marker. */
export async function loadPiHostTools(projectRoot: string, agentDir: string): Promise<ToolDefinition<any, any>[]> {
	const config = join(agentDir, "context-kit-host-tools.json");
	let body: string;
	try {
		const info = lstatSync(config);
		if (!info.isFile() || info.isSymbolicLink() || info.size > 65536) throw new Error("Invalid host tool configuration");
		body = readFileSync(config, "utf8");
	} catch (error) { if ((error as NodeJS.ErrnoException).code === "ENOENT") return []; throw error; }
	const plan = JSON.parse(body);
	if (plan.version !== 1 || !Array.isArray(plan.modules) || plan.modules.length > 16) throw new Error("Invalid host tool modules");
	const root = realpathSync(agentDir);
	const tools: ToolDefinition<any, any>[] = [];
	const names = new Set(["read", "grep", "find", "ls", "write", "edit", "bash", "shell", "powershell"]);
	for (const module of plan.modules) {
		if (typeof module !== "string" || !isAbsolute(module)) throw new Error("Host tool paths must be absolute");
		const path = realpathSync(module);
		const part = relative(root, path);
		if (isAbsolute(part) || part === ".." || part.startsWith(`..${sep}`)) throw new Error("Host tools must reside inside the protected agent directory");
		const loaded = await import(pathToFileURL(path).href);
		if (typeof loaded.createTools !== "function") throw new Error("Host tool module must export createTools");
		const additions = await loaded.createTools({ projectRoot: resolve(projectRoot), agentDir: root });
		if (!Array.isArray(additions) || tools.length + additions.length > 32) throw new Error("Invalid host tools");
		for (const tool of additions) {
			if (!tool || typeof tool.name !== "string" || !/^[a-z][a-z0-9_]*$/.test(tool.name) || names.has(tool.name) || typeof tool.execute !== "function" || !tool.parameters) throw new Error("Invalid or conflicting host tool");
			names.add(tool.name); tools.push(tool);
		}
	}
	return tools;
}
