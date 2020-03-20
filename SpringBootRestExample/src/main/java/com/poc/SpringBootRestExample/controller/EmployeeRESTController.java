package com.poc.SpringBootRestExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.SpringBootRestExample.model.Employee;
import com.poc.SpringBootRestExample.service.EmpService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRESTController {
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("/create")
	public Employee createOrSaveEmployee(@RequestBody Employee newEmployee) {
		return empService.create(newEmployee);
	}
	@GetMapping("/list")
	public List<Employee> getAllEmployees(){
		return empService.findAll();
	}
	@GetMapping("/get/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return empService.getEmpById(id);
	}
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return empService.updateEmpById(emp);
	}
	@DeleteMapping("/delete/{id}")
	public int deleteEmployee(@PathVariable String id) {
		return empService.deleteById(id);
	}
}
