package com.snowcoder.onlinestore.enums;

public enum ApiErrorEnums {

    UNEXPECTED_ERROR("Unexpected_Error");

    private String apiErrorCode;

    ApiErrorEnums(String apiErrorCode) {
        setApiErrorCode(apiErrorCode);
    }

    public String getApiErrorCode() {
        return apiErrorCode;
    }

    public void setApiErrorCode(String apiErrorCode) {
        this.apiErrorCode = apiErrorCode;
    }
}
