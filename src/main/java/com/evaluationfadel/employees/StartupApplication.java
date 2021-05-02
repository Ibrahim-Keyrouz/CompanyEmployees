package com.evaluationfadel.employees;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StartupApplication implements InitializingBean {
	@Autowired
	private Environment env;

	public StartupApplication() {
		System.out.println("Hello World");
		new GlobalVars();
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
		GlobalVars.employeesDBFilePath = env.getProperty("x.env.variables.employeesdbfilepath");
	
		GlobalVars.employeesDBFileName = env.getProperty("x.env.variables.employeesdbfilename");
		try {
			
			File dir = new File(GlobalVars.employeesDBFilePath);
			if (!dir.isDirectory()) {
				dir.mkdir();
			}
			File employeesDbFile = new File(GlobalVars.employeesDBFilePath+GlobalVars.employeesDBFileName);
			if (!employeesDbFile.exists()) {
				if (employeesDbFile.createNewFile()) {
					System.out.println("File created: " + employeesDbFile.getName());
				} 

			}
			else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		System.out.println("All global variables are set");
	}

}
