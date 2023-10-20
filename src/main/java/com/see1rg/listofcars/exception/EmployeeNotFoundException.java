package com.see1rg.listofcars.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Employee is not found in database");
    }
}
