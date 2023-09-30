package com.digitalwallet.transferservice.transfer.domain.value_object;

import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public record Currency(String value) {
    public Currency(String value) {
        this.value = value;
        this.ensureIsValidCurrency(value);
    }

    private void ensureIsValidCurrency(String currency) {
        List<String> currencyList = Arrays.asList("PEN", "USD");
        if (!currencyList.contains(currency))
            throw new DigitalWalletGenericClientException("Currency is invalid", HttpStatus.BAD_REQUEST);
    }
}
