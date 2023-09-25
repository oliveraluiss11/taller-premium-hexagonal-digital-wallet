package com.digitalwallet.movementservice.domain;

public interface MovementRepository {
    Movement save(Movement movement);
    Boolean existsByOperationNumber(String operationNumber);
}
