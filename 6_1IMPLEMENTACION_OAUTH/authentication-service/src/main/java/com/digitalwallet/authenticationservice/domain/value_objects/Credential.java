package com.digitalwallet.authenticationservice.domain.value_objects;

import com.digitalwallet.authenticationservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

public record Credential(String value) {
    public Credential(String value) {
        this.value = value;
        CustomerUtils.ensureIsNotNullOrBlank("Credential", value);
        this.ensureDocumentNumber(value);
    }

    private void ensureDocumentNumber(String value) {
        Boolean isDocumentNumber = value.matches("^[0-9]{8}$");
        Boolean isPhoneNumber = value.matches("^?519\\d{8}$");
        if (Boolean.FALSE.equals(isDocumentNumber) &&
                Boolean.FALSE.equals(isPhoneNumber))
            throw new DigitalWalletGenericClientException("Credential is invalid", HttpStatus.BAD_REQUEST);
    }
}
