"""Hermes Agent bridge for the agent-context-kit V1 protocol.

The plugin uses only documented Hermes plugin surfaces: ``pre_llm_call`` for
request-local context injection, ``pre_tool_call`` for protected-read policy,
and an in-session slash command for trusted block discard.
"""

from __future__ import annotations

from dataclasses import dataclass, field
import hashlib
import json
import os
from pathlib import Path
import re
from threading import RLock
from typing import Any


SOURCE_FILE = ".agent-context-kit.md"
CONFIG_FILE = ".agent-context-kit.json"
BLOCK_START = re.compile(r"<!--BLOCK_ID:([a-z0-9_-]+)-->")
BLOCK_END = re.compile(r"<!--/BLOCK_ID:([a-z0-9_-]+)-->")
DISCARD = re.compile(r"<!--DISCARD_BLOCK:([a-z0-9_-]+)-->")
BLOCK_ID = re.compile(r"[a-z0-9_-]+")
SHELL_BOUNDARY = r"\s\"'=;:(){}\[\],|&"


@dataclass(frozen=True)
class Block:
    block_id: str
    content: str
    source: str


@dataclass
class SessionState:
    blocks: dict[str, Block] = field(default_factory=dict)
    discarded: set[str] = field(default_factory=set)
    loaded_documents: set[str] = field(default_factory=set)


@dataclass(frozen=True)
class GuardConfig:
    workspace_root: Path
    protected: tuple[tuple[str, Path], ...]
    message: str
    bash_mode: str


_states: dict[tuple[str, str], SessionState] = {}
_lock = RLock()


def _workspace() -> Path:
    """Resolve the session workspace without confusing it with gateway cwd."""
    try:
        from agent.runtime_cwd import resolve_agent_cwd

        return Path(resolve_agent_cwd()).resolve(strict=False)
    except (ImportError, OSError, RuntimeError, TypeError, ValueError):
        return Path.cwd().resolve(strict=False)


def _state(session_id: str, workspace: Path) -> SessionState:
    key = (session_id or "default", str(workspace))
    return _states.setdefault(key, SessionState())


def _parse_source(markdown: str, source: str) -> tuple[list[Block], list[str]]:
    """Parse valid, non-nested V1 blocks and discard directives strictly."""
    lines = markdown.splitlines(keepends=True)
    counts: dict[str, int] = {}
    for line in lines:
        match = BLOCK_START.fullmatch(line.rstrip("\r\n"))
        if match:
            block_id = match.group(1)
            counts[block_id] = counts.get(block_id, 0) + 1

    blocks: list[Block] = []
    discards: list[str] = []
    open_id: str | None = None
    open_content: list[str] = []
    invalid = False

    for line in lines:
        text = line.rstrip("\r\n")
        start = BLOCK_START.fullmatch(text)
        end = BLOCK_END.fullmatch(text)
        discard = DISCARD.fullmatch(text)

        if start:
            if open_id is not None:
                invalid = True
                continue
            open_id = start.group(1)
            open_content = []
            invalid = counts.get(open_id, 0) > 1
            continue

        if end:
            if open_id is None:
                continue
            if end.group(1) != open_id:
                invalid = True
                continue
            if not invalid:
                blocks.append(Block(open_id, "".join(open_content), source))
            open_id = None
            open_content = []
            invalid = False
            continue

        if discard:
            discards.append(discard.group(1))

        if open_id is not None:
            open_content.append(line)

    return blocks, discards


def _load_source(state: SessionState, workspace: Path) -> None:
    source_path = workspace / SOURCE_FILE
    try:
        markdown = source_path.read_text(encoding="utf-8")
    except FileNotFoundError:
        return

    version = hashlib.sha256(markdown.encode("utf-8")).hexdigest()
    document_key = f"{source_path}:{version}"
    if document_key in state.loaded_documents:
        return

    blocks, discards = _parse_source(markdown, f"workspace:{source_path}")
    for block in blocks:
        existing = state.blocks.get(block.block_id)
        if existing is None:
            state.blocks[block.block_id] = block
        elif existing.source != block.source or existing.content != block.content:
            # Match V1 conflict behavior: keep the first trusted definition.
            continue
    for block_id in discards:
        if block_id in state.blocks:
            state.discarded.add(block_id)
    state.loaded_documents.add(document_key)


def _render_blocks(state: SessionState) -> str:
    rendered = []
    for block in state.blocks.values():
        if block.block_id in state.discarded:
            continue
        content = block.content if block.content.endswith("\n") else f"{block.content}\n"
        rendered.append(
            f"<!--BLOCK_ID:{block.block_id}-->\n"
            f"{content}"
            f"<!--/BLOCK_ID:{block.block_id}-->"
        )
    if not rendered:
        return ""
    return (
        "<agent_context_lifecycle_blocks>\n"
        + "\n\n".join(rendered)
        + "\n</agent_context_lifecycle_blocks>"
    )


def _pre_llm_call(session_id: str = "", **kwargs: Any) -> dict[str, str] | None:
    del kwargs
    workspace = _workspace()
    with _lock:
        state = _state(session_id, workspace)
        _load_source(state, workspace)
        context = _render_blocks(state)
    return {"context": context} if context else None


def _discard_command(raw_args: str, *, session_id: str = "", **kwargs: Any) -> str:
    del kwargs
    block_id = raw_args.strip()
    if not BLOCK_ID.fullmatch(block_id):
        return "Usage: /context-discard <block_id>"
    if not session_id:
        return "Cannot discard context before Hermes has created a session."

    workspace = _workspace()
    with _lock:
        state = _state(session_id, workspace)
        _load_source(state, workspace)
        if block_id not in state.blocks:
            return f'Unknown context block "{block_id}".'
        if block_id in state.discarded:
            return f'Context block "{block_id}" was already discarded.'
        state.discarded.add(block_id)
    return f'Discarded context block "{block_id}" for this Hermes session.'


