package com.example.learningspringboot.exception;

public class IllegalPriceException extends BadRequestException {
    public IllegalPriceException(String message) {
        super(message);
    }
}
