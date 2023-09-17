package com.digitalwallet.customerservice.application;

import com.digitalwallet.customerservice.domain.Customer;
import com.digitalwallet.customerservice.domain.CustomerCreation;
import com.digitalwallet.customerservice.domain.CustomerRepository;
import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCustomerByPersonalInformation {
    private final CustomerRepository customerRepository;

    @Transactional(rollbackFor = Exception.class)
    public void register(CustomerCreation customerCreation) {
        String documentNumber = customerCreation.getDocumentNumber().replace("+", "");
        Customer customer = new Customer(documentNumber
                , customerCreation.getPhoneNumber(), customerCreation.getDocumentType()
                , customerCreation.getEmail(), customerCreation.getGivenNames()
                , customerCreation.getSurnames());
        if (customerRepository
                .findByDocumentNumberOrPhoneNumber(documentNumber
                        , customerCreation.getPhoneNumber()).isPresent())
            throw new DigitalWalletGenericClientException("Customer already exists"
                    , HttpStatus.CONFLICT);
        customerRepository.register(customer);
    }
}
