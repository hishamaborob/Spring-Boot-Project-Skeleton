package com.aborob.serviceskeleton.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH)
    ResponseEntity<ErrorResponse> error(HttpServletRequest request, HttpServletResponse response) {

        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse(response.getStatus(), "Error"),
                HttpStatus.valueOf(response.getStatus()));
    }
}
