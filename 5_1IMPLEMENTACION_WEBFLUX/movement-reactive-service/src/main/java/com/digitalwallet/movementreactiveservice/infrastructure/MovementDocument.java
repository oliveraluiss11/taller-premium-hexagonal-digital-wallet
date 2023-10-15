package com.digitalwallet.movementreactiveservice.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "movements")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MovementDocument {
    @Id
    private String movementId;
    private String operationNumber;
    private String transferId;
    private String typeTransaction;
    private String currency;
    private BigDecimal amount;
    private String walletId;
    private LocalDateTime registrationDate;
}
