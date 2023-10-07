package com.digitalwallet.walletservice.domain;

public interface WalletCreationEventListener {
    void listenerWalletCreation(String data);
    void listenerUpdateBalance(String data);
}
