package com.terapico.uccaf.explorer;

import java.util.ArrayList;
import java.util.List;

public class ExplorationResults {
	protected boolean stop = false;
	protected boolean jump = false;
	protected List<TodoTask> todoTasks;
	protected String nextAdventurerName;
	
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public boolean isJump() {
		return jump;
	}
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	public List<TodoTask> getTodoTasks() {
		return todoTasks;
	}
	public void setTodoTasks(List<TodoTask> todoTasks) {
		this.todoTasks = todoTasks;
	}
	public String getNextAdventurerName() {
		return nextAdventurerName;
	}
	public void setNextAdventurerName(String nextAdventurerName) {
		this.nextAdventurerName = nextAdventurerName;
	}

	public void addTask(TodoTask task) {
		ensureTaskList();
		todoTasks.add(task);
	}
	private void ensureTaskList() {
		if (todoTasks == null) {
			todoTasks = new ArrayList<>();
		}
	}

	
}
