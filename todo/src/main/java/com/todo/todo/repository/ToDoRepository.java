package com.todo.todo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.todo.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, UUID>{

}
