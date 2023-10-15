package com.digitalwallet.movementservice.application;

import com.digitalwallet.movementservice.domain.Movement;
import com.digitalwallet.movementservice.domain.MovementRepository;
import com.digitalwallet.movementservice.domain.MovementResponse;
import com.digitalwallet.movementservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindMovementByWalletId {
    private final MovementRepository repository;
    public List<MovementResponse> findMovements(String walletId) {
        List<Movement> movementList = repository.findByWalletId(walletId);
        if (movementList.isEmpty())
            throw new DigitalWalletGenericClientException("List is empty", HttpStatus.NO_CONTENT);
        return movementList.stream().map(movement -> MovementResponse
                .builder()
                .walletId(movement.getWalletId())
                .amount(movement.getAmount())
                .currency(movement.getCurrency())
                .operationNumber(movement.getOperationNumber())
                .transferId(movement.getTransferId())
                .typeTransaction(movement.getTypeTransaction())
                .registrationDate(movement.getRegistrationDate())
                .build()).toList();
    }
}
