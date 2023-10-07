package com.digitalwallet.customerservice.domain;

import lombok.Getter;

@Getter
public class CustomerCreation {
    private String documentNumber;
    private String documentType;
    private String phoneNumber;
    private String givenNames;
    private String surnames;
    private String email;
}
