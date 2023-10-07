package com.digitalwallet.transferservice.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerAPI {
    private String documentNumber;
    private String phoneNumber;
    private String email;
    private String givenNames;
    private String surnames;
    private String documentType;
}
