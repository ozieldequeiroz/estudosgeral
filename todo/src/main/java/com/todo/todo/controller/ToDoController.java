package com.todo.todo.controller;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.model.ToDo;
import com.todo.todo.repository.ToDoRepository;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
	
	Scanner input = new Scanner(System.in);
	
	@Autowired
	private ToDoRepository repository;
	
	@PostMapping
	public ResponseEntity<ToDo> save(@RequestBody ToDo toDo) {
		repository.save(toDo);
		return ResponseEntity.ok(toDo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ToDo> getById(@PathVariable UUID id) {
		
		Optional<ToDo>todo= repository.findById(id);
		
		if (todo.isPresent()) {
		return ResponseEntity.ok().body(todo.get());
		} else {
		return	ResponseEntity.notFound().build();
		}
				
	}
	@PutMapping("/edit/{id}")
	public ResponseEntity<ToDo> edit(@PathVariable UUID id,String newTask) {
		ToDo updateToDo = new ToDo();
		Optional<ToDo>todo = repository.findById(id);
		
		if(todo.isPresent()){
			updateToDo.setId(id);
			updateToDo.setTask(newTask);
			repository.save(updateToDo);
			return ResponseEntity.ok(updateToDo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
