package com.kinbenassg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kinbenassg.model.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id);
	
	void deleteEmployeeById(Integer id);
}
