package com.digitalwallet.authenticationservice.domain.value_objects;

import com.digitalwallet.authenticationservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

public record Pin(String value) {
    public Pin(String value) {
        this.value = value;
        CustomerUtils.ensureIsNotNullOrBlank("Pin", value);
        this.ensureIsValidPin(value);
    }
    private void ensureIsValidPin(String value) {
        if (value.matches(".*[a-zA-ZáéíóúñÁÉÍÓÚÑ.-].*"))
            throw new DigitalWalletGenericClientException("Pin is invalid"
                    , HttpStatus.BAD_REQUEST);

        if (!value.matches("^\\d{6}$"))
            throw new DigitalWalletGenericClientException("Invalid pin, must be 6 digits"
                    , HttpStatus.BAD_REQUEST);
    }
}
