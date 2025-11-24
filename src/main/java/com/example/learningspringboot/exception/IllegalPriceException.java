package com.example.learningspringboot.exception;

public class IllegalPriceException extends RuntimeException {
    public IllegalPriceException(String message) {
        super(message);
    }
}
