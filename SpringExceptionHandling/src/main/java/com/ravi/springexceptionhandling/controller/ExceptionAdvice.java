package com.ravi.springexceptionhandling.controller;

import com.ravi.springexceptionhandling.exception.OrderNotFoundException;
import com.ravi.springexceptionhandling.model.Order;
import com.ravi.springexceptionhandling.model.OrderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<OrderError> mapException(OrderNotFoundException ex){
        OrderError orderError = new OrderError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<OrderError>(orderError,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
