package com.digitalwallet.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableMongoRepositories(basePackages = "com.digitalwallet.customerservice.infrastructure")
@EnableTransactionManagement
@EnableFeignClients("com.digitalwallet.customerservice.infrastructure")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
