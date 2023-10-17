package com.poc.exception;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */

    ERR_MCS_TUTORIAL_TITLE_EMPTY("Error occurred - Tutorial title shouldn't be NULL or EMPTY"),
    ERR_MCS_TUTORIAL_OBJECT_EMPTY("Error occurred - Tutorial object shouldn't be NULL or EMPTY"),
    ERR_MCS_TUTORIAL_PARAM_NOT_VALID("Error occurred - parameter value is not valid"),
    ERR_MCS_TUTORIAL_NOT_FOUND("Error occurred - no Tutorial found with this id");

    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
