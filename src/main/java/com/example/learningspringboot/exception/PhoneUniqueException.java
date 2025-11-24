package com.example.learningspringboot.exception;

public class PhoneUniqueException extends RuntimeException {
    public PhoneUniqueException(String message) {
        super(message);
    }
}
