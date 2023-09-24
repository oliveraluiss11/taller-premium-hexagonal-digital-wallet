package com.digitalwallet.movementservice.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class MovementResponse {
    private String operationNumber;
    private String transferId;
    private String typeTransaction;
    private String currency;
    private BigDecimal amount;
    private String walletId;
    private LocalDateTime registrationDate;
}
