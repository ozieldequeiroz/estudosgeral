package com.todo.todo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class UpdateTaskDescription implements Serializable{
		
	public UpdateTaskDescription() {
		this.updateDate=LocalDateTime.now();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long Id;
	@Column
	private String updateDescription;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime updateDate;

	public String getUpdateDescription() {
		return updateDescription;
	}

	public void setUpdateDescription(String updateDescription) {
		this.updateDescription = updateDescription;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}


	@Override
	public String toString() {
		return "UpdateTaskDescription [updateDescription=" + updateDescription + ", updateDate=" + updateDate + "]";
	}
	
}
