package com.james.cooking.demo.CookingBackend.config;

import com.james.cooking.demo.CookingBackend.exceptions.ApiErrorResponse;
import com.james.cooking.demo.CookingBackend.exceptions.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.Executable;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<Object> handleException(
            HttpException ex, WebRequest request) {
        return createErrorResponse(ex.getErrorResponse());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> defaultExceptionHandler(
            Exception ex, WebRequest request) {
        return createErrorResponse(new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, 999, "default error"));
    }

    public static ResponseEntity<Object> createErrorResponse(ApiErrorResponse errorResponse) {
        return new ResponseEntity(errorResponse, HttpStatus.valueOf(errorResponse.getHttpStatusCode()));
    }
}