def _finalize_session(session_id: str | None = None, **kwargs: Any) -> None:
    del kwargs
    if not session_id:
        return
    with _lock:
        for key in [key for key in _states if key[0] == session_id]:
            _states.pop(key, None)


def _is_inside(parent: Path, candidate: Path) -> bool:
    try:
        candidate.relative_to(parent)
        return True
    except ValueError:
        return False


def _load_guard(workspace: Path) -> GuardConfig | None:
    config_path = workspace / CONFIG_FILE
    try:
        raw = json.loads(config_path.read_text(encoding="utf-8"))
    except FileNotFoundError:
        return None
    except (OSError, UnicodeError, json.JSONDecodeError) as error:
        raise ValueError(f"invalid {config_path}: {error}") from error

    guard = raw.get("readGuard") if isinstance(raw, dict) else None
    if not isinstance(guard, dict):
        if isinstance(raw, dict) and "readGuard" not in raw:
            return None
        raise ValueError(f"{config_path}:readGuard must be an object")

    paths = guard.get("paths")
    message = guard.get("message")
    bash_mode = guard.get("bashMode", "literal")
    configured_root = guard.get("workspaceRoot")
    if not isinstance(paths, list) or not paths or not all(
        isinstance(path, str) and path.strip() for path in paths
    ):
        raise ValueError(f"{config_path}:readGuard.paths must be a non-empty string array")
    if not isinstance(message, str) or not message.strip():
        raise ValueError(f"{config_path}:readGuard.message must be a non-empty string")
    if bash_mode not in {"allow", "literal", "block"}:
        raise ValueError(f"{config_path}:readGuard.bashMode must be allow, literal, or block")
    if configured_root is not None and not isinstance(configured_root, str):
        raise ValueError(f"{config_path}:readGuard.workspaceRoot must be a string")

    root = (workspace / (configured_root or ".")).resolve(strict=False)
    protected = tuple(
        (path, (root / path).resolve(strict=False)) for path in paths
    )
    return GuardConfig(root, protected, message.strip(), bash_mode)


def _path_argument(args: dict[str, Any]) -> str:
    for key in ("path", "filePath", "file_path", "directory"):
        value = args.get(key)
        if isinstance(value, str):
            return value
    return "."


def _shell_mentions(command: str, spelling: str) -> bool:
    normalized_command = command.replace("\\", "/")
    normalized_path = spelling.replace("\\", "/")
    if not normalized_path or normalized_path == ".":
        return False
    pattern = re.compile(
        rf"(^|[{SHELL_BOUNDARY}]){re.escape(normalized_path)}"
        rf"(?=$|[/ {SHELL_BOUNDARY}])"
    )
    return pattern.search(normalized_command) is not None


def _block_message(tool_name: str, relationship: str, configured: str, message: str) -> dict[str, str]:
    return {
        "action": "block",
        "message": (
            f'Read blocked by agent-context-kit: {tool_name} {relationship} protected path '
            f'"{configured}". {message} Do not retry this protected path.'
        ),
    }


def _pre_tool_call(tool_name: str, args: dict[str, Any] | None = None, **kwargs: Any) -> dict[str, str] | None:
    del kwargs
    workspace = _workspace()
    try:
        guard = _load_guard(workspace)
    except ValueError as error:
        if tool_name in {"read_file", "search_files", "terminal"}:
            return {
                "action": "block",
                "message": f"Read blocked because agent-context-kit configuration is invalid: {error}",
            }
        return None
    if guard is None:
        return None

    arguments = args if isinstance(args, dict) else {}
    if tool_name == "terminal":
        if guard.bash_mode == "allow":
            return None
        command = arguments.get("command")
        if not isinstance(command, str):
            return None
        if guard.bash_mode == "block":
            return {
                "action": "block",
                "message": (
                    "Shell command blocked by agent-context-kit while strict read protection is active. "
                    f"{guard.message} Use scoped read_file or search_files calls instead."
                ),
            }
        for configured, protected in guard.protected:
            if _is_inside(protected, workspace):
                return _block_message(tool_name, "runs inside", configured, guard.message)
            spellings = {
                str(protected),
                os.path.relpath(protected, workspace),
            }
            spellings.update(f"./{value}" for value in tuple(spellings) if not os.path.isabs(value))
            if any(_shell_mentions(command, spelling) for spelling in spellings):
                return _block_message(tool_name, "references", configured, guard.message)
        return None

    if tool_name not in {"read_file", "search_files"}:
        return None
    requested = _path_argument(arguments)
    candidate = (workspace / requested).resolve(strict=False)
    recursive = tool_name == "search_files"
    for configured, protected in guard.protected:
        if _is_inside(protected, candidate):
            return _block_message(tool_name, "targets", configured, guard.message)
        if recursive and _is_inside(candidate, protected):
            return _block_message(tool_name, "would recursively traverse", configured, guard.message)
    return None


def register(ctx: Any) -> None:
    """Register the documented Hermes hooks and trusted discard command."""
    ctx.register_hook("pre_llm_call", _pre_llm_call)
    ctx.register_hook("pre_tool_call", _pre_tool_call)
    ctx.register_hook("on_session_finalize", _finalize_session)
    ctx.register_command(
        "context-discard",
        handler=_discard_command,
        description="Discard a named agent-context-kit block for this session",
        args_hint="<block_id>",
    )
