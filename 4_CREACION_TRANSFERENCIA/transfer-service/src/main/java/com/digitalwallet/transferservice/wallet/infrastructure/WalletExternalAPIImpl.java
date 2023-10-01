package com.digitalwallet.transferservice.wallet.infrastructure;

import com.digitalwallet.transferservice.transfer.domain.DigitalWalletGenericServerException;
import com.digitalwallet.transferservice.wallet.domain.UpdateBalanceAPI;
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
    public WalletAPI findByPhoneNumber(String phoneNumber) {
        ResponseEntity<WalletAPI> response = walletFeignClient.findByPhoneNumber(phoneNumber);

        // Validar el código de estado de la respuesta
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new DigitalWalletGenericServerException("Error al obtener la billetera");
        }
        return walletFeignClient.findByPhoneNumber(phoneNumber).getBody();
    }

    @Override
    public void updateBalanceById(String walletId, UpdateBalanceAPI updateBalanceAPI) {
        ResponseEntity<Void> response = walletFeignClient.updateBalance(walletId, updateBalanceAPI);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new DigitalWalletGenericServerException("Error al actualizar la billetera");
        }
    }
}
