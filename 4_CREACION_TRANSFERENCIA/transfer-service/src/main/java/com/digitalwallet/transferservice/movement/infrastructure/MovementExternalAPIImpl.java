package com.digitalwallet.transferservice.movement.infrastructure;

import com.digitalwallet.transferservice.movement.domain.MovementCreationAPI;
import com.digitalwallet.transferservice.movement.domain.MovementExternalAPI;
import com.digitalwallet.transferservice.transfer.domain.exceptions.DigitalWalletGenericServerException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MovementExternalAPIImpl implements MovementExternalAPI {
    private final MovementFeignClient feignClient;

    @Override
    public void registerMovement(MovementCreationAPI movement) {
        ResponseEntity<Void> responseEntity = feignClient.createMovement(movement);
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            throw new DigitalWalletGenericServerException("Ocurrió un problema en el registro de movimiento");
        }
    }
}
