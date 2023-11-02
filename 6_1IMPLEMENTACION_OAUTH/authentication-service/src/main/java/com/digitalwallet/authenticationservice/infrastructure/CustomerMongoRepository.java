package com.digitalwallet.authenticationservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerMongoRepository extends MongoRepository<CustomerDocument, String> {
    Optional<CustomerDocument> findByDocumentNumberOrPhoneNumber(String documentNumber
            , String phoneNumber);
}
