package com.digitalwallet.customerservice.application;

import com.digitalwallet.customerservice.domain.Customer;
import com.digitalwallet.customerservice.domain.CustomerCreation;
import com.digitalwallet.customerservice.domain.CustomerRepository;
import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCustomerByPersonalInformation {
    private final CustomerRepository customerRepository;
    public void register(CustomerCreation customerCreation){

        if (customerRepository
                .findByDocumentNumberOrPhoneNumber(customerCreation.getDocumentNumber()
                        , customerCreation.getPhoneNumber()).isPresent())
            throw new DigitalWalletGenericClientException("Customer already exists"
                    , HttpStatus.CONFLICT);
    }
}
