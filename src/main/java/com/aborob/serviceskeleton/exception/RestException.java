package com.aborob.serviceskeleton.exception;

public abstract class RestException extends Exception {

    public RestException(String message) {

        super(message);
    }
}
