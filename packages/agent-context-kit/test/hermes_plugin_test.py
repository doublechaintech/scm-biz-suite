import json
from pathlib import Path
import tempfile
import unittest
from unittest.mock import patch

from integrations.hermes import agent_context_kit as plugin


class FakeContext:
    def __init__(self):
        self.hooks = {}
        self.commands = {}

    def register_hook(self, name, callback):
        self.hooks[name] = callback

    def register_command(self, name, **options):
        self.commands[name] = options


class HermesPluginTest(unittest.TestCase):
    def setUp(self):
        plugin._states.clear()
        self.temp = tempfile.TemporaryDirectory()
        self.workspace = Path(self.temp.name).resolve()
        self.workspace_patch = patch.object(plugin, "_workspace", return_value=self.workspace)
        self.workspace_patch.start()

    def tearDown(self):
        self.workspace_patch.stop()
        self.temp.cleanup()

    def test_registers_documented_hermes_surfaces(self):
        context = FakeContext()
        plugin.register(context)
        self.assertEqual(
            set(context.hooks),
            {"pre_llm_call", "pre_tool_call", "on_session_finalize"},
        )
        self.assertIn("context-discard", context.commands)

    def test_injects_blocks_and_supports_trusted_session_discard(self):
        (self.workspace / plugin.SOURCE_FILE).write_text(
            "<!--BLOCK_ID:modeling-->\nUse the TeaQL workspace model.\n<!--/BLOCK_ID:modeling-->\n",
            encoding="utf-8",
        )
        injected = plugin._pre_llm_call(session_id="session-1")
        self.assertIn("Use the TeaQL workspace model.", injected["context"])

        result = plugin._discard_command("modeling", session_id="session-1")
        self.assertIn("Discarded", result)
        self.assertIsNone(plugin._pre_llm_call(session_id="session-1"))
        self.assertIsNotNone(plugin._pre_llm_call(session_id="session-2"))

        plugin._finalize_session(session_id="session-2")
        self.assertFalse(any(key[0] == "session-2" for key in plugin._states))

    def test_workspace_source_can_apply_a_trusted_discard(self):
        (self.workspace / plugin.SOURCE_FILE).write_text(
            "<!--BLOCK_ID:modeling-->\nTemporary rules.\n<!--/BLOCK_ID:modeling-->\n"
            "<!--DISCARD_BLOCK:modeling-->\n",
            encoding="utf-8",
        )
        self.assertIsNone(plugin._pre_llm_call(session_id="session-1"))

    def test_blocks_hermes_file_search_and_terminal_reads(self):
        protected = self.workspace / "generated" / "library"
        protected.mkdir(parents=True)
        (self.workspace / plugin.CONFIG_FILE).write_text(
            json.dumps(
                {
                    "readGuard": {
                        "paths": ["generated/library"],
                        "message": "TeaQL already provides the complete business context.",
                        "bashMode": "literal",
                    }
                }
            ),
            encoding="utf-8",
        )

        direct = plugin._pre_tool_call(
            "read_file", {"path": "generated/library/model.json"}
        )
        recursive = plugin._pre_tool_call("search_files", {"path": ".", "pattern": "Order"})
        terminal = plugin._pre_tool_call(
            "terminal", {"command": "cat generated/library/model.json"}
        )
        allowed = plugin._pre_tool_call("read_file", {"path": "src/index.ts"})

        self.assertEqual(direct["action"], "block")
        self.assertIn("recursively traverse", recursive["message"])
        self.assertEqual(terminal["action"], "block")
        self.assertIsNone(allowed)

    def test_invalid_guard_configuration_fails_closed_for_read_tools(self):
        (self.workspace / plugin.CONFIG_FILE).write_text(
            '{"readGuard":{"paths":[]}}', encoding="utf-8"
        )
        result = plugin._pre_tool_call("read_file", {"path": "README.md"})
        self.assertEqual(result["action"], "block")
        self.assertIn("configuration is invalid", result["message"])


if __name__ == "__main__":
    unittest.main()
