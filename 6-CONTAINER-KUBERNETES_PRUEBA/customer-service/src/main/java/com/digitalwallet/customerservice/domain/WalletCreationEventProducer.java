package com.digitalwallet.customerservice.domain;

public interface WalletCreationEventProducer {
    void sendWalletCreationEvent(WalletCreation event);
}
