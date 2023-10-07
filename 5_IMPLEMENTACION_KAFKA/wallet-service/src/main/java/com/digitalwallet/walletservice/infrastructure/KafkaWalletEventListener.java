package com.digitalwallet.walletservice.infrastructure;

import com.digitalwallet.walletservice.application.create.CreateWallet;
import com.digitalwallet.walletservice.application.create.WalletCreationRequest;
import com.digitalwallet.walletservice.application.update.UpdateBalanceById;
import com.digitalwallet.walletservice.domain.UpdateBalanceRequest;
import com.digitalwallet.walletservice.domain.WalletCreationEventListener;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaWalletEventListener implements WalletCreationEventListener {
    private final CreateWallet createWallet;
    private final UpdateBalanceById updateBalanceById;

    @KafkaListener(
            topics = "wallet-creation-event",
            groupId = "wallet-creation-event1"
    )
    @Override
    public void listenerWalletCreation(String data) {
        Gson gson = new Gson();
        WalletCreationRequest request = gson.fromJson(data, WalletCreationRequest.class);
        createWallet.create(request);
    }
    @KafkaListener(
            topics = "update-balance-event",
            groupId = "update-balance-event1"
    )
    @Override
    public void listenerUpdateBalance(String data) {
        Gson gson = new Gson();
        UpdateBalanceRequest updateBalanceRequest = gson.fromJson(data, UpdateBalanceRequest.class);
        updateBalanceById.updateBalance(updateBalanceRequest.walletId(), updateBalanceRequest);
    }


}
