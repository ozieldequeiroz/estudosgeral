package com.springsecurity.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration 
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests()
		.antMatchers("index")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
	}

	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails annaSmithUser=User.builder()
				.username("annasmith")
				.password("12345")
				.roles("STUDENT")
				.build();
		return new InMemoryUserDetailsManager(annaSmithUser);
	}
	
	
	
	
	

	

}
