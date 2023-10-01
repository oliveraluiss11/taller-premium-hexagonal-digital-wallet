package com.digitalwallet.transferservice.transfer.application;

import com.digitalwallet.transferservice.transfer.domain.TransferRequest;
import com.digitalwallet.transferservice.wallet.domain.UpdateBalanceAPI;
import com.digitalwallet.transferservice.wallet.domain.WalletAPI;
import com.digitalwallet.transferservice.wallet.domain.WalletExternalAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferExecutor {
    private final WalletExternalAPI walletExternalAPI;

    public void performTransfer(TransferRequest transferRequest) {
        WalletAPI originWallet = this.getWalletByPhoneNumber(transferRequest.getOriginPhoneNumber());
        //WalletAPI destinationWallet = this.getWalletByPhoneNumber(transferRequest.getDestinationPhoneNumber());
        walletExternalAPI.updateBalanceById(originWallet.getWalletId(),
                UpdateBalanceAPI
                        .builder()
                        .balance(BigDecimal.valueOf(100))
                        .build());
    }

    private WalletAPI getWalletByPhoneNumber(String phoneNumber) {
        return walletExternalAPI.findByPhoneNumber(phoneNumber);
    }
}
