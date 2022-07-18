package com.ebbyware.tasklist.error;

public class GoalNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3182202095476717364L;

	public GoalNotFoundException(Long id) {
		super("Could not find goal " + id);
	}
}