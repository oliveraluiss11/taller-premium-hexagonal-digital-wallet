package com.digitalwallet.transferservice.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WalletAPI {
    private String walletId;
    private BigDecimal balance;
    private String currency;
    private CustomerAPI customer;
}
