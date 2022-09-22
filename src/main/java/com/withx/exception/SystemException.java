package com.withx.exception;

import lombok.Data;

@Data
public class SystemException extends RuntimeException {
    private String code;

    public SystemException(String code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(String code, String message, Throwable caouse) {
        super(message,caouse);
        this.code = code;
    }
}
