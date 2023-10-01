package com.digitalwallet.transferservice.wallet.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface WalletExternalAPI {
    ResponseEntity<WalletAPI> findByPhoneNumber(@RequestParam String phoneNumber);
}
