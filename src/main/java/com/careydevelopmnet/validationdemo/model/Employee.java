package com.careydevelopmnet.validationdemo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {

	private String employeeId;
	
	@NotNull
	@Size(min=1, max=32, message="First name must be between 1 and 32 characters")
	private String firstName;
	
	@NotNull
	@Size(min=1, max=32, message="Last name must be between 1 and 32 characters")
	private String lastName;
	
	@NotNull
	@Pattern(regexp = "^[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$", message="SSN must use numbers in this format: XXX-YY-ZZZZ")
	private String ssn;

	@NotNull
	@Min(10)
	@Max(40)
	private Integer hoursPerWeek;
	
	private String department;
	private String imageFile;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getHoursPerWeek() {
		return hoursPerWeek;
	}
	public void setHoursPerWeek(Integer hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}	
}
