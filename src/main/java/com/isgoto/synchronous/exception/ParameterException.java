package com.isgoto.synchronous.exception;

public class ParameterException extends RuntimeException {

    public ParameterException() {
        super();
    }

    public ParameterException(String error){
        super(error);
    }

    public ParameterException(Throwable cause){
        super(cause);
    }
}
