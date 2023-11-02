package com.digitalwallet.transferservice.movement.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@Builder
public class MovementCreationAPI {
    private String operationNumber;
    private String transferId;
    private String typeTransaction;
    private String currency;
    private BigDecimal amount;
    private String walletId;
}
