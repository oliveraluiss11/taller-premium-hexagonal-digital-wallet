package com.digitalwallet.walletservice.application.find;

import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletRepository;
import com.digitalwallet.walletservice.domain.value_object.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindWallet {
    private final WalletRepository walletRepository;

    public Wallet findByPhoneNumber(String phoneNumber){
        return walletRepository.findByPhoneNumber(new PhoneNumber(phoneNumber).value());
    }
}
