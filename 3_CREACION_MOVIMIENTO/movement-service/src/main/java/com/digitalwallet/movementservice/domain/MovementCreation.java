package com.digitalwallet.movementservice.domain;

import lombok.Getter;

@Getter
public class MovementCreation {
    private String operationNumber;
    private String transferId;
    private String typeTransaction;
    private String currency;
    private Double amount;
    private String walletId;
}
