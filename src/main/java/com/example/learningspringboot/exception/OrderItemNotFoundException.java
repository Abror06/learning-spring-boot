package com.example.learningspringboot.exception;

public class OrderItemNotFoundException extends NotFoundException {
    public OrderItemNotFoundException(String message) {
        super(message);
    }
}
