package com.taxi.notification.exceptions;

public class UserNotFoundException extends ResourceNotFoundException{
    public UserNotFoundException(Long id) {
        super("User with ID: %d is not found".formatted(id));
    }
}
