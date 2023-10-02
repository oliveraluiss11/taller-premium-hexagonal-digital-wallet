package com.digitalwallet.movementservice.infrastructure;

import com.digitalwallet.movementservice.domain.Movement;
import com.digitalwallet.movementservice.domain.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovementRepositoryImpl implements MovementRepository {
    private final MovementMongoRepository repository;
    private final MovementMapper movementMapper;

    @Override
    public Movement save(Movement movement) {
        MovementDocument documentCreated = repository.save(movementMapper.toDocument(movement));
        return movementMapper.toDomain(documentCreated);
    }

    @Override
    public Long countByOperationNumber(String operationNumber) {
        return repository.countByOperationNumber(operationNumber);
    }

    @Override
    public List<Movement> findByWalletId(String walletId) {
        return repository
                .findByWalletIdOrderByRegistrationDateDesc(walletId)
                .stream().map(movementMapper::toDomain).toList();
    }
}
