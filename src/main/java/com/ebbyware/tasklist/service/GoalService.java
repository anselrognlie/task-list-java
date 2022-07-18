package com.ebbyware.tasklist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ebbyware.tasklist.error.GoalNotFoundException;
import com.ebbyware.tasklist.error.TaskNotFoundException;
import com.ebbyware.tasklist.model.Goal;
import com.ebbyware.tasklist.model.Task;
import com.ebbyware.tasklist.repository.GoalRepository;
import com.ebbyware.tasklist.repository.TaskRepository;

@Service
public class GoalService {
	GoalRepository goalRepository;
	TaskRepository taskRepository;

	public GoalService(GoalRepository goalRepository, TaskRepository taskRepository) {
		this.goalRepository = goalRepository;
		this.taskRepository = taskRepository;
	}

	public Goal setTasks(Long id, List<Long> taskIds) {
//		taskIds.stream().map(taskId -> {
//			return taskRepository.findById(taskId).map(task -> {
//				return task;
//			}))
//			});
		
//		taskIds.stream().map(taskId -> { return taskId; });
		
		List<Task> tasks = taskIds.stream().map(taskId -> taskRepository.findById(taskId)
					.map(task -> task)
					.orElseThrow(() -> new TaskNotFoundException(taskId))
		)
		.collect(Collectors.toList());

		Goal goal = goalRepository.findById(id).map(g -> g)
		.orElseThrow(() -> new GoalNotFoundException(id));
		
		goal.setTasks(tasks);
		
		return goalRepository.save(goal);
	}

}
