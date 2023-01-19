package com.todo.todo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todo.model.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, Long>{
	
	Optional<UserModel> findByName(String name);

}
