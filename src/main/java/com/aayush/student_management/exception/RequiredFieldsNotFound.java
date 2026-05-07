package com.aayush.student_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredFieldsNotFound extends RuntimeException {
    public RequiredFieldsNotFound(String message) {
        super(message);
    }
}
