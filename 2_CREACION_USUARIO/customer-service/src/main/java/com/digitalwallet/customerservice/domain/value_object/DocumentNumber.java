package com.digitalwallet.customerservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

public record DocumentNumber(String value) {
    public DocumentNumber(String value) {
        this.value = value;
        this.ensureDocumentNumber(value);
    }

    private void ensureDocumentNumber(String value) {
        if (!value.matches("^[0-9]{8}$"))
            throw new WalletGenericClientException("Document number is invalid", HttpStatus.BAD_REQUEST);
    }
}
