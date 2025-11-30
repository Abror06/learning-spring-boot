package com.example.learningspringboot.exception;

import org.aspectj.weaver.ast.Not;

public class PaymentNotFoundException extends NotFoundException {
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
