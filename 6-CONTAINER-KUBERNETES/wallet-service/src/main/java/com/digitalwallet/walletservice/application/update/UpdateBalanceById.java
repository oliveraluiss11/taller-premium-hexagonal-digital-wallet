package com.digitalwallet.walletservice.application.update;

import com.digitalwallet.walletservice.domain.UpdateBalanceRequest;
import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletRepository;
import com.digitalwallet.walletservice.domain.value_object.Balance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateBalanceById {
    private final WalletRepository walletRepository;

    public void updateBalance(String walletId, UpdateBalanceRequest updateBalanceRequest) {
        Balance balanceUpdate = new Balance(updateBalanceRequest.balance());
        Wallet walletFound = walletRepository.findById(walletId);
        Wallet updateWallet = new Wallet(walletId, balanceUpdate.value()
                , walletFound.getCurrency()
                , walletFound.getCustomer());
        walletRepository.update(updateWallet);
    }
}
