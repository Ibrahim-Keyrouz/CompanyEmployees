package com.evaluationfadel.employees.model;


import javax.validation.constraints.Size;  
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Employee  {
	private Integer empId;
	private String name;
	private String familyName;
	private String gender;
	private String age;
	private String startDate;
	private String salary;
	
	public Employee() {
		
	}

	public Employee(Integer empId, String name, String familyName, String gender, String age, String startDate, String salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.familyName = familyName;
		this.gender = gender;
		this.age = age;
		this.startDate = startDate;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
	
}