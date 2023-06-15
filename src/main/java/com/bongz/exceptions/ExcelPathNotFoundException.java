package com.bongz.exceptions;

public class ExcelPathNotFoundException extends InvalidPathForFilesException{

    public ExcelPathNotFoundException(String message) {
        super(message);
    }

    public ExcelPathNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
