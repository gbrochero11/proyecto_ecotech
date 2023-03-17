package com.graphisoft.ecotech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;

import javax.persistence.EntityNotFoundException;
import java.util.concurrent.ConcurrentHashMap;

public class ExceptionStatus {

    ConcurrentHashMap<String, Integer> statusCode;
    public ExceptionStatus() {
        statusCode = new ConcurrentHashMap<>();
        statusCode.put(IllegalArgumentException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        statusCode.put(EntityNotFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        statusCode.put(HttpMessageNotReadableException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }
}
