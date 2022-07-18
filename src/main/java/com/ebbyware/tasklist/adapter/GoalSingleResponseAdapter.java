package com.ebbyware.tasklist.adapter;

import org.springframework.stereotype.Component;

import com.ebbyware.tasklist.model.Goal;
import com.ebbyware.tasklist.response.GoalSingleResponse;

@Component
public class GoalSingleResponseAdapter {
	public GoalSingleResponse adapt(Goal goal) {
		return new GoalSingleResponse(goal);
	}
}
