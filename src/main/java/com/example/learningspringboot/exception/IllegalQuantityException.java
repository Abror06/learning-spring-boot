package com.example.learningspringboot.exception;

public class IllegalQuantityException extends RuntimeException {
    public IllegalQuantityException(String message) {
        super(message);
    }
}
