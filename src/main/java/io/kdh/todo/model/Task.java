package io.kdh.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	String description;

	public Task(String description) {
		super();
		this.description = description;
	}
}
