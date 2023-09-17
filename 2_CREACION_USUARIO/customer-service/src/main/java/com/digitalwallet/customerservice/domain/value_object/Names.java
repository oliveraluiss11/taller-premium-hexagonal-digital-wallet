package com.digitalwallet.customerservice.domain.value_object;

import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

public record Names(String value) {
    public Names(String value) {
        this.value = value;
        this.ensureIsValidName(value);
    }
    private void ensureIsValidName(String value) {
        if (!value.matches("^[A-Za-z'\\s]+([A-Za-z'\\s]+)*$"))
            throw new DigitalWalletGenericClientException("Names is invalid"
                    , HttpStatus.BAD_REQUEST);
    }
}
