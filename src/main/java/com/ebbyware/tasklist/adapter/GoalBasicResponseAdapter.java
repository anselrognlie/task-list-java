package com.ebbyware.tasklist.adapter;

import org.springframework.stereotype.Component;

import com.ebbyware.tasklist.model.Goal;
import com.ebbyware.tasklist.response.GoalBasicResponse;

@Component
public class GoalBasicResponseAdapter {
	public GoalBasicResponse adapt(Goal goal) {
		return new GoalBasicResponse(goal);
	}
}
