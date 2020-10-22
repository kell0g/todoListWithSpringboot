package io.kdh.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kdh.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	List<Task> findByDescription(String description);
}
