package com.taxi.notification.exceptions;

public class DuplicateValueException extends RuntimeException{
    public DuplicateValueException(String message) {
        super(message);
    }
}
