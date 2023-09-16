package com.digitalwallet.walletservice.domain;

import java.math.BigDecimal;

public record Wallet (String walletId, BigDecimal balance, String currency, Customer customer){
}
