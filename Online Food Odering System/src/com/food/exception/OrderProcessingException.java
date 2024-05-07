package com.food.exception;

public class OrderProcessingException extends RuntimeException{
    public OrderProcessingException(String message) {
        super(message);
    }
}
