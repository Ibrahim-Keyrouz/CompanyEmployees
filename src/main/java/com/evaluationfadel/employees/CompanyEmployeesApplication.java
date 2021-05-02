package com.evaluationfadel.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class CompanyEmployeesApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CompanyEmployeesApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CompanyEmployeesApplication.class, args);
	}

}
