package com.todo.todo.service;



import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.todo.model.UserModel;
import com.todo.todo.repository.UserModelRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	final UserModelRepository repository;

	public UserDetailsServiceImpl(UserModelRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = repository.findByName(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"+username) );
		return new User(user.getName(),user.getPassword(),true,true,true,true,user.getAuthorities());
	}
	
	

}
