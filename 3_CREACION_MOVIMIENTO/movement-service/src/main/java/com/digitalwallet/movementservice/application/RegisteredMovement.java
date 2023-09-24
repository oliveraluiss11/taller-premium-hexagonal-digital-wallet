package com.digitalwallet.movementservice.application;

import com.digitalwallet.movementservice.domain.Movement;
import com.digitalwallet.movementservice.domain.MovementCreation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class RegisteredMovement {
    public void registered(MovementCreation movementCreation) {
        Movement movement = new Movement(
                movementCreation.getOperationNumber(),
                movementCreation.getTransferId(),
                movementCreation.getTypeTransaction(),
                movementCreation.getCurrency(),
                movementCreation.getAmount(),
                movementCreation.getWalletId(),
                LocalDateTime.now());
    }
}
