package com.digitalwallet.customerservice.infrastructure;

import com.digitalwallet.customerservice.domain.Customer;
import com.digitalwallet.customerservice.domain.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerMongoRepository mongoRepository;
    private final PersistenceMapper persistenceMapper;

    @Override
    public Customer register(Customer customer) {
        CustomerDocument customerDocument = mongoRepository.save(persistenceMapper.toDocument(customer));
        return persistenceMapper.toDomain(customerDocument);
    }

    @Override
    public Optional<Customer> findByDocumentNumberOrPhoneNumber(String documentNumber, String phoneNumber) {
        Function<CustomerDocument, Customer> customerDocumentToCustomer = persistenceMapper::toDomain;

        Optional<CustomerDocument> customerDocumentFoundOptional = mongoRepository
                .findByDocumentNumberOrPhoneNumber(documentNumber, phoneNumber);
        Optional<Customer> customerOptional = customerDocumentFoundOptional.map(customerDocumentToCustomer);
        return customerOptional;
    }

    /* TODO: Eliminar método - Ambos métodos son equivalentes POO equivalente a Programacion Funcional
    Function<CustomerDocument, Customer> customerDocumentToCustomer = persistenceMapper::toDomain;
    private Customer DocumentToCustomer(CustomerDocument document) {
        return persistenceMapper.toDomain(document);
    }*/
}
