package com.ebbyware.tasklist.adapter;

import org.springframework.stereotype.Component;

import com.ebbyware.tasklist.model.Task;
import com.ebbyware.tasklist.response.TaskBasicResponse;

@Component
public class TaskBasicResponseAdapter {
	public TaskBasicResponse adapt(Task task) {
		return new TaskBasicResponse(task);
	}
}
