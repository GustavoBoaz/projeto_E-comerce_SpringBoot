package com.gees.App.exceptions.models.user;

public class ErrorInTokenException extends RuntimeException {
    
    public ErrorInTokenException(){
        super("Invalid credential token");
    }
}
