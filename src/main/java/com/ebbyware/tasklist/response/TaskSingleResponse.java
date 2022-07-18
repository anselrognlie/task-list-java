package com.ebbyware.tasklist.response;

import com.ebbyware.tasklist.model.Task;

public class TaskSingleResponse {

	private Task task;
	
	public TaskBasicResponse getTask() {
		return new TaskBasicResponse(task);
	}
	
	public TaskSingleResponse(Task task) {
		this.task = task;
	}
}