package com.azoft.filedownloadservice;

import com.azoft.filedownloadservice.exception.ResourceNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionWrapper> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionWrapper(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ExceptionWrapper> handleIOException(IOException ex) {
        return new ResponseEntity<>(new ExceptionWrapper(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequiredArgsConstructor
    @Getter
    private final static class ExceptionWrapper {
        private final String errorMessage;
    }
}
