package com.digitalwallet.movementreactiveservice.infrastructure;

import com.digitalwallet.movementreactiveservice.domain.Movement;
import org.springframework.stereotype.Component;

@Component
public class MovementMapper {
    public MovementDocument toDocument(Movement domain) {
        return new MovementDocument(
                domain.getMovementId(),
                domain.getOperationNumber(),
                domain.getTransferId(),
                domain.getTypeTransaction(),
                domain.getCurrency(),
                domain.getAmount(),
                domain.getWalletId(),
                domain.getRegistrationDate());
    }

    public Movement toDomain(MovementDocument document) {
        return new Movement(document.getMovementId(),
                document.getOperationNumber(),
                document.getTransferId(),
                document.getTypeTransaction(),
                document.getCurrency(),
                document.getAmount(),
                document.getWalletId(),
                document.getRegistrationDate());
    }
}
