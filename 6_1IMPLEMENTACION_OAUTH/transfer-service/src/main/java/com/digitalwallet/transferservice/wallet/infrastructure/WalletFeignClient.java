package com.digitalwallet.transferservice.wallet.infrastructure;

import com.digitalwallet.transferservice.wallet.domain.UpdateBalanceAPI;
import com.digitalwallet.transferservice.wallet.domain.WalletAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:9001", name = "wallet-service")
public interface WalletFeignClient {
    @GetMapping("/wallets")
    ResponseEntity<WalletAPI> findByPhoneNumber(@RequestParam String phoneNumber);

    @RequestMapping(method = RequestMethod.PATCH, value = "/wallets/{walletId}/balance")
    ResponseEntity<Void> updateBalance(@PathVariable String walletId, @RequestBody UpdateBalanceAPI updateBalance);


}
