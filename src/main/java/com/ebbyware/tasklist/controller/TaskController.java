package com.ebbyware.tasklist.controller;

import java.util.stream.Collectors;

//import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebbyware.tasklist.model.Task;
import com.ebbyware.tasklist.repository.TaskRepository;
import com.ebbyware.tasklist.response.TaskBasicResponse;
import com.ebbyware.tasklist.response.TaskSingleResponse;
import com.ebbyware.tasklist.service.TaskService;
import com.ebbyware.tasklist.adapter.TaskBasicResponseAdapter;
import com.ebbyware.tasklist.adapter.TaskSingleResponseAdapter;
import com.ebbyware.tasklist.error.TaskNotFoundException;

@CrossOrigin
@RestController
class TaskController {

	private final TaskRepository repository;
	private final TaskBasicResponseAdapter basicAdapter;
	private final TaskSingleResponseAdapter singleAdapter;
	private final TaskService taskService;

	TaskController(TaskRepository repository, TaskBasicResponseAdapter basicAdapter,
			TaskService taskService, TaskSingleResponseAdapter singleAdapter) {
		this.repository = repository;
		this.basicAdapter = basicAdapter;
		this.singleAdapter = singleAdapter;
		this.taskService = taskService;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/tasks")
	Iterable<TaskBasicResponse> all() {

		return repository.findAll().stream().map(basicAdapter::adapt).collect(Collectors.toList());
	} // end::get-aggregate-root[]

//  @PostMapping("/tasks")
//  Task newTask(@RequestBody Task newTask) {
//    return repository.save(newTask);
//  }

	@PostMapping("/tasks")
	TaskSingleResponse newTask(@RequestBody Task newTask) {

		return singleAdapter.adapt(repository.save(newTask));
	}

	// Single item

	@GetMapping("/tasks/{id}")
	TaskSingleResponse one(@PathVariable Long id) {

		return repository.findById(id).map(singleAdapter::adapt).orElseThrow(() -> new TaskNotFoundException(id));
	}

	@PutMapping("/tasks/{id}")
	TaskSingleResponse replaceTask(@RequestBody Task newTask, @PathVariable Long id) {

		return repository.findById(id) //
				.map(task -> {
					task.setTitle(newTask.getTitle());
					task.setDescription(newTask.getDescription());
					task.setCompletedAt(newTask.getCompletedAt());
					return singleAdapter.adapt(repository.save(task));
				}) //
				.orElseThrow(() -> new TaskNotFoundException(id));
	}

	@DeleteMapping("/tasks/{id}")
	ResponseEntity<?> deleteTask(@PathVariable Long id) {

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/tasks/{id}/mark_complete")
	TaskSingleResponse completeTask(@PathVariable Long id) {

		return singleAdapter.adapt(taskService.completeTask(id));
	}
	
	@PatchMapping("/tasks/{id}/mark_incomplete")
	TaskSingleResponse uncompleteTask(@PathVariable Long id) {
		
		return singleAdapter.adapt(taskService.uncompleteTask(id));
	}
}
