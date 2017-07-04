package com.aborob.serviceskeleton.exception;

public class ResourceNotFoundException extends RestException {


    public ResourceNotFoundException(String message) {
        super(message);
    }
}
