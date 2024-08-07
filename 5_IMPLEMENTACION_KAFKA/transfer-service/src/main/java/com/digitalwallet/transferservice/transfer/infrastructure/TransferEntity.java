package com.digitalwallet.transferservice.transfer.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_TRANSFER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;
    private String originWalletId;
    private String destinationWalletId;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime registrationDate;
}
