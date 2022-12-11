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
		
		if (toDorepository.count() > 0) {
			return "Task já existe";
		} else {
			todo.setCreatedDate(LocalDateTime.now());
			todo.setDone(false);
			todo.setStatus(Status.BACKLOG);
			toDorepository.save(todo);
			return toDoDto.convert(todo);
		}

	}
	
	public ToDoDto findToDo(UUID id) {
		System.out.println("SERVICE-STEP - 1"+id);
		var doDto = new ToDoDto();
		Optional<ToDo>toDo=toDorepository.findById(id); 
		System.out.println("SERVICE- STEP - 2"+toDo.toString());
		if(toDo.isPresent()){
			System.out.println("SERVICE- STEP - 3"+doDto.toString());
			return doDto.convert(toDo.get());
		}
		return null;
	}
	
}
