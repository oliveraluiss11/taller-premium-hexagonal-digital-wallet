package com.digitalwallet.walletservice.application.create;

import com.digitalwallet.walletservice.domain.Customer;
import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletRepository;
import com.digitalwallet.walletservice.domain.WalletValueObject;
import lombok.RequiredArgsConstructor;
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
        Wallet wallet = new Wallet(null,BigDecimal.ZERO, request.currency(), request.customer());
        /*
        Inicializamos el value object para realizar las validaciones de los campos
         */
        WalletValueObject walletValueObject = new WalletValueObject(wallet.balance()
                , wallet.currency(), wallet.customer());
        /*
        Guardamos nuestra información en la base de datos
         */
        walletRepository.save(walletValueObject.toPlainObject());
    }
}
