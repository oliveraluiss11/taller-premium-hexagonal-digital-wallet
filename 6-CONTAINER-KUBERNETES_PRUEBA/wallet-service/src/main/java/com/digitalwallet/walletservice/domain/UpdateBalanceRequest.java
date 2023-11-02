package com.digitalwallet.walletservice.domain;

import java.math.BigDecimal;

public record UpdateBalanceRequest(String walletId, BigDecimal balance) {
}
