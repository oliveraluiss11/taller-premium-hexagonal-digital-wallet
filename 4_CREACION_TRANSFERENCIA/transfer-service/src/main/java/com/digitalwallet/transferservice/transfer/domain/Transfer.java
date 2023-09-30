package com.digitalwallet.transferservice.transfer.domain;

import com.digitalwallet.transferservice.transfer.domain.value_object.Balance;
import com.digitalwallet.transferservice.transfer.domain.value_object.Currency;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transfer {
    private Long transferId;
    private String originWalletId;
    private String destinationWalletId;
    private Balance amount;
    private Currency currency;
    private LocalDateTime registrationDate;

    public Transfer(Long transferId, String originWalletId
            , String destinationWalletId, BigDecimal amount,
                    String currency, LocalDateTime registrationDate) {
        this.amount = new Balance(amount);
        this.currency = new Currency(currency);
        this.registrationDate = registrationDate;
        this.transferId = transferId;
        this.originWalletId = originWalletId;
        this.destinationWalletId = destinationWalletId;
    }

    public Transfer(String originWalletId
            , String destinationWalletId, BigDecimal amount,
                    String currency, LocalDateTime registrationDate) {
        this.amount = new Balance(amount);
        this.currency = new Currency(currency);
        this.registrationDate = registrationDate;
        this.transferId = transferId;
        this.originWalletId = originWalletId;
        this.destinationWalletId = destinationWalletId;
    }

    public Long getTransferId() {
        return transferId;
    }

    public String getOriginWalletId() {
        return originWalletId;
    }

    public String getDestinationWalletId() {
        return destinationWalletId;
    }

    public BigDecimal getAmount() {
        return amount.value();
    }

    public String getCurrency() {
        return currency.value();
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
