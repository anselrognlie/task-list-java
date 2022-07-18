package com.ebbyware.tasklist.response;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.ebbyware.tasklist.model.Goal;

public class GoalTasksResponse extends GoalBasicResponse {
	public GoalTasksResponse(Goal goal) {
		super(goal);
	}
	
	public Iterable<TaskBasicResponse> getTasks() {
		return StreamSupport.stream(getGoal().getTasks().spliterator(), false)
		.map(task -> new TaskBasicResponse(task))
		.collect(Collectors.toList());
	}
}