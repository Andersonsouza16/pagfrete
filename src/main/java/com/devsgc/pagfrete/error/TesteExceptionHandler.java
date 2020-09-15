package com.devsgc.pagfrete.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class TesteExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleTeste(ResourceNotFoundException exception){
        MensagemErro erro = new MensagemErro(new Date(), exception.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }


}
