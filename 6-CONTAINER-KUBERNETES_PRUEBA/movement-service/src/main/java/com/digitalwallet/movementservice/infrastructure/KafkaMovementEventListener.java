package com.digitalwallet.movementservice.infrastructure;

import com.digitalwallet.movementservice.application.RegisterMovement;
import com.digitalwallet.movementservice.domain.MovementCreation;
import com.digitalwallet.movementservice.domain.MovementEventListener;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMovementEventListener implements MovementEventListener {
    private final RegisterMovement registerMovement;

    @KafkaListener(
            topics = "register-movement-event",
            groupId = "register-movement-event1"
    )
    @Override
    public void listenerRegisterMovement(String data) {
        Gson gson = new Gson();
        MovementCreation movementCreation = gson.fromJson(data, MovementCreation.class);
        registerMovement.registered(movementCreation);
    }
}
