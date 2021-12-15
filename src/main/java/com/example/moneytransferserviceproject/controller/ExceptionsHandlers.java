package com.example.moneytransferserviceproject.controller;

import com.example.moneytransferserviceproject.exceptions.ErrorConfirmation;
import com.example.moneytransferserviceproject.exceptions.ErrorInputData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandlers {
    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<String> invalidCredentialsEx(ErrorInputData e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ErrorConfirmation.class)
    public ResponseEntity<String> unauthorizedUserEx(ErrorConfirmation e) {
        System.out.println(e.getLocalizedMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
