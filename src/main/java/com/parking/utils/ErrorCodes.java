package com.parking.utils;

public enum ErrorCodes {
    CREATE_PARKING_ERROR_CODE("ERR001"),
    INVALID_COMMAND_ERROR_CODE("ERR002"),
    PARKING_NOT_CREATED("ERR003");
    private String code;

    ErrorCodes(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
