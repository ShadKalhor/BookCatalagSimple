package com.example.BookCalalogAPI.exception;


public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
