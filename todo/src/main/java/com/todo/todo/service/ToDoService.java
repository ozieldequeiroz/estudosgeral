package com.todo.todo.service;

import java.time.LocalDateTime;
import java.util.Arrays;
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
	
	@Transactional
	public Optional<ToDoDto> editTask(Long id, ToDoDto doDto) {
		System.out.println("SERVICE - STEP 1 "+doDto);
		var auxToDo = new ToDo();
		boolean exist = toDorepository.existsById(id);
	
		if(!exist){
			return null;
		} else {
			
			if (!doDto.getTask().isBlank()) {
				System.out.println("SERVICE - STEP 2 DENTRO DO IF "+doDto.getTask());
				auxToDo.setTask(doDto.getTask());	
			}
			if (doDto.getStatus() != null ) {
				auxToDo.setStatus(doDto.getStatus());	
			}
			
			auxToDo.setId(id);
			toDorepository.save(auxToDo);
			return new ToDoDto().convert(auxToDo);
		}
	}
	
	@Transactional
	public UpdateTaskDescription addUpdate(Long id,UpdateTaskDescription update) {
		ToDo updateToDo = new ToDo();

		Optional<ToDo>toDoAux = toDorepository.findById(id); 
		BeanUtils.copyProperties(toDoAux.get(),updateToDo);
		updateToDo.setUpdateDescription(Arrays.asList(update));
		toDorepository.save(updateToDo);
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
