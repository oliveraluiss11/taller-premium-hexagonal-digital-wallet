package com.digitalwallet.movementservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovementMongoRepository extends MongoRepository<MovementDocument, String> {
    Long countByOperationNumber(String operationNumber);
    List<MovementDocument> findByWalletIdOrderByRegistrationDateDesc(String walletId);
}
