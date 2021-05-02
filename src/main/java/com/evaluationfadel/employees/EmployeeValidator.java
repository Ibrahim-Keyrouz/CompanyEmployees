package com.evaluationfadel.employees;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.evaluationfadel.employees.model.Employee;
@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		 Employee employee = (Employee)target;
		 String name = employee.getName();
		 String familyName = employee.getFamilyName();
		 String gender = employee.getGender();
		 String age = employee.getAge();
		 String startDate = employee.getStartDate();
		 String salary = employee.getSalary();
		 
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Field 'Name' cannot be empty");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "familyName", "Field 'Family Name' cannot be empty");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "Field 'Age' cannot be empty");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "Field 'Start Date' cannot be empty");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "Field 'Salary' cannot be empty");
		 
		 /////check if name and familyname contain nbrs
		 
		
		    
		    for(char c : name.toCharArray()){
		        if(Character.isDigit(c)){
		        	errors.rejectValue("name","Field 'Name' must not contain any number");
		            break;
		        } 
		    }
		    
		    
		    for(char c : familyName.toCharArray()){
		        if(Character.isDigit(c)){
		        	errors.rejectValue("familyName","Field 'Family Name' must not contain any number");
		            break;
		        } 
		    }
		 if (gender != null && !gender.contentEquals("")) {
		 if (!gender.contentEquals("M") && !gender.contentEquals("F")) {
			 errors.rejectValue("gender","Field 'Gender' is not mandatory but must be 'M' or 'F'");
		 }
		 }
		 
		 try {
		        if (age != null && !age.contentEquals(""))
			 Integer.parseInt(age);
		    }
		    catch(NumberFormatException e) {
		    	errors.rejectValue("age","Field 'Age' must not contain a character");
		    }
		 
		 
		 try {
			  if (salary != null && !salary.contentEquals(""))
		        Double.parseDouble(salary);
		    }
		    catch(NumberFormatException e) {
		    	errors.rejectValue("salary","Field 'Salary' must not contain a character");
		    }
		 
		 DateFormat dtformat = new SimpleDateFormat("dd-MMM-yyyy");
		 try {
			
			if (dtformat.parse("01-JAN-2018").compareTo(dtformat.parse(startDate)) > 0 ) {
				errors.rejectValue("startDate","Field 'Start Date' must be > 2018");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		
		 
	}

}
