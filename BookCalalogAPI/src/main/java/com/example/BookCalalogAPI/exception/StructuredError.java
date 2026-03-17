package com.example.BookCalalogAPI.exception;

public record StructuredError(String message, ErrorType type) {
}
