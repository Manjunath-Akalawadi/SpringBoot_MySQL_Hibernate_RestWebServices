package com.manju.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.manju.demo.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	//Here you should implement the services which you created in Employee.services
	
	

	@Autowired
	JdbcTemplate jdbc;

	// Featch all employees in the table
	@Override
	public List<Map<String, Object>> getAllEmployeeDetails() {

		List<Map<String, Object>> empDetails = null;

		try {
			
			//here you can execute any complex queries according to output
			String sql = "select * from demo.employee;";

			empDetails = jdbc.queryForList(sql);

		} catch (Exception e) {

			// For any type of exceptions I am printing null value
			return empDetails = null;
		}

		return empDetails;

	}

	// Featch all perticular employee in the table
	@Override
	public List<Map<String, Object>> getEmployeeDetails(long empId) {

		List<Map<String, Object>> empDetails = null;

		try {

			String sql = "select * from demo.employee where empId=?;";

			empDetails = jdbc.queryForList(sql, empId);

		} catch (Exception e) {

			// For any type of exceptions I am printing null value
			return empDetails = null;
		}

		return empDetails;

	}

	// Add new employee to table
	@Override
	public String addEmployee(long empId, String name, String mail, String role, String city, String phone) {

		try {

			String sql = "INSERT INTO demo.employee" + "(empId, name, mail, role, city,phone)"
					+ " VALUES (?, ?, ?, ?, ?,?);";
			jdbc.update(sql, empId, name, mail, role, city, phone);

		} catch (Exception e) {

			return "Fail to Inserted";

		}

		return "Successfully Inserted";

	}

	@Override
	public String updateEmployee(long empId, String name, String mail, String role, String city, String phone) {
		
		
		try{
			
			
			 String sql = "UPDATE demo.employee SET"
			             +" name=?, mail=?, role=? ,city=?, phone=? WHERE empId=?;";
		    jdbc.update(sql,name,  mail, role, city, phone, empId);
		    
			
		}catch (Exception e) {
			
		    return "Fail to Update";

			
		}
		
		  return "Successfully Updated";
	}

	@Override
	public String deleteEmployee(long empId) {



		try{
			
			
			 String sql = "DELETE FROM demo.employee WHERE empId=?;";
		    jdbc.update(sql, empId);
		    
			
		}catch (Exception e) {
			
		    return "Fail to Delete";

			
		}
		
		  return "Successfully Deleted";
}
}