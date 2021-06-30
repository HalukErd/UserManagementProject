package com.avansas.UserManagementProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
public class UserEntityNotSavedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(UserEntityNotSavedException.class)
    public void handleException() {

    }
}
