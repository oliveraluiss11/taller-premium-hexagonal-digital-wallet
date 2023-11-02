package com.digitalwallet.walletservice.infrastructure;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Document(collection = "wallets")
public class WalletDocument {
    @Id
    private String walletId;
    private BigDecimal balance;
    private String currency;
    private CustomerDocument customer;

    public WalletDocument(String walletId, BigDecimal balance, String currency, CustomerDocument customer) {
        this.walletId = walletId;
        this.balance = balance;
        this.currency = currency;
        this.customer = customer;
    }

}
