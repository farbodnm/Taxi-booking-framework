package com.taxi.notification.exceptions;

import com.taxi.framework.notification.controller.dto.MessageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new MessageResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(DuplicateValueException.class)
    public ResponseEntity<MessageResponseDTO> handleEntityNotFoundException(DuplicateValueException ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                new MessageResponseDTO(ex.getMessage()));
    }
}
