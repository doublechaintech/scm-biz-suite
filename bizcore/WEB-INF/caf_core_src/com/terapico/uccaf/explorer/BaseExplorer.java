package com.terapico.uccaf.explorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.terapico.uccaf.BaseUserContext;

public abstract class BaseExplorer<U extends BaseUserContext> {
	protected static final int CODE_CONTINUE = 0;
	protected static final int CODE_JUMP = 1;

	protected abstract void buildTeam(Map<String, PathFinder<U>> team);

	public abstract String getStartFromName();

	public abstract String getExploreName();

	protected Map<String, PathFinder<U>> adventureTeam = null;

	public Map<String, PathFinder<U>> getAdventureTeam() {
		if (adventureTeam != null) {
			return adventureTeam;
		}
		synchronized (this.getClass()) {
			if (adventureTeam != null) {
				return adventureTeam;
			}
			Map<String, PathFinder<U>> team = new HashMap<>();
			buildTeam(team);
			adventureTeam = team;
			return adventureTeam;
		}
	}

	public ExplorationResults explore(U ctx, Object tgtObject) throws Exception {
		Map<String, PathFinder<U>> adventureTeam = this.getAdventureTeam();
		PathFinder<U> adventurer = adventureTeam.get(getStartFromName());
		List<TodoTask> tasks = new ArrayList<>();
		goThroughPaths(ctx, tgtObject, adventureTeam, adventurer, tasks);
		ExplorationResults result = new ExplorationResults();
		result.setTodoTasks(tasks);
		return result;
	}

	protected void goThroughPaths(U ctx, Object tgtObject, Map<String, PathFinder<U>> adventureTeam,
			PathFinder<U> adventurer, List<TodoTask> tasks) throws Exception {
		for (;;) {
			ExplorationResults exploreResult = adventurer.explore(ctx, tgtObject);
			if (exploreResult.getTodoTasks() != null && !exploreResult.getTodoTasks().isEmpty()) {
				tasks.addAll(exploreResult.getTodoTasks());
			}
			if (exploreResult.isStop()) {
				return;
			}

			String nextAdventurerName = adventurer.getNextAdventurerName();
			if (exploreResult.isJump()) {
				nextAdventurerName = exploreResult.getNextAdventurerName();
			}
			if (nextAdventurerName == null || !adventureTeam.containsKey(nextAdventurerName)) {
				return;
			}
			adventurer = adventureTeam.get(nextAdventurerName);
		}
	}

	protected void addTaskNameIntoExploreResultTaskSet(U ctx, String key, String taskName) {
		@SuppressWarnings("unchecked")
		Set<String> rst = (Set<String>) ctx.getFromContextLocalStorage(key);
		if (rst == null) {
			rst = new HashSet<>();
			ctx.putIntoContextLocalStorage(key, rst);
		}
		rst.add(taskName);
	}

	protected void log(U ctx, String adventurer, int resultCode) {
		ctx.log(String.format("Run [%s]:%d (%s)", adventurer, resultCode, getCodeName(resultCode)));
	}

	protected Object getCodeName(int resultCode) {
		String name = getCodeNames().get(resultCode);
		if (name == null) {
			return "no-name";
		}
		return name;
	}

	protected abstract Map<Integer, String> getCodeNames();

}
