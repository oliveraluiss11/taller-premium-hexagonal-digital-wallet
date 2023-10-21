package com.digitalwallet.authenticationservice.infrastructure;


import com.digitalwallet.authenticationservice.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class PersistenceMapper {

    public Customer toDomain(CustomerDocument document) {
        return Customer.builder()
                .documentNumber(document.getDocumentNumber())
                .phoneNumber(document.getPhoneNumber())
                .documentType(document.getDocumentType())
                .email(document.getEmail())
                .givenNames(document.getGivenNames())
                .surnames(document.getSurnames())
                .pin(document.getPin())
                .build();
    }
}
