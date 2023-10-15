package com.digitalwallet.transferservice.transfer.infrastructure;

import com.digitalwallet.transferservice.transfer.domain.Transfer;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {
    public Transfer toDomain(TransferEntity entity){
        return new Transfer(entity.getTransferId(),
                entity.getOriginWalletId(),
                entity.getDestinationWalletId(),
                entity.getAmount(),
                entity.getCurrency(),
                entity.getRegistrationDate()
                );
    }

    public TransferEntity toEntity(Transfer domain){
        return TransferEntity
                .builder()
                .transferId(domain.getTransferId())
                .originWalletId(domain.getOriginWalletId())
                .destinationWalletId(domain.getDestinationWalletId())
                .amount(domain.getAmount())
                .currency(domain.getCurrency())
                .registrationDate(domain.getRegistrationDate())
                .build();
    }
}
