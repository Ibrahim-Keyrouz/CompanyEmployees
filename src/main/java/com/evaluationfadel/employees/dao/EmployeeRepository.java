package com.evaluationfadel.employees.dao;

import java.util.List;

import com.evaluationfadel.employees.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();
	void deleteEmployee(Integer empId);
	void insertEmployee(Employee emp);
}
