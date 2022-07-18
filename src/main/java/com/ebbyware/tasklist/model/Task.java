package com.ebbyware.tasklist.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private LocalDateTime completedAt;
	
    @ManyToOne
    @JoinColumn(name="goal_id", nullable=true)
    private Goal goal;

    public Task() {}

	public Task(String title, String description, LocalDateTime completedAt) {
		this.title = title;
		this.description = description;
		this.completedAt = completedAt;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}
	
	public boolean isComplete() {
		return this.completedAt != null;
	}
	
	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", desc=" + description + ", copletedAt=" + completedAt + "]";
	}
}
