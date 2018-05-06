package com.manju.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.manju.demo.module.Employee;

public interface EmployeeRepo extends  CrudRepository<Employee, Long> {
	

}
