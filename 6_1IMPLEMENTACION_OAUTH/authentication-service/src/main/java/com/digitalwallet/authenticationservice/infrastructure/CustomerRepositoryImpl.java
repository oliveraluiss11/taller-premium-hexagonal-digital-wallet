package com.digitalwallet.authenticationservice.infrastructure;

import com.digitalwallet.authenticationservice.domain.Customer;
import com.digitalwallet.authenticationservice.domain.CustomerRepository;
import com.digitalwallet.authenticationservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerMongoRepository customerMongoRepository;
    private final PersistenceMapper mapper;

    @Override
    public Optional<Customer> findByDocumentNumberOrPhoneNumber(String documentNumber, String phoneNumber) {
        return Optional.of(customerMongoRepository
                .findByDocumentNumberOrPhoneNumber(documentNumber, phoneNumber)
                .map(mapper::toDomain)
                .orElseThrow(() -> new DigitalWalletGenericClientException("Customer not found"
                        , HttpStatus.NOT_FOUND)));
    }
}
