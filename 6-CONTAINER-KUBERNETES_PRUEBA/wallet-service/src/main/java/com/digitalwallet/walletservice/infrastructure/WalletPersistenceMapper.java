package com.digitalwallet.walletservice.infrastructure;

import com.digitalwallet.walletservice.domain.Customer;
import com.digitalwallet.walletservice.domain.Wallet;
import org.springframework.stereotype.Component;

@Component
public class WalletPersistenceMapper {
    public Wallet toDomain(WalletDocument walletDocument) {
        CustomerDocument customerDocument = walletDocument.getCustomer();
        Customer customer = new Customer(customerDocument.getDocumentNumber()
                , customerDocument.getPhoneNumber()
                , customerDocument.getDocumentType()
                , customerDocument.getEmail()
                , customerDocument.getGivenNames()
                , customerDocument.getSurnames());
        return new Wallet(walletDocument.getWalletId()
                , walletDocument.getBalance()
                , walletDocument.getCurrency()
                , customer);
    }

    public WalletDocument toDocument(Wallet wallet) {
        Customer customer = wallet.getCustomer();
        CustomerDocument customerDocument = new CustomerDocument(customer.getDocumentNumber()
                , customer.getPhoneNumber()
                , customer.getEmail()
                , customer.getGivenNames()
                , customer.getSurnames()
                , customer.getDocumentType());
        return new WalletDocument(wallet.getWalletId()
                , wallet.getBalance()
                , wallet.getCurrency()
                , customerDocument);
    }
}
