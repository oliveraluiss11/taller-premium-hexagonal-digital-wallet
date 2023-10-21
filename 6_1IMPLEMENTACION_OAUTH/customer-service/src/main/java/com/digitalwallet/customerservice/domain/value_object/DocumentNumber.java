package com.digitalwallet.customerservice.domain.value_object;

import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

public record DocumentNumber(String value) {
    public DocumentNumber(String value) {
        this.value = value;
        CustomerUtils.ensureIsNotNullOrBlank("Document number", value);
        this.ensureDocumentNumber(value);
    }

    private void ensureDocumentNumber(String value) {
        if (!value.matches("^[0-9]{8}$"))
            throw new DigitalWalletGenericClientException("Document number is invalid", HttpStatus.BAD_REQUEST);
    }
}
