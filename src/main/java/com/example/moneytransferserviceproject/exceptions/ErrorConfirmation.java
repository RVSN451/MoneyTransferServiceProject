package com.example.moneytransferserviceproject.exceptions;

public class ErrorConfirmation extends RuntimeException{
    public ErrorConfirmation(String msg){
        super(msg);
    }
}
