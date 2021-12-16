package com.ravi.springexceptionhandling.exception;

public class OrderNotFoundException extends Exception{

    public OrderNotFoundException(String message) {
        super(message);
    }
}
