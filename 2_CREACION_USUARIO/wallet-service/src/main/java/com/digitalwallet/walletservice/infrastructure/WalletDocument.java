package com.digitalwallet.walletservice.infrastructure;

import com.digitalwallet.walletservice.domain.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "wallets")
public class WalletDocument {
    @Id
    private String walletId;
    private BigDecimal balance;
    private String currency;
    private Customer customer;

    public WalletDocument(String walletId, BigDecimal balance, String currency, Customer customer) {
        this.walletId = walletId;
        this.balance = balance;
        this.currency = currency;
        this.customer = customer;
    }

    public String getWalletId() {
        return walletId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public Customer getCustomer() {
        return customer;
    }
}
