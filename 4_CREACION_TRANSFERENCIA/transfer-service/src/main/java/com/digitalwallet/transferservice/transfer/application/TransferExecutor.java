package com.digitalwallet.transferservice.transfer.application;

import com.digitalwallet.transferservice.movement.domain.MovementCreationAPI;
import com.digitalwallet.transferservice.movement.domain.MovementExternalAPI;
import com.digitalwallet.transferservice.transfer.domain.Transfer;
import com.digitalwallet.transferservice.transfer.domain.TransferCreation;
import com.digitalwallet.transferservice.transfer.domain.TransferRepository;
import com.digitalwallet.transferservice.transfer.domain.TransferRequest;
import com.digitalwallet.transferservice.wallet.domain.UpdateBalanceAPI;
import com.digitalwallet.transferservice.wallet.domain.WalletAPI;
import com.digitalwallet.transferservice.wallet.domain.WalletExternalAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Servicio encargado de ejecutar la lógica de transferencia entre billeteras.
 */
@Service
@RequiredArgsConstructor
public class TransferExecutor {

    private final WalletExternalAPI walletExternalAPI;
    private final TransferValidator transferValidator;
    private final MovementExternalAPI movementExternalAPI;
    private final TransferRepository transferRepository;

    /**
     * Realiza una transferencia entre dos billeteras.
     *
     * @param transferRequest La solicitud de transferencia.
     */
    public void performTransfer(TransferRequest transferRequest) {
        TransferCreation transferCreation = TransferCreation.fromTransferRequest(transferRequest);
        transferValidator.validateTransfer(transferRequest);

        WalletAPI originWallet = walletExternalAPI.findByPhoneNumber(transferRequest.getOriginPhoneNumber());
        WalletAPI destinationWallet = walletExternalAPI.findByPhoneNumber(transferRequest.getDestinationPhoneNumber());

        String currencyRequest = transferRequest.getCurrency();
        validateCurrencies(originWallet.getCurrency(), destinationWallet.getCurrency(), currencyRequest);

        BigDecimal transferAmount = transferRequest.getAmount();
        BigDecimal currentBalanceOriginWallet = originWallet.getBalance();
        BigDecimal currentBalanceDestinationWallet = destinationWallet.getBalance();
        transferValidator.validateBalanceForTransfer(currentBalanceOriginWallet, transferAmount);

        BigDecimal balanceUpdatedOriginWallet = currentBalanceOriginWallet.subtract(transferAmount);
        BigDecimal balanceUpdatedDestinationWallet = currentBalanceDestinationWallet.add(transferAmount);

        updateBalanceForWallet(balanceUpdatedOriginWallet, originWallet);
        updateBalanceForWallet(balanceUpdatedDestinationWallet, destinationWallet);

        Transfer transfer = createTransfer(originWallet, destinationWallet, transferAmount, currencyRequest);
        Transfer transferCreated = transferRepository.save(transfer);

        UUID uuid = UUID.randomUUID();
        registerMovementForWallet(transferCreated, originWallet, transferAmount.negate(), currencyRequest, uuid);
        registerMovementForWallet(transferCreated, destinationWallet, transferAmount, currencyRequest, uuid);
    }

    private Transfer createTransfer(WalletAPI originWallet, WalletAPI destinationWallet, BigDecimal transferAmount, String currency) {
        return new Transfer(originWallet.getWalletId(), destinationWallet.getWalletId(), transferAmount, currency, LocalDateTime.now());
    }

    private void validateCurrencies(String originCurrency, String destinationCurrency, String requestCurrency) {
        transferValidator.validateBothCurrencyForWalletAndRequest(originCurrency, requestCurrency);
        transferValidator.validateBothCurrencyForWalletAndRequest(destinationCurrency, requestCurrency);
    }

    private void registerMovementForWallet(Transfer transfer, WalletAPI wallet, BigDecimal amount, String currency, UUID uuid) {
        movementExternalAPI.registerMovement(MovementCreationAPI.builder()
                .transferId(transfer.getTransferId().toString())
                .amount(amount)
                .currency(currency)
                .typeTransaction("TRANSFER")
                .operationNumber(uuid.toString())
                .walletId(wallet.getWalletId())
                .build());
    }

    private void updateBalanceForWallet(BigDecimal balance, WalletAPI walletAPI) {
        walletExternalAPI.updateBalanceById(walletAPI.getWalletId(), UpdateBalanceAPI.builder().balance(balance).build());
    }
}
