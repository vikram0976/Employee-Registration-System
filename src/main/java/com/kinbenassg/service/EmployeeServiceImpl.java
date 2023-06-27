package com.kinbenassg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinbenassg.model.Employee;
import com.kinbenassg.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo er;
	
	@Override
	public List<Employee> getAllEmployees() {
		return er.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		er.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> opt=er.findById(id);
		
		Employee employee=null;
		
		if(opt.isPresent()) {
			employee=opt.get();
		}else {
			throw new RuntimeException("Employee not find: ");
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		er.deleteById(id);
	}

}
