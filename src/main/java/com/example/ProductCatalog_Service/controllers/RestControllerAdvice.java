package com.example.ProductCatalog_Service.controllers;

import com.example.ProductCatalog_Service.exceptions.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exceptions> handleException(Exception ex)
    {
        Exceptions exceptions = new Exceptions();
        exceptions.setMessage("Something went wrong");
        return new ResponseEntity<>(exceptions, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex)
    {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
