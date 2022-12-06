package com.todo.todo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ToDo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public boolean isDone() {
		return done;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<UpdateTaskDescription> getUpdateDescription() {
		return updateDescription;
	}

	public void setUpdateDescription(List<UpdateTaskDescription> updateDescription) {
		this.updateDescription = updateDescription;
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

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", task=" + task + ", done=" + done + ", createdDate=" + createdDate + ", doneDate="
				+ doneDate + ", status=" + status + ", updateDescription=" + updateDescription + "]";
	}
	
	
	
}
