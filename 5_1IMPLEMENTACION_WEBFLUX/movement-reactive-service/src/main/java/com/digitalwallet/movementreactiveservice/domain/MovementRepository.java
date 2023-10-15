package com.digitalwallet.movementreactiveservice.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementRepository {
    Mono<Movement> save(Movement movement);

    Mono<Long> countByOperationNumber(String operationNumber);

    Flux<Movement> findByWalletId(String walletId);
}
