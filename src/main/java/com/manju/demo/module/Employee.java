package com.manju.demo.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empId")
	private long empId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="role")
	private String role;
	
	@Column(name="city")
	private String city;
	
	@Column(name="phone")
	private String phone;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Employee(long empId, String name, String mail, String role, String city, String phone) {
		super();
		this.empId = empId;
		this.name = name;
		this.mail = mail;
		this.role = role;
		this.city = city;
		this.phone = phone;
	}

	public Employee() {
		super();
	}

	
	
}
