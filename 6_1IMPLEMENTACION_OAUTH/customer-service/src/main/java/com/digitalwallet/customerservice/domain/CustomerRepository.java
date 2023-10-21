package com.digitalwallet.customerservice.domain;

import java.util.Optional;

public interface CustomerRepository {
    void register(Customer customer);

    Optional<Customer> findByDocumentNumberOrPhoneNumber(String documentNumber, String phoneNumber);
}
