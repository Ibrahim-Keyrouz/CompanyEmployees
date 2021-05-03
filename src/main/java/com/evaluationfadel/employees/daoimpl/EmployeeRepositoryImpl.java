package com.evaluationfadel.employees.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evaluationfadel.employees.GlobalVars;
import com.evaluationfadel.employees.dao.EmployeeRepository;
import com.evaluationfadel.employees.model.Employee;
import com.evaluationfadel.employees.utilities.IOFunctions;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return IOFunctions.readFile(GlobalVars.employeesDBFilePath+GlobalVars.employeesDBFileName);
	}

	@Override
	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		IOFunctions.deleteRowInFile(GlobalVars.employeesDBFilePath+GlobalVars.employeesDBFileName, empId);
	}

	@Override
	public void insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		IOFunctions.insertRowInFile(GlobalVars.employeesDBFilePath+GlobalVars.employeesDBFileName, emp);
	}

	@Override
	public List<Employee> getSpecificEmployees(Employee employee) {
		// TODO Auto-generated method stub
		return IOFunctions.fetchSpecificRows(GlobalVars.employeesDBFilePath+GlobalVars.employeesDBFileName,employee);
	}

}
