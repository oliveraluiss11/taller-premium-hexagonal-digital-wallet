package com.digitalwallet.transferservice.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UpdateBalanceAPI {
    private String walletId;
    private BigDecimal balance;
}
