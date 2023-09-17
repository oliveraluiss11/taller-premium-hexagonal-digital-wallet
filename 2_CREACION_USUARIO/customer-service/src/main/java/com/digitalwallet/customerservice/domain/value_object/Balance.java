package com.digitalwallet.customerservice.domain.value_object;

import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

public record Balance(BigDecimal value) {
    public Balance(BigDecimal value) {
        this.value = value;
        this.ensureIsBalancePositiveValue(value);
    }
    private void ensureIsBalancePositiveValue(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0)
            throw new WalletGenericClientException("The balance must be greater than zero"
                    , HttpStatus.BAD_REQUEST);
    }
}
