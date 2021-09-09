package com.terapico.uccaf.explorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.terapico.uccaf.BaseUserContext;

public abstract class PathFinder<U extends BaseUserContext> {
	public static enum TeamType {
		SIMPLE, DO_ALL_OF, DO_ONE_OF;
	}

	protected Map<String, Map<String, PathFinder<U>>> subAdventureTeams;
	protected Map<String, String> subAdventureTeamStartName;
	protected String nextAdventurerName;
	

	public void setNextAdventurerName(String nextAdventurerName) {
		this.nextAdventurerName = nextAdventurerName;
	}

	public ExplorationResults explore(U ctx, Object targetObject) throws Exception {
		if (!isLoopingAdventurer()) {
			return exploreTarget(ctx, targetObject);
		}
		List<Object> loopingTargets = prepareLoopingTargetList(ctx, targetObject);
		if (loopingTargets == null || loopingTargets.isEmpty()) {
			return decideFinalResult(ctx, targetObject, "loop", new ArrayList<>());
		}
		List<ExplorationResults> allResults = new ArrayList<>();
		for (Object subTgtObj : loopingTargets) {
			ExplorationResults subResult = doExploreJobByOneSubTeam(ctx, subTgtObj, "loop");
			allResults.add(subResult);
		}
		return decideFinalResult(ctx, targetObject, "loop", new ArrayList<>());
	}

	protected ExplorationResults exploreTarget(U ctx, Object targetObject) throws Exception {
		TeamType teamType = getTypeType();
		if (TeamType.DO_ONE_OF.equals(teamType)) {
			String chooseResult = chooseOneSubTeam(ctx, targetObject);
			return doExploreJobByOneSubTeam(ctx, targetObject, chooseResult);
		}
		if (TeamType.DO_ALL_OF.equals(teamType)) {
			return doExploreJobByAllSubTeam(ctx, targetObject);
		}
		ExplorationResults result = new ExplorationResults();
		doSelfJob(ctx, result, targetObject);
		return result;
	}

	protected ExplorationResults doExploreJobByOneSubTeam(U ctx, Object targetObject, String teamName)
			throws Exception {
		List<TodoTask> tasks = new ArrayList<>();
		Map<String, PathFinder<U>> adventureTeam = getSubAdventureTeamByName(teamName);
		PathFinder<U> adventurer = adventureTeam.get(getStartFromName(teamName));
		ExplorationResults exploreResult = null;
		for (;;) {
			exploreResult = adventurer.explore(ctx, targetObject);
			tasks.addAll(exploreResult.getTodoTasks());
			if (exploreResult.isStop()) {
				break;
			}

			String nextAdventurerName = adventurer.getNextAdventurerName();
			adventurer = adventureTeam.get(nextAdventurerName);
		}
		exploreResult.setTodoTasks(tasks);
		return exploreResult;
	}

	protected Map<String, PathFinder<U>> getSubAdventureTeamByName(String teamName) {
		Map<String, Map<String, PathFinder<U>>> teams = getSubTeams();
		return teams.get(teamName);
	}

	protected Map<String, Map<String, PathFinder<U>>> getSubTeams() {
		if (subAdventureTeams != null) {
			return subAdventureTeams;
		}
		synchronized (this.getClass()) {
			if (subAdventureTeams != null) {
				return subAdventureTeams;
			}

			Map<String, Map<String, PathFinder<U>>> teamMap = new HashMap<>();
			Map<String, String> teamStartMap = new HashMap<>();
			buildSubTeam(teamMap, teamStartMap);
			subAdventureTeams = teamMap;
			subAdventureTeamStartName = teamStartMap;
		}
		return subAdventureTeams;
	}

	protected void buildSubTeam(Map<String, Map<String, PathFinder<U>>> teamMap, Map<String, String> teamStartMap) {
		// 默认什么也不干
	}

	protected Object getStartFromName(String teamName) {
		return subAdventureTeamStartName.get(teamName);
	}

	protected ExplorationResults doExploreJobByAllSubTeam(U ctx, Object targetObject) throws Exception {
		List<ExplorationResults> allResults = new ArrayList<>();
		for (String teamName : subAdventureTeams.keySet()) {
			ExplorationResults result = doExploreJobByOneSubTeam(ctx, targetObject, teamName);
			allResults.add(result);
		}
		ExplorationResults finalResult = decideFinalResult(ctx, targetObject, "do_all_of", allResults);
		return finalResult;
	}

	// 如果你需要用到这个方法, 你必须重载它
	protected ExplorationResults decideFinalResult(U ctx, Object targetObject, String sceneCode,
			List<ExplorationResults> allResults) throws Exception {
		throw new UnsupportedOperationException("你必须自己重载方法 decideFinalResult()");
	}

	// 如果你需要用到这个方法, 你必须重载它
	protected List<Object> prepareLoopingTargetList(U ctx, Object targetObject) throws Exception {
		throw new UnsupportedOperationException("你必须自己重载方法 prepareLoopingTargetList()");
	}

	// 如果你需要用到这个方法, 你必须重载它
	protected String chooseOneSubTeam(U ctx, Object targetObject) {
		throw new UnsupportedOperationException("你必须自己重载方法 chooseOneSubTeam()");
	}

	public boolean isLoopingAdventurer() {
		return false;
	};

	public TeamType getTypeType() {
		return TeamType.SIMPLE;
	};

	// 这个方法必须重载
	public abstract void doSelfJob(U ctx, ExplorationResults result, Object targetObject) throws Exception;

	// 这个方法也必须重载
	public String getNextAdventurerName() {
		return nextAdventurerName;
	}

	public PathFinder<U> next(String nName) {
		this.setNextAdventurerName(nName);
		return this;
	}

}
