package com.aborob.serviceskeleton.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value =
            {IllegalArgumentException.class, IllegalStateException.class, ResourceConflictException.class})
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {

        log.info(ex.getMessage());
        return handleExceptionInternal(ex, new ErrorResponse(
                        HttpStatus.CONFLICT.value(), "Bad request or wrong info"),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, BadRequestException.class})
    protected ResponseEntity<Object> handleBad(Exception ex, WebRequest request) {

        log.info(ex.getMessage());
        return handleExceptionInternal(ex, new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(), "Bad request or wrong info"),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return handleBad(ex, request);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundError(Exception ex, WebRequest request) {

        log.info(ex.getMessage());
        return handleExceptionInternal(ex, new ErrorResponse(
                        HttpStatus.NOT_FOUND.value(), "Not found"),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleError(Exception ex, WebRequest request) {

        log.error(ex.getMessage(), ex);
        return handleExceptionInternal(ex, new ErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal error"),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
