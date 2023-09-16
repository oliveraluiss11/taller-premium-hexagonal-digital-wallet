package com.digitalwallet.walletservice.infrastructure;

import com.digitalwallet.walletservice.domain.Wallet;
import org.springframework.stereotype.Component;

@Component
public class WalletPersistenceMapper {
    public Wallet toDomain(WalletDocument walletDocument) {
        return new Wallet(walletDocument.getWalletId()
                , walletDocument.getBalance()
                , walletDocument.getCurrency()
                , walletDocument.getCustomer());
    }

    public WalletDocument toDocument(Wallet wallet) {
        return new WalletDocument(wallet.walletId() ,wallet.balance(), wallet.currency(), wallet.customer());
    }
}
