package com.todo.todo.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.todo.todo.model.Status;
import com.todo.todo.model.ToDo;
import com.todo.todo.model.UpdateTaskDescription;


public class ToDoDto {
	
	@Column
	@NotNull
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
	
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(LocalDateTime doneDate) {
		this.doneDate = doneDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Optional<ToDoDto> convert(ToDo toDo) {
		var doDto = new ToDoDto();
		BeanUtils.copyProperties(toDo,doDto);
		return Optional.of(doDto);
	}

	public List<UpdateTaskDescription> getUpdateDescription() {
		return updateDescription;
	}

	public void setUpdateDescription(List<UpdateTaskDescription> updateDescription) {
		this.updateDescription = updateDescription;
	}

	@Override
	public String toString() {
		return "ToDoDto [task=" + task + ", done=" + done + ", createdDate=" + createdDate + ", doneDate=" + doneDate
				+ ", status=" + status + ", updateDescription=" + updateDescription + "]";
	}
	
}
