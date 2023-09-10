package com.digitalwallet.walletservice.domain;

public record Customer(String givenNames,
                       String surnames,
                       String documentNumber,
                       String documentType,
                       String email,
                       String phoneNumber) {}
