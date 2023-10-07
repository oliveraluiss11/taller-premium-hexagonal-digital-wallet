package com.digitalwallet.transferservice.movement.domain;

public interface MovementEventProducer {
    void sendRegisterMovementEvent(MovementCreationAPI movementCreationAPI);
}
