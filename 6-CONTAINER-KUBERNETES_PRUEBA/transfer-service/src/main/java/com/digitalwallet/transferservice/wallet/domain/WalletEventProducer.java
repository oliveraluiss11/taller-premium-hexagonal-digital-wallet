package com.digitalwallet.transferservice.wallet.domain;

public interface WalletEventProducer {
    void sendUpdateBalanceEvent(UpdateBalanceAPI updateBalanceAPI);
}
