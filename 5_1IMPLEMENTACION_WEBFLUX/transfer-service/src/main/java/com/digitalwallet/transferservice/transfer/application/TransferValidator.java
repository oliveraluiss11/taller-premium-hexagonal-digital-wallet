package com.digitalwallet.transferservice.transfer.application;

import com.digitalwallet.transferservice.transfer.domain.TransferCreation;
import com.digitalwallet.transferservice.transfer.domain.TransferRequest;
import com.digitalwallet.transferservice.transfer.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransferValidator {
    public void validateTransfer(TransferRequest transferRequest) {
        TransferCreation transferCreation = TransferCreation.fromTransferRequest(transferRequest);
        ensureBothPhoneNumbersAreDifferent(transferCreation);
    }

    public void validateBalanceForTransfer(BigDecimal currentBalance, BigDecimal transferAmount) {
        if (currentBalance.subtract(transferAmount).compareTo(BigDecimal.ZERO) < 0) {
            throw new DigitalWalletGenericClientException(
                    "El saldo en tu cuenta es insuficiente",
                    HttpStatus.UNPROCESSABLE_ENTITY
            );
        }
    }

    public void validateBothCurrencyForWalletAndRequest(String currencyWallet, String currencyRequest) {
        if (!currencyWallet.equals(currencyRequest))
            throw new DigitalWalletGenericClientException("El tipo de moneda no es compatible",
                    HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private void ensureBothPhoneNumbersAreDifferent(TransferCreation transferCreation) {
        if (transferCreation.getOriginPhoneNumber().equals(transferCreation.getDestinationPhoneNumber())) {
            throw new DigitalWalletGenericClientException("Phone numbers are the same", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
