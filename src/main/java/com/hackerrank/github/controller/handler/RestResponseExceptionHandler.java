package com.hackerrank.github.controller.handler;

import com.hackerrank.github.exception.ActorNotFoundException;
import com.hackerrank.github.exception.EventAlreadyExistsException;
import com.hackerrank.github.exception.EventNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.PessimisticLockException;

/**
 * Created by guilherme-lima on 23/01/19.
 * https://github.com/guilherme-lima
 */
@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EventAlreadyExistsException.class)
    public ResponseEntity eventAlreadyExistsExceptionHandler(EventAlreadyExistsException ex)  {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EventNotFoundException.class)
    public ResponseEntity eventNotFoundExceptionHandler(EventAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ActorNotFoundException.class)
    public ResponseEntity actorNotFoundExceptionHandler(ActorNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PessimisticLockException.class)
    public ResponseEntity pessimisticLockExceptionHandler(PessimisticLockException ex) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}