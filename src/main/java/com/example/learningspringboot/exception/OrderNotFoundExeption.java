package com.example.learningspringboot.exception;

public class OrderNotFoundExeption extends RuntimeException {
    public OrderNotFoundExeption(String message) {
        super(message);
    }
}
