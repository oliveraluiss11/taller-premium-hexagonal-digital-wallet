package com.digitalwallet.transferservice.transfer.domain.value_object;

import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

public record Balance(BigDecimal value) {
    public Balance(BigDecimal value) {
        this.value = value;
        this.ensureIsBalancePositiveValue(value);
    }
    private void ensureIsBalancePositiveValue(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0)
            throw new DigitalWalletGenericClientException("The balance must be greater than zero"
                    , HttpStatus.BAD_REQUEST);
    }
}
