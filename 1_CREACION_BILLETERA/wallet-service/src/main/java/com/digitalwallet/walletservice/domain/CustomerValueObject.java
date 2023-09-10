package com.digitalwallet.walletservice.domain;

import com.digitalwallet.walletservice.domain.value_object.DocumentNumber;
import com.digitalwallet.walletservice.domain.value_object.DocumentType;
import com.digitalwallet.walletservice.domain.value_object.Email;
import com.digitalwallet.walletservice.domain.value_object.Names;
import com.digitalwallet.walletservice.domain.value_object.PhoneNumber;

public class CustomerValueObject {
    private DocumentNumber documentNumber;
    private PhoneNumber phoneNumber;
    private DocumentType documentType;
    private Email email;
    private Names givenNames;
    private Names surnames;

    public CustomerValueObject(String documentNumber, String phoneNumber, String documentType
            , String email, String givenNames, String surnames) {
        this.documentType = new DocumentType(documentType);
        this.email = new Email(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.documentNumber = new DocumentNumber(documentNumber);
        this.givenNames = new Names(givenNames);
        this.surnames = new Names(surnames);
    }

    private String getDocumentType() {
        return this.documentType.value();
    }

    private String getGivenNames() {
        return this.givenNames.value();
    }

    private String getSurnames() {
        return this.surnames.value();
    }

    private String getEmail() {
        return this.email.value();
    }

    private String getDocumentNumber() {
        return this.documentNumber.value();
    }

    private String getPhoneNumber() {
        return this.phoneNumber.value();
    }
    public Customer toPlainObject(){
        return new Customer(this.givenNames.value()
                ,this.surnames.value()
                ,this.documentNumber.value()
                ,this.documentType.value()
                ,this.email.value()
                ,this.phoneNumber.value());
    }
}
