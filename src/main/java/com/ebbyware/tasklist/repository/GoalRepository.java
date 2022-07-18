package com.ebbyware.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.ebbyware.tasklist.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
