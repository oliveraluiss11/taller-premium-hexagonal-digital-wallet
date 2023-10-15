package com.digitalwallet.walletservice.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletError {
    private HttpStatus status;
    private String message;
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String code;

    public WalletError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
    public WalletError(HttpStatus status, String message,String code) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
