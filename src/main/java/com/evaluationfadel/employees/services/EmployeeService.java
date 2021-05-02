package com.evaluationfadel.employees.services;

import java.util.List;

import com.evaluationfadel.employees.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void deleteEmployee(Integer empId);
	void insertEmployee(Employee emp);
}
