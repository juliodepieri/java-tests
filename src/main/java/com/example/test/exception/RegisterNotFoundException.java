package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RegisterNotFoundException extends RuntimeException {

    public RegisterNotFoundException(String message) {
        super(message);
    }

}
