package io.kdh.todo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kdh.todo.TaskRepository;
import io.kdh.todo.model.Task;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
@Slf4j
public class TaskController {
	@Autowired
	TaskRepository taskRepository;

	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String description) {
		log.info("getAllTasks");
		try {
			List<Task> tasks = new ArrayList<>();
			taskRepository.findAll().forEach(tasks::add);

			if (tasks.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tasks, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
		log.info("getTaskById");
		Optional<Task> taskData = taskRepository.findById(id);
		if (taskData.isPresent()) {
			return new ResponseEntity<>(taskData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tasks")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		log.info("createTask");
		try {
			Task _task = taskRepository.save(new Task(task.getDescription()));
			return new ResponseEntity<>(_task, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") Long id) {
		log.info("deleteTask");
		try {
			taskRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
