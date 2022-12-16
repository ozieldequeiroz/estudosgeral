package com.todo.todo.service;

import java.time.LocalDateTime;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.todo.model.Status;
import com.todo.todo.model.ToDo;
import com.todo.todo.model.dto.ToDoDto;
import com.todo.todo.repository.ToDoRepository;

@Service
public class ToDoService {
	
	private ToDoRepository toDorepository;

	public ToDoService(ToDoRepository toDorepository) {
		this.toDorepository = toDorepository;
	}

	@Transactional
	public Object salvar(ToDo todo) {
		ToDoDto toDoDto = new ToDoDto();
		todo.setCreatedDate(LocalDateTime.now());
		todo.setDone(false);
		todo.setStatus(Status.BACKLOG);
		toDorepository.save(todo);
		return toDoDto.convert(todo);

	}
	@Transactional
	public Optional<ToDo> findToDo(Long id) {
		Optional<ToDo>toDo=toDorepository.findById(id); 
		if(toDo.isPresent()){
			return toDo;
		}
		return null;
	}
	
	public Optional<ToDoDto> editTask(Long id, ToDoDto doTdo) {
		Optional<ToDo>toDo = toDorepository.findById(id);
		
		if(!toDo.isPresent()){
			return null;
		} else {
			toDo.get().setId(id);
			
			if (!doTdo.getTask().isEmpty()) {
				toDo.get().setTask(doTdo.getTask());	
			}

			if (doTdo.getStatus() != null) {
				toDo.get().setStatus(doTdo.getStatus());
			}
			toDorepository.save(toDo.get());
			return new ToDoDto().convert(toDo.get());
		}
	}
	
}