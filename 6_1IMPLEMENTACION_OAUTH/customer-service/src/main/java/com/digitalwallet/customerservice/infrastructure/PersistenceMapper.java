package com.digitalwallet.customerservice.infrastructure;


import com.digitalwallet.customerservice.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class PersistenceMapper {
    public CustomerDocument toDocument(Customer domain) {
        return new CustomerDocument(domain.getCustomerId(), domain.getGivenNames()
                , domain.getSurnames(), domain.getDocumentNumber()
                , domain.getDocumentType(), domain.getEmail()
                , domain.getPhoneNumber()
                , domain.getPin());
    }

    public Customer toDomain(CustomerDocument document) {
        return new Customer(document.getCustomerId(), document.getDocumentNumber(), document.getPhoneNumber()
                , document.getDocumentType(), document.getEmail()
                , document.getGivenNames(), document.getSurnames()
                , document.getPin());
    }
}
