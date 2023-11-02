package com.digitalwallet.customerservice.domain.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class DigitalWalletGlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DigitalWalletError> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        return new ResponseEntity<>(new DigitalWalletError(HttpStatus.BAD_REQUEST
                , "Los valores ingresados son incorrectos"
                , errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DigitalWalletGenericClientException.class)
    public ResponseEntity<DigitalWalletError> handleClientGenericError(DigitalWalletGenericClientException ex) {
        HttpStatus status = ex.getHttpStatus();
        String message = ex.getMessage();
        DigitalWalletError digitalWalletError = new DigitalWalletError(status, message);
        if (ex.getCode() != null || !"".equals(ex.getCode())) {
            digitalWalletError = new DigitalWalletError(status, message, ex.getCode());
        }
        return new ResponseEntity<>(digitalWalletError, digitalWalletError.getStatus());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<DigitalWalletError> handleConstraintViolation(
            ConstraintViolationException ex) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage());
        }
        DigitalWalletError error = new DigitalWalletError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<DigitalWalletError>(
                error, error.getStatus());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<DigitalWalletError> handleAll(Exception ex, WebRequest request) {
        DigitalWalletError error = new DigitalWalletError(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
        return new ResponseEntity<DigitalWalletError>(
                error, new HttpHeaders(), error.getStatus());
    }
}
