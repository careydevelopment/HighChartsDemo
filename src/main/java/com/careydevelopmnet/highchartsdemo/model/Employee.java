package com.careydevelopmnet.highchartsdemo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {

    @Size(min=1, max=32, message="First name must be between 1 and 32 characters")
    private String firstName;
    
    @Size(min=1, max=32, message="Last name must be between 1 and 32 characters")
    private String lastName;
    
    @NotNull(message="Please enter an SSN")
    @Pattern(regexp = "^[0-9][0-9]{2}-[0-9]{2}-[0-9]{4}$", message="SSN must use numbers in this format: XXX-YY-ZZZZ")
    private String ssn;
    
    @NotNull(message="Please enter a number of hours per week")
    @Min(10)
    @Max(40)
    private Integer hoursPerWeek;
    
    @NotNull
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
    private String emailAddress;
    
    @NotNull
    @Pattern(regexp="^(?=\\s*\\S).*$", message="Please select a department")
    private String department;
    
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
    
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }		
}
