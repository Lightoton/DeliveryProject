package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.exception.ErrorExtension;
import de.telran.deliveryproject.exception.UserInformationNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserInformationNotFoundException.class)
    public ResponseEntity<ErrorExtension> handleUserInfoNotFoundException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage()),
                HttpStatus.NOT_FOUND);

    }
}
