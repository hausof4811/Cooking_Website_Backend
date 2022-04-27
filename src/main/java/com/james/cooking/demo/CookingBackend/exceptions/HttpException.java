package com.james.cooking.demo.CookingBackend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class HttpException extends RuntimeException {
    @Getter
    private final ApiErrorResponse errorResponse;

    public HttpException(int errorCode, String description) {
        super(description);
        errorResponse = new ApiErrorResponse(getHttpStatus(), errorCode, description);
    }

    public abstract HttpStatus getHttpStatus();
}
