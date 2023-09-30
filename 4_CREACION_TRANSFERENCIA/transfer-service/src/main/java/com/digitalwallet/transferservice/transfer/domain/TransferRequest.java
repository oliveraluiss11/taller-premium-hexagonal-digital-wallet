package com.digitalwallet.transferservice.transfer.domain;

import lombok.Getter;

@Getter
public class TransferRequest {

    private String originPhoneNumber;
    private String destinationPhoneNumber;
    private double amount;
    private String currency;
}
