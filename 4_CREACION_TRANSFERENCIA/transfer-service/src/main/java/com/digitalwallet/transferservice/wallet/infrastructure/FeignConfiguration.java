package com.digitalwallet.transferservice.wallet.infrastructure;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}