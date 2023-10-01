package com.digitalwallet.transferservice.wallet.infrastructure;

import com.digitalwallet.transferservice.wallet.domain.WalletAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:9001", name = "wallet-service")
public interface WalletFeignClient {
    @GetMapping("/wallets")
    ResponseEntity<WalletAPI> findByPhoneNumber(@RequestParam String phoneNumber);
}
