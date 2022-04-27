package com.james.cooking.demo.CookingBackend.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpException {
    public NotFoundException(int errorCode, String description) {
        super(errorCode, description);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
