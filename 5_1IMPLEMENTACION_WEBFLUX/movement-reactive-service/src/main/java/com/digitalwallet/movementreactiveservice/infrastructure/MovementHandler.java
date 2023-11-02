package com.digitalwallet.movementreactiveservice.infrastructure;

import com.digitalwallet.movementreactiveservice.application.FindMovementByWalletId;
import com.digitalwallet.movementreactiveservice.application.RegisterMovement;
import com.digitalwallet.movementreactiveservice.domain.MovementCreation;
import com.digitalwallet.movementreactiveservice.domain.MovementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MovementHandler {
    private final RegisterMovement registerMovement;
    private final FindMovementByWalletId findMovementByWalletId;
    public Mono<ServerResponse> createMovement(ServerRequest request) {
        Mono<MovementCreation> movementCreationMono = request.bodyToMono(MovementCreation.class);
        return registerMovement.registered(movementCreationMono)
                .then(ServerResponse.ok().body(Mono.empty(), Void.class));}

    public Mono<ServerResponse> getMovementsByWalletId(ServerRequest request) {
        String walletId = request.queryParam("walletId").orElse("");
        return ServerResponse.ok().body(findMovementByWalletId.findMovements(walletId), MovementResponse.class);
    }
}
