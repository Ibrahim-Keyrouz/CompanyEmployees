package com.evaluationfadel.employees.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.evaluationfadel.employees.EmployeeValidator;
import com.evaluationfadel.employees.model.Employee;
import com.evaluationfadel.employees.services.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	 @Autowired
	    EmployeeValidator employeeValidator;

	@RequestMapping(value = "/fetchall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllEmployees(Model model) {

		List<Employee> listEmps = employeeService.getAllEmployees();
		model.addAttribute("listAllEmployees", listEmps);

		model.addAttribute("newemployee", new Employee());

		if (listEmps.size() != 0) {
			model.addAttribute("maxEmpId", listEmps.get(listEmps.size() - 1).getEmpId() + 1);
		} else {
			model.addAttribute("maxEmpId", 1);
		}

		return "view_all_employees";
	}

	@RequestMapping("/deleteemployee/{empId}")
	public String deleteEmployee(@PathVariable(name = "empId") Integer empId, Model model) {

		employeeService.deleteEmployee(empId);
		return "redirect:/employee/fetchall";

	}

	@RequestMapping("/insertemployee")
	public String insertEmployee(@Valid @ModelAttribute("newemployee") Employee employee, BindingResult bindingResult, Model model, RedirectAttributes redirectAtt) {
		System.out.println("Inserting employee");
		System.out.println(employee.getEmpId());

		/*
		 * ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 * Validator validator = factory.getValidator();
		 * Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
		 * 
		 * System.out.println(violations.size());
		 */
		employeeValidator.validate(employee, bindingResult);
		
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			String errorMsg="";
		    for (FieldError error : errors ) {
		    	errorMsg = errorMsg + error.getCode()+"<br/>";
		    }

			model.addAttribute("hasErrors", errorMsg);
			return getAllEmployees(model);
			// return "redirect:/employee/fetchall";
		} else {
			System.out.println("Hello");
			employeeService.insertEmployee(employee);
			return "redirect:/employee/fetchall";
		}

	}
	
	public EmployeeValidator getEmployeeValidator() {
        return employeeValidator;
    }

    public void setEmployeeValidator(EmployeeValidator employeeValidator) {
        this.employeeValidator = employeeValidator;
    }

}
