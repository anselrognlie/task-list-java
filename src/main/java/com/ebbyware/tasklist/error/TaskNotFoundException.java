package com.ebbyware.tasklist.error;

public class TaskNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -908146839894062234L;

	public TaskNotFoundException(Long id) {
		super("Could not find task " + id);
	}
}