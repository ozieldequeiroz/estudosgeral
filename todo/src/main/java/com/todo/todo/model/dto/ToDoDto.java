package com.todo.todo.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.todo.todo.model.Status;
import com.todo.todo.model.UpdateTaskDescription;

public class ToDoDto {

	@Column
	private String task;
	
	@Column
	private boolean done;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createdDate;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime doneDate;
	
	@Column
	private Status status;
	
	@OneToMany
	@JoinColumn(name = "to_do_id", nullable = false)
	private List<UpdateTaskDescription> updateDescription;

}
