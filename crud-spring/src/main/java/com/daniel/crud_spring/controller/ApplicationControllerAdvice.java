package com.daniel.crud_spring.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.daniel.crud_spring.exception.RecordNotfoundException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RecordNotfoundException.class) // Indica que este método trata a exceção RecordNotfoundException
    @ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND) // Define o status HTTP como 404 Not Found
    public String handleRecordNotFoundException(RecordNotfoundException ex) {
        return ex.getMessage(); // Retorna a mensagem de erro personalizada
    }

}
