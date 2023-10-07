package com.digitalwallet.customerservice.infrastructure;

import com.digitalwallet.customerservice.config.KafkaTopicConfig;
import com.digitalwallet.customerservice.domain.WalletCreation;
import com.digitalwallet.customerservice.domain.WalletCreationEventProducer;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class WalletCreationEventProducerImpl implements WalletCreationEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTopicConfig kafkaTopicConfig;
    @Override
    public void sendWalletCreationEvent(WalletCreation event) {
        Gson gson = new Gson();
        String walletRequestJson = gson.toJson(event);
        UUID key = UUID.randomUUID();
        kafkaTemplate.send(kafkaTopicConfig.productTopic().name(),key.toString(), walletRequestJson);
    }
}
