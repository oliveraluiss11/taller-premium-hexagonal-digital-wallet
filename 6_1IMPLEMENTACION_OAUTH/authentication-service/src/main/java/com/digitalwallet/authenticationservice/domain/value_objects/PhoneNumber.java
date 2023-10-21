package com.digitalwallet.authenticationservice.domain.value_objects;

import com.digitalwallet.authenticationservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

public record PhoneNumber(String value) {
    public PhoneNumber(String value) {
        this.value = value;
        CustomerUtils.ensureIsNotNullOrBlank("Phone number", value);
        this.ensureIsValidPhoneNumber(value);
    }

    private void ensureIsValidPhoneNumber(String value) {
        if (!value.matches("^?519\\d{8}$"))
            throw new DigitalWalletGenericClientException("Phone number is invalid"
                    , HttpStatus.BAD_REQUEST);
    }
}
