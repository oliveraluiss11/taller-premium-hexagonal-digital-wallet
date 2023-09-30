package com.digitalwallet.transferservice.transfer.domain;

import com.digitalwallet.transferservice.transfer.domain.value_object.Balance;
import com.digitalwallet.transferservice.transfer.domain.value_object.Currency;
import com.digitalwallet.transferservice.transfer.domain.value_object.PhoneNumber;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class TransferCreation {
    private PhoneNumber originPhoneNumber;
    private PhoneNumber destinationPhoneNumber;
    private Balance amount;
    private Currency currency;

    public TransferCreation(String originPhoneNumber, String destinationPhoneNumber,
                            BigDecimal amount, String currency) {
        this.amount = new Balance(amount);
        this.originPhoneNumber = new PhoneNumber(originPhoneNumber);
        this.destinationPhoneNumber = new PhoneNumber(destinationPhoneNumber);
        this.currency = new Currency(currency);
    }

    public String getOriginPhoneNumber() {
        return originPhoneNumber.value();
    }

    public String getDestinationPhoneNumber() {
        return destinationPhoneNumber.value();
    }

    public BigDecimal getAmount() {
        return amount.value();
    }

    public String getCurrency() {
        return currency.value();
    }
}
