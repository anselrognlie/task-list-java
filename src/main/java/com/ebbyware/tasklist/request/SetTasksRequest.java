package com.ebbyware.tasklist.request;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public class SetTasksRequest {
	List<Long> taskIds;
	
	@JsonCreator
	public SetTasksRequest(@JsonProperty("task_ids") List<Long> taskIds) {
		ArrayList<Long> ids = new ArrayList<Long>();
		if (taskIds != null) {
			ids.addAll(taskIds);
		}
		this.taskIds = ids;
	}
	
	public List<Long> getTaskIds() {
		return taskIds;
	}
}
