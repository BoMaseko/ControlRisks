package com.bongz.exceptions;

public class PropertyUtilRuntimeException extends InvalidPathForFilesException{
    public PropertyUtilRuntimeException(String message) {
        super(message);
    }

    public PropertyUtilRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
