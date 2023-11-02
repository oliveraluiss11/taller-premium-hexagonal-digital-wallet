package com.digitalwallet.movementreactiveservice.infrastructure;

import com.digitalwallet.movementreactiveservice.domain.Movement;
import com.digitalwallet.movementreactiveservice.domain.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class MovementRepositoryImpl implements MovementRepository {
    private final MongoReactiveMovement reactiveMovement;
    private final MovementMapper movementMapper;

    @Override
    public Mono<Movement> save(Movement movement) {
        MovementDocument document = movementMapper.toDocument(movement);
        return reactiveMovement.save(document)
                .map(movementMapper::toDomain);
    }

    @Override
    public Mono<Long> countByOperationNumber(String operationNumber) {
        return reactiveMovement.countByOperationNumber(operationNumber);
    }

    @Override
    public Flux<Movement> findByWalletId(String walletId) {
        return reactiveMovement
                .findByWalletIdOrderByRegistrationDateDesc(walletId)
                .map(movementMapper::toDomain);
    }
}
