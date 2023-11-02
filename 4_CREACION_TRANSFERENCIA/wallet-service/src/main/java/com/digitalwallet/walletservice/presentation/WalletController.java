package com.digitalwallet.walletservice.presentation;

import com.digitalwallet.walletservice.application.find.FindWallet;
import com.digitalwallet.walletservice.application.update.UpdateBalance;
import com.digitalwallet.walletservice.application.update.UpdateBalanceById;
import com.digitalwallet.walletservice.domain.Wallet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final FindWallet findWallet;
    private final UpdateBalanceById updateBalanceById;

    @GetMapping
    ResponseEntity<Wallet> findByPhoneNumber(@RequestParam String phoneNumber) {
        return ResponseEntity.ok(findWallet.findByPhoneNumber(phoneNumber));
    }

    @PatchMapping("/{walletId}/balance")
    ResponseEntity<Void> updateBalance(@PathVariable String walletId, @RequestBody UpdateBalance updateBalance) {
        updateBalanceById.updateBalance(walletId, updateBalance);
        return ResponseEntity.accepted().build();
    }
}
