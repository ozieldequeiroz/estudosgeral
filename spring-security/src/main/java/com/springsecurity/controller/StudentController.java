package com.springsecurity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.orm.Student;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	
	private static final List<Student> STUDENT = Arrays.asList(
			new Student(1,"James Bond"),
			new Student(2,"Maria Jones"),
			new Student(3,"Anna Smith")
			);
	
	@GetMapping(path="{studentId}")
	public Student getStudent(@PathVariable Integer studentId) {
		return STUDENT.stream()
				.filter(s->studentId.equals(s.getId()))
				.findFirst()
				.orElseThrow(()-> new IllegalStateException("Student"+studentId+" do not found "));
	}

}
