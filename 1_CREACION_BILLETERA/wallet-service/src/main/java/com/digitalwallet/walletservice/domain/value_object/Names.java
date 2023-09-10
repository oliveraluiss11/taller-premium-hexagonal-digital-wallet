package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record Names(String value) {
    public Names(String value) {
        this.value = value;
        this.ensureIsValidName(value);
    }
    private void ensureIsValidName(String value) {
        if (!value.matches("^[A-Za-z'\\s]+([A-Za-z'\\s]+)*$"))
            throw new WalletGenericClientException("Names is invalid"
                    , HttpStatus.BAD_REQUEST);
    }
}
