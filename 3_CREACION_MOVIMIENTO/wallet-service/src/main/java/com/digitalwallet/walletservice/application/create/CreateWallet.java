package com.digitalwallet.walletservice.application.create;

import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletCreationEventListener;
import com.digitalwallet.walletservice.domain.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CreateWallet {
    private final WalletRepository walletRepository;
    public void create(WalletCreationRequest request) {
        /*
         Según la lógica de negocio la billetera debe inicializarse con "0" y de tipo de moneda "PEN"
         */
        Wallet wallet = new Wallet(BigDecimal.ZERO, request.currency(), request.customer());
        /*
        Inicializamos el value object para realizar las validaciones de los campos
         */
        Wallet walletValueObject = new Wallet(wallet.getBalance()
                , wallet.getCurrency(), wallet.getCustomer());
        /*
        Guardamos nuestra información en la base de datos
         */
        walletRepository.save(walletValueObject);
    }
}
