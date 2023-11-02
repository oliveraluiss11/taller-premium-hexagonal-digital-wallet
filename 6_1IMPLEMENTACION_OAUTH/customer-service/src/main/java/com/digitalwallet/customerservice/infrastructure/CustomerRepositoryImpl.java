package com.digitalwallet.customerservice.infrastructure;

import com.digitalwallet.customerservice.domain.Customer;
import com.digitalwallet.customerservice.domain.CustomerRepository;
import com.digitalwallet.customerservice.domain.WalletCreation;
import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletError;
import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerMongoRepository mongoRepository;
    private final WalletAPIRepository walletAPIRepository;
    private final PersistenceMapper persistenceMapper;

    @Override
    public void register(Customer customer) {
        CustomerDocument customerDocument = mongoRepository.save(persistenceMapper.toDocument(customer));
        handleWalletApiResponse(walletAPIRepository.createWallet(new WalletCreation("PEN", customer)));
        persistenceMapper.toDomain(customerDocument);
    }

    private void handleWalletApiResponse(ResponseEntity<?> response) {
        if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
            DigitalWalletError errorBody = (DigitalWalletError) response.getBody();
            HttpStatus httpStatus = HttpStatus.valueOf(response.getStatusCode().value());
            throw new DigitalWalletGenericClientException(errorBody.getMessage(), httpStatus);
        }
    }

    @Override
    public Optional<Customer> findByDocumentNumberOrPhoneNumber(String documentNumber, String phoneNumber) {
        Function<CustomerDocument, Customer> customerDocumentToCustomer = persistenceMapper::toDomain;

        Optional<CustomerDocument> customerDocumentFoundOptional = mongoRepository
                .findByDocumentNumberOrPhoneNumber(documentNumber, phoneNumber);
        return customerDocumentFoundOptional.map(customerDocumentToCustomer);
    }
}
