package com.digitalwallet.customerservice.application;

import com.digitalwallet.customerservice.domain.Customer;
import com.digitalwallet.customerservice.domain.CustomerCreation;
import com.digitalwallet.customerservice.domain.CustomerRepository;
import com.digitalwallet.customerservice.domain.WalletCreation;
import com.digitalwallet.customerservice.domain.WalletCreationEventProducer;
import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCustomerByPersonalInformation {
    private final CustomerRepository customerRepository;
    private final WalletCreationEventProducer walletCreationEventProducer;

    @Transactional(rollbackFor = Exception.class)
    public void register(CustomerCreation customerCreation) {
        String documentNumber = cleanDocumentNumber(customerCreation.getDocumentNumber());
        Customer customer = createCustomerFromCreation(customerCreation, documentNumber);

        if (customerAlreadyExists(documentNumber, customerCreation.getPhoneNumber())) {
            throw new DigitalWalletGenericClientException("Customer already exists", HttpStatus.CONFLICT);
        }

        WalletCreation walletCreation = new WalletCreation("PEN", customer);
        customerRepository.register(customer);
        walletCreationEventProducer.sendWalletCreationEvent(walletCreation);
    }

    private String cleanDocumentNumber(String documentNumber) {
        // Realiza limpieza u otras manipulaciones según sea necesario
        return documentNumber.replace("+", "");
    }

    private Customer createCustomerFromCreation(CustomerCreation customerCreation, String documentNumber) {
        return new Customer(
                documentNumber,
                customerCreation.getPhoneNumber(),
                customerCreation.getDocumentType(),
                customerCreation.getEmail(),
                customerCreation.getGivenNames(),
                customerCreation.getSurnames()
        );
    }

    private boolean customerAlreadyExists(String documentNumber, String phoneNumber) {
        return customerRepository
                .findByDocumentNumberOrPhoneNumber(documentNumber, phoneNumber)
                .isPresent();
    }
}
