package com.appsdeveloperblog.app.ws.mobile_app_ws.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class AppExceptionsHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail handlerSecurityException(Exception ex) {
        ProblemDetail errorDetail = null;

        if (ex instanceof BadCredentialsException) {
            errorDetail = ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(401), ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Authentication Failure.");
        }

        if (ex instanceof AccessDeniedException) {
            errorDetail = ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(403), ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Not authorized.");
        }

        return errorDetail;
    }
}