package com.gees.App.exceptions.models.user;

public class ErrorInRegistrationException extends RuntimeException {
    
    public ErrorInRegistrationException(){
        super("Invalid name, email or password");
    }
}
