package com.gees.App.exceptions.models.user;

public class ExistingEmailException extends RuntimeException {
    
    public ExistingEmailException(String existingEmail){
        super(existingEmail + " email existing in the system");
    }
}
