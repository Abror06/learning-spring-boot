package com.example.learningspringboot.exception;

public class CategoryUniqueExecption extends BadRequestException {
    public CategoryUniqueExecption(String message) {
        super(message);
    }
}
