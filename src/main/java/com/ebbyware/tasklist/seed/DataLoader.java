package com.ebbyware.tasklist.seed;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ebbyware.tasklist.TaskListApplication;
import com.ebbyware.tasklist.config.PropertiesValues;
import com.ebbyware.tasklist.model.Goal;
import com.ebbyware.tasklist.model.Task;
import com.ebbyware.tasklist.repository.GoalRepository;
import com.ebbyware.tasklist.repository.TaskRepository;

@Configuration
class DataLoader {

	private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

	@Bean
	CommandLineRunner initDatabase(TaskRepository taskRepository, GoalRepository goalRepository) {

		PropertiesValues<?> props = new PropertiesValues<TaskListApplication>(TaskListApplication.class,
				"application.properties");
		boolean create = props.getProperty("app.data.seed").equals("true");

		return args -> {
			if (!create) {
				return;
			}

			taskRepository.save(new Task("task 1", "description 1", LocalDateTime.of(2020, 7, 17, 15, 31)));

			taskRepository.findAll().forEach(task -> log.info("Preloaded " + task));

			goalRepository.save(new Goal("goal 1", "description 1"));

			goalRepository.findAll().forEach(goal -> log.info("Preloaded " + goal));
		};
	}
}