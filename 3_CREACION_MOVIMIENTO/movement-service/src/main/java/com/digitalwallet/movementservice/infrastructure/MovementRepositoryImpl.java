package com.digitalwallet.movementservice.infrastructure;

import com.digitalwallet.movementservice.domain.Movement;
import com.digitalwallet.movementservice.domain.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
    public Boolean existsByOperationNumber(String operationNumber) {
        return repository.existsByOperationNumber(operationNumber);
    }
}
