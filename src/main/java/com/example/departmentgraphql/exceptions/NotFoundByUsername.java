package com.example.departmentgraphql.exceptions;

public class NotFoundByUsername extends RuntimeException{
    public NotFoundByUsername(String message) {
        super(message);
    }
}
