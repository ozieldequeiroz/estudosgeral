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
import com.todo.todo.model.UpdateTaskDescription;
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
		System.out.println("SERVICE - salvar - STEP 1");
		ToDoDto toDoDto = new ToDoDto();
		todo.setCreatedDate(LocalDateTime.now());
		todo.setDone(false);
		todo.setStatus(Status.BACKLOG);
		toDorepository.save(todo);
		return toDoDto.convert(todo);

	}
	@Transactional
	public Optional<ToDo> findToDo(Long id) {
		System.out.println("SERVICE - findToDo - STEP 1"+id);
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
	
	public UpdateTaskDescription addUpdate(Long id,UpdateTaskDescription update) {
		System.out.println("SERVICE - STEP 1 -"+id);
		Optional<ToDo>toDoAux = toDorepository.findById(id); 
		System.out.println("SERVICE - STEP 2 -"+update.getUpdateDescription());
		//updateTask.setUpdateDescription(update.getUpdateDescription());
		toDoAux.get().setUpdateDescription(update);
		System.out.println("SERVICE - STEP 3 -"+toDoAux.get().getUpdateDescription());
		System.out.println("SERVICE - STEP 4 -"+toDoAux.toString());
		toDorepository.save(toDoAux.get());
		System.out.println("SERVICE - STEP 5 -"+toDoAux.toString());
		return update;
		
	}

	@Transactional
	public void addUpdateTask(Long id, UpdateTaskDescription updateTask) {
		Optional<ToDo>toDoAux = toDorepository.findById(id); 
			if(!toDoAux.isPresent()){
				//return null;
			} else {
				toDoAux.get().setUpdateDescription(null);
		}
	}
	
	public boolean exist(Long id) {
	 boolean exist = toDorepository.existsById(id);
		 if (!exist) {
			return exist;
		} else {
			return exist;
		}
	}
	
}
