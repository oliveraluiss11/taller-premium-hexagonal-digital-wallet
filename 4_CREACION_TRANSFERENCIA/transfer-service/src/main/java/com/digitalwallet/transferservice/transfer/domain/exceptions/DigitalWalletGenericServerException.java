package com.digitalwallet.transferservice.transfer.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class DigitalWalletGenericServerException extends RuntimeException{
    private HttpStatus httpStatus;
    private String code;
    public DigitalWalletGenericServerException(String message){
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
    public DigitalWalletGenericServerException(String message, String code){
        super(message);
        this.code = code;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
