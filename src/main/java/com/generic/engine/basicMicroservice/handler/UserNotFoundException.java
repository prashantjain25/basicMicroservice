package com.generic.engine.basicMicroservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice //changes the behaviour of the controller
public class UserNotFoundException extends Exception {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User does not exist for the query made")
    public void handleException(Exception ex) {
        
    }
}
