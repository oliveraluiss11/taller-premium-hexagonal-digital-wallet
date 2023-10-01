package com.digitalwallet.transferservice.wallet.infrastructure;

import com.digitalwallet.transferservice.wallet.domain.WalletAPI;
import com.digitalwallet.transferservice.wallet.domain.WalletExternalAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WalletExternalAPIImpl implements WalletExternalAPI {

    private final WalletFeignClient walletFeignClient;

    @Override
    public ResponseEntity<WalletAPI> findByPhoneNumber(String phoneNumber) {
        return null;
    }
}
