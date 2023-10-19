package com.see1rg.listofcars.exception;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.slf4j.LoggerFactory.getLogger;

@RestControllerAdvice
public class CustomExceptionHandler {

    Logger log = getLogger(CustomExceptionHandler.class);


    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleAccountNotFoundException(UserNotFoundException ex) {
        log.error("User not found");
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}

