package com.ebbyware.tasklist.response;

import com.ebbyware.tasklist.model.Goal;
import com.ebbyware.tasklist.model.Task;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskBasicResponse {

	private Task task;
	
	public Long getId() {
		return task.getId();
	}

	public String getTitle() {
		return task.getTitle();
	}
	
	public String getDescription() {
		return task.getDescription();
	}

	@JsonProperty("is_complete")
	public boolean isComplete() {
		return task.isComplete();
	}
	
	@JsonProperty("goal_id")
	@JsonInclude(Include.NON_NULL)
	public Long getGoalId() {
		Goal goal = task.getGoal();
		if (goal == null) { return null; }
		
		return goal.getId();
	}

	public TaskBasicResponse(Task task) {
		this.task = task;
	}
}