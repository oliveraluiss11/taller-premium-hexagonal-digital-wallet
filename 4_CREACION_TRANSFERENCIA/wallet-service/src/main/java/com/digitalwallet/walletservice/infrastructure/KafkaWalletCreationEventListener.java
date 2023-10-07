package com.digitalwallet.walletservice.infrastructure;

import com.digitalwallet.walletservice.application.create.CreateWallet;
import com.digitalwallet.walletservice.application.create.WalletCreationRequest;
import com.digitalwallet.walletservice.domain.WalletCreationEventListener;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaWalletCreationEventListener implements WalletCreationEventListener {
    private final CreateWallet createWallet;

    @KafkaListener(
            topics = "wallet-creation-event",
            groupId = "wallet-creation-event1"
    )
    @Override
    public void listener(String data) {
        Gson gson = new Gson();
        WalletCreationRequest request = gson.fromJson(data, WalletCreationRequest.class);
        createWallet.create(request);
    }
}
