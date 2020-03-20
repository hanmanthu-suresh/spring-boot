package com.examples.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.persistent.Student;
import com.examples.service.StudentServiceImpl;

@RestController
@RequestMapping(value = "students")
public class StudentRestController {
	@GetMapping(value = "list")
	public List<Student> listStudents() {
		return new StudentServiceImpl().findAll();
	}
	@GetMapping(value = "get/{id}")
	public Student getStudentById(@PathVariable int id) {
		/*
		 * return StudentServiceImpl.findAll().stream().filter(student ->
		 * student.getId() == id).findFirst()
		 * .orElseThrow(IllegalArgumentException::new);
		 */
		return new StudentServiceImpl().getStdById(id);
	}
	@PostMapping("create")
	public void createStudent(@RequestBody Student std) {
		new StudentServiceImpl().create(std);
	}
}
