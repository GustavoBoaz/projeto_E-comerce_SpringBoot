package com.gees.App.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ModelError {

    private Long status;
    private String message;
    private String suggestion;
    private @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime errorDate = LocalDateTime.now();

    public ModelError(Long status, String message, String suggestion) {
        this.setStatus(status);
        this.setMessage(message);
        this.setSuggestion(suggestion);
    }

    public LocalDateTime getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(LocalDateTime errorDate) {
        this.errorDate = errorDate;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
    
}
