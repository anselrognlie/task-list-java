package com.ebbyware.tasklist.response;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.ebbyware.tasklist.model.Goal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GoalSetTaskResponse {

	private Goal goal;
	
	public Long getId() {
		return goal.getId();
	}

	@JsonProperty("task_ids")
	public Iterable<Long> getTaskIds() {
		return StreamSupport.stream(goal.getTasks().spliterator(), false)
		.map(task -> task.getId())
		.collect(Collectors.toList());
	}
		
	public GoalSetTaskResponse(Goal goal) {
		this.goal = goal;
	}
}