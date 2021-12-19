package com.gees.App.exceptions.models.user;

public class ErrorInLoginException extends RuntimeException {
    
    public ErrorInLoginException(String field){
        super("Credentials " + field + " not avaliable");
    }
}
