package com.ebbyware.tasklist.adapter;

import org.springframework.stereotype.Component;

import com.ebbyware.tasklist.model.Goal;
import com.ebbyware.tasklist.response.GoalTasksResponse;

@Component
public class GoalTasksResponseAdapter {
	public GoalTasksResponse adapt(Goal goal) {
		return new GoalTasksResponse(goal);
	}
}
