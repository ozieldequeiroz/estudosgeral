package com.todo.todo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.model.ToDo;
import com.todo.todo.model.UpdateTaskDescription;
import com.todo.todo.model.dto.ToDoDto;
import com.todo.todo.service.ToDoService;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody ToDo toDo) {	
		return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.salvar(toDo));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getToDo(@PathVariable(value = "id") Long id) {
	 Optional<ToDo> toDo= toDoService.findToDo(id);
	 var toDoDto = new ToDoDto().convert(toDo.get());
		if (toDo.isPresent()) {
		return ResponseEntity.ok().body(toDoDto);
		} else {
		return	ResponseEntity.notFound().build();
		}
				
	}
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> edit(@PathVariable(value = "id") Long id, @RequestBody ToDoDto doTdo) {
		System.out.println("CONTROLLER - STEP 1 "+doTdo.toString());
		boolean  exit = toDoService.exist(id);
		
		if(!exit){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(toDoService.editTask(id, doTdo));
		}
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,@RequestBody UpdateTaskDescription update) {
		Optional<ToDo> toDo= toDoService.findToDo(id);
		System.out.println("CONTROLLER - STEP 1 "+toDo.toString());
		
		if(!toDo.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			
			System.out.println("CONTROLLER - STEP 2 "+update);
			var updateTask = new UpdateTaskDescription();
			updateTask = toDoService.addUpdate(id, update);
			return ResponseEntity.status(HttpStatus.CREATED).body(updateTask);
		}
	}
	

}
