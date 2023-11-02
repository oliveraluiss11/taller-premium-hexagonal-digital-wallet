package com.digitalwallet.authenticationservice.domain;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findByCredential(String credential);
}
