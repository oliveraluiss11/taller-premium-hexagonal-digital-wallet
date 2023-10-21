package com.digitalwallet.authenticationservice.domain;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findByDocumentNumberOrPhoneNumber(String documentNumber
            , String phoneNumber);
}
