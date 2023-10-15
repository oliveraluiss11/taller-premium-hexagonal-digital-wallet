package com.digitalwallet.movementreactiveservice.application;


import com.digitalwallet.movementreactiveservice.domain.Movement;
import com.digitalwallet.movementreactiveservice.domain.MovementCreation;
import com.digitalwallet.movementreactiveservice.domain.MovementRepository;
import com.digitalwallet.movementreactiveservice.domain.exceptions.DigitalWalletGenericClientException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterMovement {
    private final MovementRepository movementRepository;
    private final Function<Long, Mono<LocalDateTime>> validateCountByOperationNumber = count -> {
        if (count >= 2)
            throw new DigitalWalletGenericClientException("Movement already exists", HttpStatus.CONFLICT);
        LocalDateTime currentDate = LocalDateTime.now(ZoneId.of("America/Lima"));
        return Mono.just(currentDate);
    };

    public Mono<Void> registered(Mono<MovementCreation> movementCreationMono) {
        return movementCreationMono.flatMap(movementCreation -> movementRepository
                .countByOperationNumber(movementCreation.getOperationNumber())
                .flatMap(validateCountByOperationNumber)
                .flatMap(currentDate ->{
                    Movement movement = new Movement(
                            movementCreation.getOperationNumber(),
                            movementCreation.getTransferId(),
                            movementCreation.getTypeTransaction(),
                            movementCreation.getCurrency(),
                            movementCreation.getAmount(),
                            movementCreation.getWalletId(),
                            currentDate);
                    log.info(movement.toString());
                    return  movementRepository.save(movement);
                })).then();
    }
}
