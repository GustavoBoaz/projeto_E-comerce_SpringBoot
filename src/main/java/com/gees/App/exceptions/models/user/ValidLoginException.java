package com.gees.App.exceptions.models.user;

public class ValidLoginException extends RuntimeException {
    
    public ValidLoginException(){
        super("Email or password field is wrong");
    }
}
