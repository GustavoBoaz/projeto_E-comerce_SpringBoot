package com.gees.App.exceptions.manipulators;

import com.gees.App.exceptions.ModelError;
import com.gees.App.exceptions.models.user.ExistingEmailException;
import com.gees.App.exceptions.models.user.ValidLoginException;
import com.gees.App.exceptions.models.user.ErrorInLoginException;
import com.gees.App.exceptions.models.user.ErrorInRegistrationException;
import com.gees.App.exceptions.models.user.ErrorInTokenException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(ExistingEmailException.class)
    public ResponseEntity<ModelError> existingEmailExceptionHandler(ExistingEmailException exception){
        return ResponseEntity.status(422).body(new ModelError(422L, exception.getMessage(), "Try another email"));
    }

    @ExceptionHandler(ErrorInRegistrationException.class)
    public ResponseEntity<ModelError> errorInRegistrationExceptionHandler(ErrorInRegistrationException exception){
        return ResponseEntity.status(400).body(new ModelError(400L, exception.getMessage(), "Fill in the fields correctly"));
    }

    @ExceptionHandler(ErrorInLoginException.class)
    public ResponseEntity<ModelError> errorInLoginExceptionHandler(ErrorInLoginException exception){
        return ResponseEntity.status(401).body(new ModelError(401L, exception.getMessage(), "Provide valid credentials"));
    }
    
    @ExceptionHandler(ValidLoginException.class)
    public ResponseEntity<ModelError> errorvalidInLoginExceptionHandler(ValidLoginException exception){
        return ResponseEntity.status(400).body(new ModelError(400L, exception.getMessage(), "Provide valid credentials"));
    }

    @ExceptionHandler(ErrorInTokenException.class)
    public ResponseEntity<ModelError> errorInvalidTokenExceptionHandler(ErrorInTokenException exception){
        return ResponseEntity.status(401).body(new ModelError(401L, exception.getMessage(), "Provide valid credentials"));
    }
}
