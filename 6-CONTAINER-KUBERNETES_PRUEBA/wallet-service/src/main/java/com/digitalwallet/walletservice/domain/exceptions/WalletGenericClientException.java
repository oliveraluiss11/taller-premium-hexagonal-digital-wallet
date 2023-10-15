package com.digitalwallet.walletservice.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class WalletGenericClientException extends RuntimeException{
    private HttpStatus httpStatus;
    private String code;
    public WalletGenericClientException(String message, HttpStatus status){
        super(message);
        this.httpStatus = status;
    }
    public WalletGenericClientException(String message, String code, HttpStatus status){
        super(message);
        this.code = code;
        this.httpStatus = status;
    }
}
