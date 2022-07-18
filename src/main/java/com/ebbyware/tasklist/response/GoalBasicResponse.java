package com.ebbyware.tasklist.response;

import com.ebbyware.tasklist.model.Goal;

public class GoalBasicResponse {

	private Goal goal;
	
	public Long getId() {
		return goal.getId();
	}

	public String getTitle() {
		return goal.getTitle();
	}
	
	protected Goal getGoal() {
		return goal;
	}
		
	public GoalBasicResponse(Goal goal) {
		this.goal = goal;
	}
}