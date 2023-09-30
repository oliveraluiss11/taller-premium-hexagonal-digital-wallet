package com.digitalwallet.transferservice.transfer.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class TransferRequest {
    private String originPhoneNumber;
    private String destinationPhoneNumber;
    private BigDecimal amount;
    private String currency;
}
