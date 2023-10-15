package com.digitalwallet.transferservice.transfer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic walletCreationTopic(){
        return TopicBuilder.name("wallet-creation-event").build();
    }
    @Bean
    public NewTopic registerMovementTopic(){
        return TopicBuilder.name("register-movement-event").build();
    }
}
