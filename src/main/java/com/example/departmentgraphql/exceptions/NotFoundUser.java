package com.example.departmentgraphql.exceptions;

public class NotFoundUser extends RuntimeException{
    public NotFoundUser(String message) {
        super(message);
    }
}
