package com.example.learningspringboot.exception;

public class CategoryUniqueExecption extends RuntimeException {
    public CategoryUniqueExecption(String message) {
        super(message);
    }
}
