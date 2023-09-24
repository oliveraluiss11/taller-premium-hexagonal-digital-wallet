package com.digitalwallet.movementservice.domain;

import com.digitalwallet.movementservice.domain.value_objects.Currency;
import com.digitalwallet.movementservice.domain.value_objects.Money;
import com.digitalwallet.movementservice.domain.value_objects.TypeTransaction;
import com.digitalwallet.movementservice.domain.value_objects.UUID;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movement{
    private UUID movementId;
    private UUID operationNumber;
    private UUID transferId;
    private TypeTransaction typeTransaction;
    private Currency currency;
    private Money amount;
    private UUID walletId;
    private LocalDateTime registrationDate;
    public Movement(String movementId,
                    String operationNumber,
                    String transferId,
                    String typeTransaction,
                    String currency,
                    BigDecimal amount,
                    String walletId,
                    LocalDateTime registrationDate){
        this.movementId = new UUID(movementId);
        this.operationNumber = new UUID(operationNumber);
        this.transferId = new UUID(transferId);
        this.typeTransaction = new TypeTransaction(typeTransaction);
        this.currency = new Currency(currency);
        this.amount = new Money(amount);
        this.walletId = new UUID(walletId);
        this.registrationDate = registrationDate;
    }
    public String movementId(){
        return this.movementId.value();
    }

    public String getOperationNumber() {
        return operationNumber.value();
    }

    public String getTransferId() {
        return transferId.value();
    }

    public String getTypeTransaction() {
        return typeTransaction.value();
    }

    public String getCurrency() {
        return currency.value();
    }

    public BigDecimal getAmount() {
        return amount.value();
    }

    public String getWalletId() {
        return walletId.value();
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
