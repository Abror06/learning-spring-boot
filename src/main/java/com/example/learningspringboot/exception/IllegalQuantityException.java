package com.example.learningspringboot.exception;

public class IllegalQuantityException extends BadRequestException {
    public IllegalQuantityException(String message) {
        super(message);
    }
}
