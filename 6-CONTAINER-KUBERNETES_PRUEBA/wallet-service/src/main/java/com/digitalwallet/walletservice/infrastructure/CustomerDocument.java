package com.digitalwallet.walletservice.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerDocument {
    private String documentNumber;
    private String phoneNumber;
    private String email;
    private String givenNames;
    private String surnames;
    private String documentType;
}
