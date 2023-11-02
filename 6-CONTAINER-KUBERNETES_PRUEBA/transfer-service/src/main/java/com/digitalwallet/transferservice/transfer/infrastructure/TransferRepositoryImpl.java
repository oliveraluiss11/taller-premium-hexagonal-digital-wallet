package com.digitalwallet.transferservice.transfer.infrastructure;

import com.digitalwallet.transferservice.transfer.domain.Transfer;
import com.digitalwallet.transferservice.transfer.domain.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TransferRepositoryImpl implements TransferRepository {
    private final TransferEntityRepository transferEntityRepository;
    private final TransferMapper mapper;
    @Override
    public Transfer save(Transfer transfer) {
        TransferEntity transferCreated = transferEntityRepository.save(mapper.toEntity(transfer));
        return mapper.toDomain(transferCreated);
    }
}
