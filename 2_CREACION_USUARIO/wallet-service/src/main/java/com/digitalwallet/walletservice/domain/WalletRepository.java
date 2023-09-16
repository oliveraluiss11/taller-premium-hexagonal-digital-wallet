package com.digitalwallet.walletservice.domain;

public interface WalletRepository {
    Wallet save(Wallet wallet);
    Wallet update(Wallet wallet);
    Wallet findByPhoneNumber(String phoneNumber);
    Wallet findById(String walletId);
}
