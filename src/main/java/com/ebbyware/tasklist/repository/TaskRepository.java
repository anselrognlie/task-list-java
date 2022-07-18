package com.ebbyware.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.ebbyware.tasklist.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
