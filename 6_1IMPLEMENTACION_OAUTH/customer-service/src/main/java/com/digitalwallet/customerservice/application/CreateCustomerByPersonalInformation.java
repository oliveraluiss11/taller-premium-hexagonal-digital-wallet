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
        String phoneNumber = cleanPhoneNumber(customerCreation.getPhoneNumber());
        Customer customer = createCustomerFromCreation(customerCreation);
        String documentNumber = customer.getDocumentNumber();
        if (customerAlreadyExists(documentNumber, phoneNumber)) {
            throw new DigitalWalletGenericClientException("Customer already exists", HttpStatus.CONFLICT);
        }
        customerRepository.register(customer);
    }

    private String cleanPhoneNumber(String phoneNumber) {
        return phoneNumber.replace("+", "");
    }

    private Customer createCustomerFromCreation(CustomerCreation customerCreation) {
        return new Customer(
                customerCreation.getDocumentNumber(),
                cleanPhoneNumber(customerCreation.getPhoneNumber()),
                customerCreation.getDocumentType(),
                customerCreation.getEmail(),
                customerCreation.getGivenNames(),
                customerCreation.getSurnames(),
                customerCreation.getPin()
        );
    }

    private boolean customerAlreadyExists(String documentNumber, String phoneNumber) {
        return customerRepository
                .findByDocumentNumberOrPhoneNumber(documentNumber, phoneNumber)
                .isPresent();
    }
}
