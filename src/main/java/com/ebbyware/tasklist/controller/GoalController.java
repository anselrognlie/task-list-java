package com.ebbyware.tasklist.controller;

import java.util.stream.Collectors;

//import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebbyware.tasklist.model.Goal;
import com.ebbyware.tasklist.repository.GoalRepository;
import com.ebbyware.tasklist.request.SetTasksRequest;
import com.ebbyware.tasklist.response.GoalSetTaskResponse;
import com.ebbyware.tasklist.response.GoalBasicResponse;
import com.ebbyware.tasklist.response.GoalSingleResponse;
import com.ebbyware.tasklist.response.GoalTasksResponse;
import com.ebbyware.tasklist.service.GoalService;
import com.ebbyware.tasklist.adapter.GoalSetTaskResponseAdapter;
import com.ebbyware.tasklist.adapter.GoalBasicResponseAdapter;
import com.ebbyware.tasklist.adapter.GoalSingleResponseAdapter;
import com.ebbyware.tasklist.adapter.GoalTasksResponseAdapter;
import com.ebbyware.tasklist.error.GoalNotFoundException;

@CrossOrigin
@RestController
class GoalController {

	private final GoalRepository repository;
	private final GoalBasicResponseAdapter basicAdapter;
	private final GoalSingleResponseAdapter singleAdapter;
	private final GoalService goalService;
	private final GoalSetTaskResponseAdapter setTaskAdapter;
	private final GoalTasksResponseAdapter goalTasksAdapter;

	GoalController(GoalRepository repository, GoalBasicResponseAdapter basicAdapter,
			GoalService goalService, 
			GoalSingleResponseAdapter singleAdapter,
			GoalSetTaskResponseAdapter setTaskAdapter,
			GoalTasksResponseAdapter goalTasksAdapter) {
		this.repository = repository;
		this.basicAdapter = basicAdapter;
		this.singleAdapter = singleAdapter;
		this.goalService = goalService;
		this.setTaskAdapter = setTaskAdapter;
		this.goalTasksAdapter = goalTasksAdapter;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/goals")
	Iterable<GoalBasicResponse> all() {

		return repository.findAll().stream().map(basicAdapter::adapt).collect(Collectors.toList());
	} // end::get-aggregate-root[]

	@PostMapping("/goals")
	GoalSingleResponse newGoal(@RequestBody Goal newGoal) {

		return singleAdapter.adapt(repository.save(newGoal));
	}

	// Single item

	@GetMapping("/goals/{id}")
	GoalSingleResponse one(@PathVariable Long id) {

		return repository.findById(id).map(singleAdapter::adapt).orElseThrow(() -> new GoalNotFoundException(id));
	}

	@PutMapping("/goals/{id}")
	GoalSingleResponse replaceGoal(@RequestBody Goal newGoal, @PathVariable Long id) {

		return repository.findById(id) //
				.map(goal -> {
					goal.setTitle(newGoal.getTitle());
					goal.setDescription(newGoal.getDescription());
					return singleAdapter.adapt(repository.save(goal));
				}) //
				.orElseThrow(() -> new GoalNotFoundException(id));
	}

	@DeleteMapping("/goals/{id}")
	ResponseEntity<?> deleteGoal(@PathVariable Long id) {

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/goals/{id}/tasks")
	GoalSetTaskResponse setTasks(@RequestBody SetTasksRequest body, @PathVariable Long id) {

		return setTaskAdapter.adapt(goalService.setTasks(id, body.getTaskIds()));
	}
	
	@GetMapping("/goals/{id}/tasks")
	GoalTasksResponse getGoalTasks(@PathVariable Long id) {
		
		return repository.findById(id).map(goalTasksAdapter::adapt).orElseThrow(() -> new GoalNotFoundException(id));
	}
	
//	@PatchMapping("/goals/{id}/mark_incomplete")
//	GoalSingleResponse uncompleteGoal(@PathVariable Long id) {
//		
//		return singleAdapter.adapt(goalService.uncompleteGoal(id));
//	}
}
