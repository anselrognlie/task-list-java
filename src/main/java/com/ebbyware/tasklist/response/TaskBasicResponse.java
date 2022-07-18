package com.ebbyware.tasklist.response;

import com.ebbyware.tasklist.model.Task;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskBasicResponse {

	private Task task;
	
	public Long getId() {
		return task.getId();
	}

	public String getTitle() {
		return task.getTitle();
	}
	
	public String getDescription() {
		return task.getDescription();
	}

	@JsonProperty("is_complete")
	public boolean isComplete() {
		return task.isComplete();
	}
	
	public TaskBasicResponse(Task task) {
		this.task = task;
	}
}