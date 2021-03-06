package com.evaluationfadel.employees.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.evaluationfadel.employees.model.Employee;

public class IOFunctions {

	public static List<Employee> readFile(String filePath) {
		try {
			File employeeDBFile = new File(filePath);
			Scanner myReader = new Scanner(employeeDBFile);
			List<Employee> lstEmployee = new ArrayList<>();
			String[] employeeRow;

			while (myReader.hasNextLine()) {
				employeeRow = myReader.nextLine().split(",");
				Employee employee = new Employee();
				employee.setEmpId(Integer.parseInt(employeeRow[0]));
				employee.setName(employeeRow[1]);
				employee.setFamilyName(employeeRow[2]);
				employee.setGender(employeeRow[3]);
				employee.setAge(employeeRow[4]);
				employee.setStartDate(employeeRow[5]);
				employee.setSalary(employeeRow[6]);

				lstEmployee.add(employee);
			}
			myReader.close();
			return lstEmployee;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return null;
		}

	}

	public static void deleteRowInFile(String filename, Integer empId) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			// String buffer to store contents of the file
			StringBuffer sb = new StringBuffer("");

			// Keep track of the line number

			String line;

			while ((line = br.readLine()) != null) {
				// Store each valid line in the string buffer
				if (!line.startsWith(empId + ","))
					sb.append(line + "\n");

			}

			br.close();

			FileWriter fw = new FileWriter(new File(filename));
			// Write entire string buffer into the file
			fw.write(sb.toString());
			fw.close();
		} catch (Exception e) {
			System.out.println("Something went horribly wrong: " + e.getMessage());
		}
	}

	public static void insertRowInFile(String filename, Employee emp) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter(new File(filename), true);
			// Write entire string buffer into the file
			if (emp.getGender() == null || emp.getGender().contentEquals("")) {
				fw.write(emp.getEmpId() + "," + emp.getName() + "," + emp.getFamilyName() + "," + "," + emp.getAge()
						+ "," + emp.getStartDate() + "," + emp.getSalary() + "\n");
			} else {
				fw.write(emp.getEmpId() + "," + emp.getName() + "," + emp.getFamilyName() + "," + emp.getGender() + ","
						+ emp.getAge() + "," + emp.getStartDate() + "," + emp.getSalary() + "\n");
			}

			fw.close();

		} catch (Exception e) {
			System.out.println("Something went horribly wrong: " + e.getMessage());
		}
	}

	public static List<Employee> fetchSpecificRows(String dbFile, Employee employee) {

		List<Employee> lstEmployee = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(dbFile));

			String line;
			String[] employeeRow = null;

			while ((line = br.readLine()) != null) {
				// Store each valid line in the string buffer
				employeeRow = line.split(",");
				Employee fetchedEmployee = new Employee();
				fetchedEmployee.setEmpId(Integer.parseInt(employeeRow[0]));
				fetchedEmployee.setName(employeeRow[1]);
				fetchedEmployee.setFamilyName(employeeRow[2]);
				if (employeeRow[3] != null && !employeeRow[3].contentEquals("")) {
					fetchedEmployee.setGender(employeeRow[3]);
				}else {
					fetchedEmployee.setGender("");
				}

				fetchedEmployee.setAge(employeeRow[4]);
				fetchedEmployee.setStartDate(employeeRow[5]);
				fetchedEmployee.setSalary(employeeRow[6]);
				
				
				
				if ((employee.getName() == null || employee.getName().contentEquals("") || fetchedEmployee.getName().contentEquals(employee.getName()) )
						&& (employee.getFamilyName() == null || employee.getFamilyName().contentEquals("") || fetchedEmployee.getFamilyName().contentEquals(employee.getFamilyName()) )

						&& (fetchedEmployee.getGender().contentEquals(employee.getGender()) )

						&& (employee.getAge() == null || employee.getAge().contentEquals("") || fetchedEmployee.getAge().contentEquals(employee.getAge()) )

						&& (employee.getStartDate() == null || employee.getStartDate().contentEquals("") || fetchedEmployee.getStartDate().contentEquals(employee.getStartDate()) )

						&& (employee.getSalary() == null || employee.getSalary().contentEquals("") || fetchedEmployee.getSalary().contentEquals(employee.getSalary()) )

				) {

			
					

					lstEmployee.add(fetchedEmployee);
				}
			}

			br.close();

		} catch (Exception e) {
			System.out.println("Something went horribly wrong: " + e.getMessage());
		}
		return lstEmployee;
	}

}
