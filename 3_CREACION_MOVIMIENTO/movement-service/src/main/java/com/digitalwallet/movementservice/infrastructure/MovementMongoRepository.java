package com.digitalwallet.movementservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovementMongoRepository extends MongoRepository<MovementDocument, String> {
    Boolean existsByOperationNumber(String operationNumber);
}
