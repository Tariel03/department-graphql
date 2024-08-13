package com.example.departmentgraphql.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundById extends RuntimeException{
    public NotFoundById(String message) {
        super(message);
    }
}
