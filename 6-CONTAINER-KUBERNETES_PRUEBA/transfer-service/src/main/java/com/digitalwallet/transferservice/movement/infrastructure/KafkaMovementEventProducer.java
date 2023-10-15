package com.digitalwallet.transferservice.movement.infrastructure;

import com.digitalwallet.transferservice.movement.domain.MovementCreationAPI;
import com.digitalwallet.transferservice.movement.domain.MovementEventProducer;
import com.digitalwallet.transferservice.transfer.config.KafkaTopicConfig;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class KafkaMovementEventProducer implements MovementEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTopicConfig kafkaTopicConfig;
    @Override
    public void sendRegisterMovementEvent(MovementCreationAPI movementCreationAPI) {
        Gson gson = new Gson();
        String requestJson = gson.toJson(movementCreationAPI);
        String key = UUID.randomUUID().toString();
        String nameTopic = kafkaTopicConfig.registerMovementTopic().name();
        kafkaTemplate.send(nameTopic, key, requestJson);
    }
}
