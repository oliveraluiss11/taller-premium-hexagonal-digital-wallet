package com.digitalwallet.movementservice.application;

import com.digitalwallet.movementservice.domain.Movement;
import com.digitalwallet.movementservice.domain.MovementCreation;
import com.digitalwallet.movementservice.domain.MovementRepository;
import com.digitalwallet.movementservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class RegisterMovement {
    private final MovementRepository movementRepository;

    public void registered(MovementCreation movementCreation) {
        if(movementRepository.existsByOperationNumber(movementCreation.getOperationNumber()))
            throw new DigitalWalletGenericClientException("Movement already exists", HttpStatus.CONFLICT);
        LocalDateTime currentDate = LocalDateTime.now(ZoneId.of("America/Lima"));
        Movement movement = new Movement(
                movementCreation.getOperationNumber(),
                movementCreation.getTransferId(),
                movementCreation.getTypeTransaction(),
                movementCreation.getCurrency(),
                movementCreation.getAmount(),
                movementCreation.getWalletId(),
                currentDate);
        movementRepository.save(movement);
    }
}
