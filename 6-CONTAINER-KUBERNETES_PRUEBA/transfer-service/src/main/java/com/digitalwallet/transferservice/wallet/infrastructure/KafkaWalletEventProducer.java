package com.digitalwallet.transferservice.wallet.infrastructure;

import com.digitalwallet.transferservice.transfer.config.KafkaTopicConfig;
import com.digitalwallet.transferservice.wallet.domain.UpdateBalanceAPI;
import com.digitalwallet.transferservice.wallet.domain.WalletEventProducer;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class KafkaWalletEventProducer implements WalletEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTopicConfig kafkaTopicConfig;
    @Override
    public void sendUpdateBalanceEvent(UpdateBalanceAPI updateBalanceAPI) {
        Gson gson = new Gson();
        String updateRequestJson = gson.toJson(updateBalanceAPI);
        String key = UUID.randomUUID().toString();
        String nameTopic = kafkaTopicConfig.walletCreationTopic().name();
        kafkaTemplate.send(nameTopic, key, updateRequestJson);
    }
}
