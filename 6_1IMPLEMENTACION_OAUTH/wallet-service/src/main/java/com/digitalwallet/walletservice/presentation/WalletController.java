package com.digitalwallet.walletservice.presentation;

import com.digitalwallet.walletservice.application.create.CreateWallet;
import com.digitalwallet.walletservice.application.create.WalletCreationRequest;
import com.digitalwallet.walletservice.application.find.FindWallet;
import com.digitalwallet.walletservice.application.update.UpdateBalance;
import com.digitalwallet.walletservice.application.update.UpdateBalanceById;
import com.digitalwallet.walletservice.domain.Wallet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final CreateWallet createWallet;
    private final FindWallet findWallet;
    private final UpdateBalanceById updateBalanceById;
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody WalletCreationRequest request) {
        createWallet.create(request);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
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
