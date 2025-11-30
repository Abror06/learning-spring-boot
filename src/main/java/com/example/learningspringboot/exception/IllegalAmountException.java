package com.example.learningspringboot.exception;

public class IllegalAmountException extends BadRequestException {
    public IllegalAmountException(String message) {
        super(message);
    }
}
