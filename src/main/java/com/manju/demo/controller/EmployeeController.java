package com.manju.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manju.demo.services.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeServ;
	
	
	
	//Featch all employees in the table
	@RequestMapping(value="/getAllEmployeeDetails",method = RequestMethod.GET)
	public List<Map<String, Object>>  getUserDetails(){

		List<Map<String, Object>>result=null;
		
		try{
			
			
			result=employeeServ.getAllEmployeeDetails();

			
		}catch (Exception e) {
			

			// For any type of exceptions I am printing null value 
			return result=null;
			
		}
			
			return result;
	}
	
	
	
	//Featch all perticular employee in the table
	@RequestMapping(value="/getEmployeeDetails",method = RequestMethod.POST)
	public List<Map<String, Object>>  getEmployeeDetails(@RequestBody Map<String,String> paramater){
		
		long empId=Long.parseLong(paramater.get("empId"));

		List<Map<String, Object>>result=null;
		
		try{
			
			
			result=employeeServ.getEmployeeDetails(empId);

			
		}catch (Exception e) {
			

			// For any type of exceptions I am printing null value 
			return result=null;
			
		}
			
			return result;
	}
	
	
	
	// Add new employee to table
	@RequestMapping(value="/addEmployee",method = RequestMethod.POST)
	public String addEmployee(@RequestBody Map<String,String> paramater){
		
		String result=null;
		
		try{
			
			long empId=Long.parseLong(paramater.get("empId"));
			String name=paramater.get("name");
			String mail=paramater.get("mail");
			String role=paramater.get("role");
			String city=paramater.get("city");
			String phone=paramater.get("phone");


			result= employeeServ.addEmployee(empId, name, mail, role, city, phone);

		}catch (Exception e) {
		
				return " Exception in Controller ";
		
		}
		
		
		return result;
		
	}
	
	
	
	
	@RequestMapping(value="/updateEmployee",method = RequestMethod.POST)
	//@Procedure(MediaType.APPLICATION_JSON)
	public String updateEmployee(@RequestBody Map<String,String> paramater){
		
		String result=null;
		
		try{
			
			long empId=Long.parseLong(paramater.get("empId"));
			String name=paramater.get("name");
			String mail=paramater.get("mail");
			String role=paramater.get("role");
			String city=paramater.get("city");
			String phone=paramater.get("phone");

			
			result= employeeServ.updateEmployee(empId, name, mail, role, city, phone);
			
			
		}catch (Exception e) {
		
				return " Exception ";
		
		}
		
		
		return result;
		
	}
	
	
	
	@RequestMapping(value="/deleteEmployee",method = RequestMethod.POST)
	//@Procedure(MediaType.APPLICATION_JSON)
	public String deleteEmployee(@RequestBody Map<String,String> paramater){
		
		String result=null;
		
		try{
			
			long empId=Long.parseLong(paramater.get("empId"));
			
			
			result= employeeServ.deleteEmployee(empId);
			
			
		}catch (Exception e) {
		
				return " Exception ";
		
		}
		
		
		return result;
		
	}
	

	

}
