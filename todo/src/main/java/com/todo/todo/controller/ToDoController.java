package com.todo.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.model.ToDo;
import com.todo.todo.repository.ToDoRepository;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
	
	@Autowired
	private ToDoRepository repository;
	
	@PostMapping
	public ToDo save(@RequestBody ToDo toDo) {
		return repository.save(toDo);
	}

}
