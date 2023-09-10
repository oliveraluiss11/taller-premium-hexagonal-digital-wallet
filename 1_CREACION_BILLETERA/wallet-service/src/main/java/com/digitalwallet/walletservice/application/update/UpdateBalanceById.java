package com.digitalwallet.walletservice.application.update;

import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletRepository;
import com.digitalwallet.walletservice.domain.value_object.Balance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class UpdateBalanceById {
    private final WalletRepository walletRepository;

    public void updateBalance(String walletId, UpdateBalance updateBalance) {
        Balance balanceUpdate = new Balance(updateBalance.balance());
        Wallet walletFound = walletRepository.findById(walletId);
        Wallet updateWallet = new Wallet(walletId, balanceUpdate.value()
                , walletFound.currency()
                , walletFound.customer());
        walletRepository.update(updateWallet);
    }
}
