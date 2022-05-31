package com.track.service;

import java.util.List;

import com.track.entity.Employee;
import com.track.exception.EmployeeNotFoundException;

public interface EmployeeService {
	public Employee registerEmployee(Employee employee);
	public Employee searchEmployee(int userId) throws EmployeeNotFoundException;
	public Employee deleteEmployee(int userId) throws EmployeeNotFoundException;
	
public 	List<Employee> getAllEmployees() throws EmployeeNotFoundException;
		
	}
