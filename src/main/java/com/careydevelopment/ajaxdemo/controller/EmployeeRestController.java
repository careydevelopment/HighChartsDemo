package com.careydevelopment.ajaxdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careydevelopmnet.ajaxdemo.model.Employee;
import com.careydevelopmnet.ajaxdemo.model.RestResponse;

@RestController
public class EmployeeRestController {

	@RequestMapping("/employee/{employeeId}")
	public RestResponse singleEmployee(@PathVariable String employeeId) {
		//instantiate the response object
		RestResponse response = new RestResponse();
		
		//set the employee to null
		Employee returnedEmployee = null;
		
		//grab all employees
		List<Employee> allEmployees = getAllEmployees();
		
		//look for a match
		for (Employee employee : allEmployees) {
			if (employee.getEmployeeId().equals(employeeId)) {
				returnedEmployee = employee;
				break;
			}
		}
		
		if (returnedEmployee == null) {
			//the URL contains an unknown employee id - we'll return an empty response
			response.setResponseStatus(RestResponse.NOT_FOUND);
			response.setResponse("");
		} else {
			//good response if we get here
			response.setResponseStatus(RestResponse.OK);
			response.setResponse(returnedEmployee);
		}
		
		return response;
	}
	
	
	@RequestMapping("/employees")
	public RestResponse allEmployees() {
		//instantiate the response object
		RestResponse response = new RestResponse();
		
		//retrieve list of employees
		List<Employee> allEmployees = getAllEmployees();		
		
		//make sure we've got employees
		if (allEmployees != null && allEmployees.size() > 0) {
			response.setResponseStatus(RestResponse.OK);
			
			//put the list in the response object
			response.setResponse(allEmployees);
		} else {
			response.setResponseStatus(RestResponse.NOT_FOUND);
			response.setResponse(new ArrayList<Employee>());
		}
		
		return response;
	}
	
	//returns a list of all employees
	private List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<Employee>();
		
		Employee emp1 = new Employee();
		emp1.setDepartment("Accounting");
		emp1.setEmployeeId("A552");
		emp1.setFirstName("Danny");
		emp1.setLastName("DeVito");
		emp1.setHoursPerWeek(40);
		allEmployees.add(emp1);
		
		Employee emp2 = new Employee();
		emp2.setDepartment("Marketing");
		emp2.setEmployeeId("B112");
		emp2.setFirstName("Darth");
		emp2.setLastName("Vader");
		emp2.setHoursPerWeek(30);
		allEmployees.add(emp2);
		
		Employee emp3 = new Employee();
		emp3.setDepartment("Shipping");
		emp3.setEmployeeId("C997");
		emp3.setFirstName("Roger");
		emp3.setLastName("Rabbit");
		emp3.setHoursPerWeek(40);
		allEmployees.add(emp3);

		Employee emp4 = new Employee();
		emp4.setDepartment("Finance");
		emp4.setEmployeeId("A703");
		emp4.setFirstName("John");
		emp4.setLastName("Legend");
		emp4.setHoursPerWeek(20);
		allEmployees.add(emp4);

		return allEmployees;
	}
}
