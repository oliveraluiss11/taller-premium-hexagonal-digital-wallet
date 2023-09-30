package com.digitalwallet.customerservice.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalWalletError {
    private HttpStatus status;
    private String message;
    private final LocalDateTime timestamp = LocalDateTime.now();
    private List<String> errors;
    private String code;

    public DigitalWalletError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
    public DigitalWalletError(HttpStatus status, String message, List<String> errors, String code) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.code = code;
    }
    public DigitalWalletError(HttpStatus status, String message, String code) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
    }
    public DigitalWalletError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }


}
