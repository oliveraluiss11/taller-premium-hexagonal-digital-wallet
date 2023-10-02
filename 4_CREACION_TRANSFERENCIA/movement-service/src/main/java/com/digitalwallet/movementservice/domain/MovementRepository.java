package com.digitalwallet.movementservice.domain;

import java.util.List;

public interface MovementRepository {
    Movement save(Movement movement);
    Long countByOperationNumber(String operationNumber);
    List<Movement> findByWalletId(String walletId);
}
