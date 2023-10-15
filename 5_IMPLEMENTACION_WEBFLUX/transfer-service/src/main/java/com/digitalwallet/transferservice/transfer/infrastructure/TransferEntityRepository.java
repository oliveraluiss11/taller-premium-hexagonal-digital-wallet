package com.digitalwallet.transferservice.transfer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferEntityRepository extends JpaRepository<TransferEntity, Long> {
}
