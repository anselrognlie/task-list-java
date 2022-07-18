package com.ebbyware.tasklist.response;

import com.ebbyware.tasklist.model.Goal;

public class GoalSingleResponse {

	private Goal goal;
	
	public GoalBasicResponse getGoal() {
		return new GoalBasicResponse(goal);
	}
	
	public GoalSingleResponse(Goal goal) {
		this.goal = goal;
	}
}