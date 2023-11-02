package com.digitalwallet.movementreactiveservice.infrastructure;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoReactiveMovement extends ReactiveMongoRepository<MovementDocument, String> {
    Mono<Long> countByOperationNumber(String operationNumber);

    Flux<MovementDocument> findByWalletIdOrderByRegistrationDateDesc(String walletId);

}
