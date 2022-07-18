package com.ebbyware.tasklist.adapter;

import org.springframework.stereotype.Component;

import com.ebbyware.tasklist.model.Goal;
import com.ebbyware.tasklist.response.GoalSetTaskResponse;

@Component
public class GoalSetTaskResponseAdapter {
	public GoalSetTaskResponse adapt(Goal goal) {
		return new GoalSetTaskResponse(goal);
	}
}
