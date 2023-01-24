package com.todo.todo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todo.todo.model.UserModel;
import com.todo.todo.repository.UserModelRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	final UserModelRepository repository;

	public UserDetailsServiceImpl(UserModelRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = repository.findByName(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"+username) );
		return user;
	}
	
	

}
