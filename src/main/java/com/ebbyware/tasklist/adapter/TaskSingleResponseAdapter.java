package com.ebbyware.tasklist.adapter;

import org.springframework.stereotype.Component;

import com.ebbyware.tasklist.model.Task;
import com.ebbyware.tasklist.response.TaskSingleResponse;

@Component
public class TaskSingleResponseAdapter {
	public TaskSingleResponse adapt(Task task) {
		return new TaskSingleResponse(task);
	}
}
