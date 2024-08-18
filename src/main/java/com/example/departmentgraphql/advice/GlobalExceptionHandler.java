package com.example.departmentgraphql.advice;

import com.example.departmentgraphql.exceptions.NotFoundById;
import com.example.departmentgraphql.exceptions.NotFoundByUsername;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundById.class})
    public ResponseEntity<Object> handleNotFoundById(NotFoundById notFoundById){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundById.getMessage());
    }
    @ExceptionHandler({NotFoundByUsername.class})
    public ResponseEntity<Object> handleNotFoundByUsername(NotFoundByUsername notFoundByUsername){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundByUsername.getMessage());
    }
}
