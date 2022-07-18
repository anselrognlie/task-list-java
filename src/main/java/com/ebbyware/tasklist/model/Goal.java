package com.ebbyware.tasklist.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Goal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String title;

	@Column
	private String description;

    @OneToMany(mappedBy="goal")
    private List<Task> tasks;

	public Goal() {}

	public Goal(String title, String description) {
		this.title = title;
		this.description = description;
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

	@Override
	public String toString() {
		return "Goal [id=" + id + ", title=" + title + ", desc=" + description + "]";
	}
}
