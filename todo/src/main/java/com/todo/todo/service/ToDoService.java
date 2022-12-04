package com.todo.todo.service;

import org.springframework.stereotype.Service;

import com.todo.todo.model.ToDo;
import com.todo.todo.repository.ToDoRepository;

@Service
public class ToDoService {
	
	private ToDoRepository toDorepository;

	public ToDoService(ToDoRepository toDorepository) {
		this.toDorepository = toDorepository;
	}

	public ToDo salvar(ToDo todo) {
		return toDorepository.save(todo);
	}
	
}
