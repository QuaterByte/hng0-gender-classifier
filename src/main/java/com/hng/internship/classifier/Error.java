package com.hng.internship.classifier;

public class Error {

    private String status;
    private String message;

    public Error(String message){
        this.status = "error";
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
