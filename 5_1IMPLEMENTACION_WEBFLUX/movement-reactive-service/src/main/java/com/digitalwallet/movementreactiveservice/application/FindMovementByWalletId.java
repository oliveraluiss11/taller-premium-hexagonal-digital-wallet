package com.digitalwallet.movementreactiveservice.application;

import com.digitalwallet.movementreactiveservice.domain.MovementRepository;
import com.digitalwallet.movementreactiveservice.domain.MovementResponse;
import com.digitalwallet.movementreactiveservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
@Slf4j
public class FindMovementByWalletId {
    private final MovementRepository repository;

    public Flux<MovementResponse> findMovements(String walletId) {
        return repository.findByWalletId(walletId)
                .switchIfEmpty(Mono.error(new DigitalWalletGenericClientException("List is empty", HttpStatus.NO_CONTENT)))
                .map(movement -> {
                    MovementResponse movementResponse = MovementResponse.builder()
                            .walletId(movement.getWalletId())
                            .amount(movement.getAmount())
                            .currency(movement.getCurrency())
                            .operationNumber(movement.getOperationNumber())
                            .transferId(movement.getTransferId())
                            .typeTransaction(movement.getTypeTransaction())
                            .registrationDate(movement.getRegistrationDate())
                            .build();
                    log.info(movementResponse.toString());
                    return movementResponse;
                });
    }
}
