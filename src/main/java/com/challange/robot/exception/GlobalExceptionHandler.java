package com.challange.robot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<ApiErrorModel> handleRuntimeException(RuntimeException e) {
        return handleException(e, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ApiErrorModel> handleException(Exception e, HttpStatus httpStatus) {
        LOGGER.error(e.getMessage(), e);
        ApiErrorModel apiErrorModel = new ApiErrorModel(httpStatus, e.getMessage());
        return new ResponseEntity<>(apiErrorModel, httpStatus);
    }
}
