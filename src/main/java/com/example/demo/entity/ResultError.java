package com.example.demo.entity;

public class ResultError {
    private String errorCode;//错误码
    private String errorMessage;//错误信息

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        //通过错误码查找错误信息

        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
