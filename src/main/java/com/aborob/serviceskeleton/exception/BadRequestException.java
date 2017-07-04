package com.aborob.serviceskeleton.exception;

public class BadRequestException extends RestException {


    public BadRequestException(String message) {
        super(message);
    }
}
