package com.digitalwallet.transferservice.wallet.domain;

public interface WalletExternalAPI {
    WalletAPI findByPhoneNumber(String phoneNumber);
}
