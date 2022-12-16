package com.todo.todo.controller;

import java.util.Optional;

import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.model.Status;
import com.todo.todo.model.ToDo;
import com.todo.todo.model.dto.ToDoDto;
import com.todo.todo.repository.ToDoRepository;
import com.todo.todo.service.ToDoService;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
	
	Scanner input = new Scanner(System.in);
	
	@Autowired
	private ToDoRepository repository;
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
	
		Optional<ToDoDto>toDo = toDoService.editTask(id, doTdo);
		
		if(!toDo.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(doTdo);
		}
	}

}
