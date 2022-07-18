package com.ebbyware.tasklist.service;

import java.time.LocalDateTime;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebbyware.tasklist.error.TaskNotFoundException;
import com.ebbyware.tasklist.model.Task;
import com.ebbyware.tasklist.repository.TaskRepository;

@Service
public class TaskService {
	TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Task completeTask(Long id) {
		return taskRepository.findById(id)
				.map(task -> {
					LocalDateTime now = LocalDateTime.now();
					task.setCompletedAt(now);
					return taskRepository.save(task);
				}) //
				.orElseThrow(() -> new TaskNotFoundException(id));
	}
	
	public Task uncompleteTask(Long id) {
		return taskRepository.findById(id)
				.map(task -> {
					task.setCompletedAt(null);
					return taskRepository.save(task);
				}) //
				.orElseThrow(() -> new TaskNotFoundException(id));
	}
}
