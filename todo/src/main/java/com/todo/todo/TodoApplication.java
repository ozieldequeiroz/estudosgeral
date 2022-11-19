package com.todo.todo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.model.ToDo;
import com.todo.todo.repository.ToDoRepository;

@SpringBootApplication
public class TodoApplication {
	
	@Autowired
	private ToDoRepository repository;
	
	@Bean
	public CommandLineRunner init() {
		return new CommandLineRunner() {
				@Override
				public void run(String... args) throws Exception {
					ToDo todo = new ToDo();
					todo.setDescription("Aprender Spring");
					todo.setCreatedDate(LocalDateTime.now());
					repository.save(todo);
				}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
		
	}

}
