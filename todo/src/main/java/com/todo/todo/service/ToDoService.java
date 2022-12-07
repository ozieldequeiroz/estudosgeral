package com.todo.todo.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
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
	public ToDoDto salvar(ToDo todo) {
		ToDoDto toDoDto = new ToDoDto();
		todo.setCreatedDate(LocalDateTime.now());
		todo.setDone(false);
		todo.setStatus(Status.BACKLOG);
		toDoDto.convert(todo);
		toDorepository.save(todo);
		return toDoDto;
	}
	
	public ToDoDto encontreDo(UUID id) {
		var doDto = new ToDoDto();
		Optional<ToDo>toDo=toDorepository.findById(id);
		if(toDo.isPresent()){
			return	doDto.convert(toDo.get());
		}
		return null;
	}
	
}
