package com.digitalwallet.customerservice.domain.value_object;

import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

public record Email(String value) {
    public Email(String value) {
        this.value = value;
        CustomerUtils.ensureIsNotNullOrBlank("Email", value);
        this.ensureIsValidEmail(value);
    }
    private void ensureIsValidEmail(String value) {
        if (!value.matches("[a-zA-Z0-9._%+-]+@(?:hotmail\\.com|gmail\\.com|outlook\\.com)"))
            throw new DigitalWalletGenericClientException("Email is invalid"
                    , HttpStatus.BAD_REQUEST);
    }
}
