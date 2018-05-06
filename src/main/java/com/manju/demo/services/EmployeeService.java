package com.manju.demo.services;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	
	
	//here you can create  the services according to your web or moblie application
	

		//Featch all perticular employee in the table
		List<Map<String, Object>> getEmployeeDetails(long empId);
		
		
		//Featch all employees in the table
		List<Map<String, Object>> getAllEmployeeDetails();
		
		// Add new employee to table
		String addEmployee(long empId, String name, String mail, String role, String city, String phone);
		
		// Update existing employee in the table
		String updateEmployee(long empId, String name, String mail, String role, String city , String phone);
		
		// delete existing employee in table
		String deleteEmployee(long empId);

}
