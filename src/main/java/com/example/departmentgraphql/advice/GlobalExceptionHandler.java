package com.example.departmentgraphql.advice;

import com.example.departmentgraphql.exceptions.NotFoundById;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundById.class})
    public ResponseEntity<Object> handleNotFoundById(NotFoundById notFoundById){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notFoundById.getMessage());
    }
}
