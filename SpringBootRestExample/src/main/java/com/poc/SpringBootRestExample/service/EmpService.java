package com.poc.SpringBootRestExample.service;

import java.util.List;

import com.poc.SpringBootRestExample.model.Employee;

public interface EmpService {

	Employee create(Employee newEmployee);

	List<Employee> findAll();

	Employee getEmpById(String id);

	Employee updateEmpById(Employee emp);

	int deleteById(String id);
}
