package com.todo.todo.model;

import java.time.LocalDateTime;

public class UpdateTaskDescription {
	
	private String updateDescription;
	
	private LocalDateTime createdDate;

	public String getUpdateDescription() {
		return updateDescription;
	}

	public void setUpdateDescription(String updateDescription) {
		this.updateDescription = updateDescription;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
}
