package com.todo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todo.model.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, Long>{

}
