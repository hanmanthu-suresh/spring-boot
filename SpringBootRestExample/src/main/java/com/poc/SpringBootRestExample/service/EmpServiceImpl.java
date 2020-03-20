package com.poc.SpringBootRestExample.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.SpringBootRestExample.exception.AlphaNumericsException;
import com.poc.SpringBootRestExample.exception.UserNotFoundException;
import com.poc.SpringBootRestExample.model.Employee;
import com.poc.SpringBootRestExample.repository.EmployeeRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmployeeRepository repository;

	public EmployeeRepository getRepository() {
		return repository;
	}

	public void setRepository(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Employee create(Employee newEmployee) {
		return repository.save(newEmployee);
	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee getEmpById(String id) {
		if (StringUtils.isAlphanumeric(id) != StringUtils.isNumeric(id)) {
			throw new AlphaNumericsException(id, "AlphaNumerics Not Allowed");
		}
		return repository.findById(Integer.parseInt(id)).orElseThrow(
				() -> new UserNotFoundException(Integer.parseInt(id), "Employee id'" + id + "'does not exist"));
	}

	@Override
	public Employee updateEmpById(Employee emp) {

		return repository.findById(emp.getId()).map(employee -> {
			employee.setFirstName(emp.getFirstName());
			employee.setLastName(emp.getLastName());
			employee.setEmail(emp.getEmail());
			return repository.save(employee);
		}).orElseGet(() -> {
			emp.setId(emp.getId());
			return repository.save(emp);
		});
	}

	@Override
	public int deleteById(String id) {
		if(StringUtils.isNotBlank(id)&& StringUtils.isAlphanumeric(id)) {
			try {
				repository.deleteById(Integer.parseInt(id));
			}
			catch(NumberFormatException ex) {
				throw new AlphaNumericsException(id, "Alphanumerics Not Allowed");
			}
			catch(RuntimeException ex) {
				throw new UserNotFoundException(Integer.parseInt(id), "Employee id'"+id+"' does not exist");
			}
		}
		return Integer.parseInt(id);
	}

}
