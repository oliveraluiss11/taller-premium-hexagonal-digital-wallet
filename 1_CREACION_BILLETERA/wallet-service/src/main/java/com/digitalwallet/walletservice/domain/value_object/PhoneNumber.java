package com.digitalwallet.walletservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record PhoneNumber(String value) {
    public PhoneNumber(String value) {
        this.value = value;
        this.ensureIsValidPhoneNumber(value);
    }
    private void ensureIsValidPhoneNumber(String value) {
        if (!value.matches("^?519\\d{8}$"))
            throw new WalletGenericClientException("Phone number is invalid"
                    , HttpStatus.BAD_REQUEST);
    }
}
