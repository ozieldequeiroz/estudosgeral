package com.todo.todo.service;

import java.time.LocalDateTime;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.internal.build.AllowSysOut;
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
	public Object salvar(ToDo todo) {
		ToDoDto toDoDto = new ToDoDto();
		todo.setCreatedDate(LocalDateTime.now());
		todo.setDone(false);
		todo.setStatus(Status.BACKLOG);
		toDorepository.save(todo);
		return toDoDto.convert(todo);
		

	}
	@Transactional
	public ToDoDto findToDo(Long id) {
		var doDto = new ToDoDto();
		System.out.println("SERVICE - 1 ");
		Optional<ToDo>toDo=toDorepository.findById(id); 
		System.out.println("SERVICE - 2 ");
		if(toDo.isPresent()){
			System.out.println("SERVICE - 3 ");
			System.out.println("SERVICE - 4 "+doDto.convert(toDo.get()));
			return doDto.convert(toDo.get());
		}
		System.out.println("SERVICE - 4 ");
		return null;
	}
	
}
