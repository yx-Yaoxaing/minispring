package org.mini.spring.exception;


public class NumberException extends SystemException {


    public NumberException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
