import type { OpenCodeAdapterOptions } from "./opencode.ts";
import { createOpenCodePlugin } from "./opencode.ts";

/** Kilo Code uses the same server-plugin hooks as OpenCode. */
export function createKiloCodePlugin(options: OpenCodeAdapterOptions = {}) {
	const plugin = createOpenCodePlugin(options);
	return { ...plugin, id: "teaql.agent-context-kit.kilo" };
}

export const kiloCodePlugin = createKiloCodePlugin();
export default kiloCodePlugin;
