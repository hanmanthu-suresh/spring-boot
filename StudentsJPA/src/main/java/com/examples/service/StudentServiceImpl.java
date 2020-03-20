package com.examples.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.examples.persistent.Student;

public class StudentServiceImpl {
	
	static List<Student> list = new ArrayList<Student>(
			Arrays.asList(new Student(1,"Hena"),
					new Student(2,"Jaiho")
					));
	public StudentServiceImpl() {
		
	}
	
	public List<Student> findAll() {
		//List<Student> list = Arrays.asList(new Student(1, "d"), new Student(2, "g"));
		return list;
	}

	public Student getStdById(int id) {
		for(Student l: list) {
			if(l.getId()==id) {
				return l;
			}
		}
		return null;
	}

	public void create(Student std) {
		list.add(std);
	}
}
