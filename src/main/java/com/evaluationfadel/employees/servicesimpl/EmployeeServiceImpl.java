package com.evaluationfadel.employees.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluationfadel.employees.dao.EmployeeRepository;
import com.evaluationfadel.employees.model.Employee;
import com.evaluationfadel.employees.services.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployees();
	}
	@Override
	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		 employeeRepository.deleteEmployee(empId);
	}
	@Override
	public void insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeRepository.insertEmployee(emp);
		
	}
	@Override
	public List<Employee> getSpecificEmployees(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.getSpecificEmployees(employee);
	}

}
