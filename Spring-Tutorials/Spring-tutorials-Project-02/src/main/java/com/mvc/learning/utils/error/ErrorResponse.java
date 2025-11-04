package com.mvc.learning.utils.error;

public class ErrorResponse {

    private Integer errorCode;
    private String errorMessage;
    private String errorDescription;

    public ErrorResponse(Integer errorCode, String errorMessage, String errorDescription) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
