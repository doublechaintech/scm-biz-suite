import assert from 'node:assert/strict';
import { spawnSync } from 'node:child_process';
import { existsSync, mkdtempSync, readFileSync, readdirSync, rmSync, writeFileSync } from 'node:fs';
import { tmpdir } from 'node:os';
import { join, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';
import test from 'node:test';

const root = fileURLToPath(new URL('../../', import.meta.url));
const child = join(root, 'packages/agent-context-kit');
const json = path => JSON.parse(readFileSync(path, 'utf8'));

function run(command, args, options = {}) {
  const result = spawnSync(command, args, { encoding: 'utf8', timeout: 120000, ...options });
  assert.equal(result.error, undefined, result.error?.message);
  assert.equal(result.status, 0, result.stderr + result.stdout);
  return result.stdout;
}

test('root and packaged marketplaces select the actual plugin root', () => {
  for (const base of [root, child]) {
    const expected = base === root ? child : base;
    const codex = json(join(base, '.agents/plugins/marketplace.json')).plugins[0];
    const claude = json(join(base, '.claude-plugin/marketplace.json')).plugins[0];
    assert.equal(codex.source.source, 'local');
    assert.equal(resolve(base, codex.source.path), expected);
    assert.equal(resolve(base, claude.source), expected);
    for (const host of ['codex', 'claude', 'cursor']) {
      const manifest = json(join(expected, `.${host}-plugin/plugin.json`));
      assert.equal(manifest.name, 'agent-context-kit');
      assert.equal(manifest.repository, 'https://github.com/teaql/teaql-agent-kit');
    }
    assert.ok(existsSync(join(expected, 'skills/context-lifecycle/SKILL.md')));
  }
  const manifest = json(join(child, 'package.json'));
  for (const path of [...manifest.pi.extensions, ...manifest.cline.plugins.flatMap(x => x.paths)]) {
    assert.ok(existsSync(resolve(child, path)), path);
  }
});

test('packed npm install runs marker CLI and copied hooks without TypeScript dependencies', { timeout: 120000 }, t => {
  const temporary = mkdtempSync(join(tmpdir(), 'teaql-installed-context-'));
  t.after(() => rmSync(temporary, { recursive: true, force: true }));
  // npm writes only the built artifacts in the checkout and everything else in this fixture.
  run('npm', ['pack', '--workspace', '@teaql/agent-context-kit', '--pack-destination', temporary], { cwd: root });
  const archive = readdirSync(temporary).find(name => name.endsWith('.tgz'));
  assert.ok(archive);
  writeFileSync(join(temporary, 'package.json'), '{"private":true}');
  run('npm', ['install', '--ignore-scripts', '--offline', '--no-audit', '--no-fund', join(temporary, archive)], { cwd: temporary });
  const installed = join(temporary, 'node_modules/@teaql/agent-context-kit');
  assert.equal(existsSync(join(temporary, 'node_modules/typescript')), false);
  const packed = json(join(installed, 'package.json'));
  assert.equal(packed.name, '@teaql/agent-context-kit');
  assert.equal(packed.repository.directory, 'packages/agent-context-kit');
  writeFileSync(join(temporary, 'guidance.md'), '# Generated output\nUse the public API.\n');
  writeFileSync(join(temporary, 'markers.json'), JSON.stringify({ version: 1, markers: [{ directory: 'generated', guidanceFile: 'guidance.md' }] }));
  const script = join(installed, packed.bin['agent-context-markers']);
  for (const operation of ['apply', 'check']) {
    const result = JSON.parse(run(process.execPath, [script, operation, '--manifest', 'markers.json'], { cwd: temporary }));
    assert.equal(result.status, 'ok');
  }
  writeFileSync(join(temporary, '.agent-context-kit.json'), JSON.stringify({ readGuard: { paths: ['generated/library'], message: 'Use the documented API.' } }));
  const payload = JSON.stringify({ hook_event_name: 'PreToolUse', session_id: 'install-test', cwd: temporary, tool_name: 'read_file', tool_input: { file_path: 'generated/library/model.json' } });
  const copilot = json(join(installed, 'integrations/copilot/agent-context-kit.json')).hooks.PreToolUse[0];
  const kiro = json(join(installed, 'integrations/kiro/agent-context-kit.json')).hooks;
  const crush = json(join(installed, 'integrations/crush/hooks.json')).hooks.PreToolUse[0];
  const invoke = (command, args) => spawnSync(command, args, { cwd: temporary, input: payload, encoding: 'utf8', timeout: 10000 });
  const copilotResult = invoke(copilot.exec, copilot.args);
  assert.equal(copilotResult.status, 0, copilotResult.stderr);
  assert.equal(JSON.parse(copilotResult.stdout).permissionDecision, 'deny');
  for (const hook of kiro) {
    const [command, ...args] = hook.action.command.split(' ');
    const result = invoke(command, args);
    assert.equal(result.status, 2, result.stderr);
    assert.match(result.stderr, /Use the documented API/);
  }
  const [command, ...args] = crush.command.split(' ');
  const result = invoke(command, args);
  assert.equal(result.status, 0, result.stderr);
  assert.equal(JSON.parse(result.stdout).decision, 'deny');
});


test('Pi 1.4 resolves the migrated local package to its lifecycle extension', async t => {
  const { DefaultPackageManager, SettingsManager } = await import('@earendil-works/pi-coding-agent');
  const directory = mkdtempSync(join(tmpdir(), 'teaql-pi-local-package-'));
  t.after(() => rmSync(directory, { recursive: true, force: true }));
  const manager = new DefaultPackageManager({
    cwd: directory,
    agentDir: join(directory, 'agent'),
    settingsManager: SettingsManager.inMemory(),
  });
  const result = await manager.resolveExtensionSources([child], { temporary: true });
  assert.ok(result.extensions.some(entry => entry.enabled && resolve(entry.path) === join(child, 'src/adapters/pi.ts')));
});
