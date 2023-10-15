package com.digitalwallet.movementreactiveservice.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MovementCreation {
    private String operationNumber;
    private String transferId;
    private String typeTransaction;
    private String currency;
    private BigDecimal amount;
    private String walletId;
}
