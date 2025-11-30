package com.example.learningspringboot.exception;

public class PhoneUniqueException extends BadRequestException {
    public PhoneUniqueException(String message) {
        super(message);
    }
}
