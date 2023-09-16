package com.digitalwallet.walletservice.domain;

import com.digitalwallet.walletservice.domain.value_object.Balance;
import com.digitalwallet.walletservice.domain.value_object.Currency;

import java.math.BigDecimal;

public class WalletValueObject {
    private Balance balance;
    private Currency currency;
    private CustomerValueObject customerValueObject;

    public WalletValueObject(BigDecimal balance, String currency, Customer customer) {
        this.balance = new Balance(balance);
        this.currency = new Currency(currency);
        this.customerValueObject = new CustomerValueObject(customer.documentNumber()
                , customer.phoneNumber(), customer.documentType(), customer.email()
                , customer.givenNames(), customer.surnames());
    }

    public BigDecimal getBalance() {
        return this.balance.value();
    }

    public String getCurrency() {
        return this.currency.value();
    }

    public Customer getCustomer() {
        return this.customerValueObject.toPlainObject();
    }

    public Wallet toPlainObject() {
        return new Wallet(null, this.balance.value(), this.currency.value(), this.customerValueObject.toPlainObject());
    }
}
