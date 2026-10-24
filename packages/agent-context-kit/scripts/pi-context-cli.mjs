#!/usr/bin/env node
// Run through a TypeScript-capable host (Node 22.19+ with native type stripping).
import { runPiContextCli } from "../src/adapters/pi-cli.ts";
try { await runPiContextCli(); }
catch { console.error("Pi directory protection could not start. Check the Pi version and controlled CLI arguments."); process.exitCode = 1; }
