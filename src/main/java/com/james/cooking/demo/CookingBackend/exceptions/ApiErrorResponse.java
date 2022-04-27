package com.james.cooking.demo.CookingBackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiErrorResponse {

    private int httpStatusCode;
    private String httpStatusReason;
    private int errorCode;
    private String description;

    public ApiErrorResponse(HttpStatus httpStatus, int errorCode, String description) {
        this.httpStatusCode = httpStatus.value();
        this.httpStatusReason = httpStatus.getReasonPhrase();
        this.errorCode = errorCode;
        this.description = description;
    }

}
