package com.see1rg.listofcars.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User is not found in database");
    }
}
