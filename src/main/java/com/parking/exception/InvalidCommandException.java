package com.parking.exception;

import com.parking.utils.ErrorCodes;
import lombok.Data;

@Data
public class InvalidCommandException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public InvalidCommandException(String errorMessage, ErrorCodes errorCode) {
        this.errorCode = errorCode.getCode();
        this.errorMessage = errorMessage;
    }
}