package com.digitalwallet.customerservice.domain;


import com.digitalwallet.customerservice.domain.value_object.DocumentNumber;
import com.digitalwallet.customerservice.domain.value_object.DocumentType;
import com.digitalwallet.customerservice.domain.value_object.Email;
import com.digitalwallet.customerservice.domain.value_object.Names;
import com.digitalwallet.customerservice.domain.value_object.PhoneNumber;

public class Customer {
    private String customerId;
    private DocumentNumber documentNumber;
    private PhoneNumber phoneNumber;
    private DocumentType documentType;
    private Email email;
    private Names givenNames;
    private Names surnames;
    public Customer(String customerId, String documentNumber, String phoneNumber, String documentType
            , String email, String givenNames, String surnames) {
        this.customerId = customerId;
        this.documentType = new DocumentType(documentType);
        this.email = new Email(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.documentNumber = new DocumentNumber(documentNumber);
        this.givenNames = new Names(givenNames);
        this.surnames = new Names(surnames);
    }
    public Customer(String documentNumber, String phoneNumber, String documentType
            , String email, String givenNames, String surnames) {
        this.documentType = new DocumentType(documentType);
        this.email = new Email(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.documentNumber = new DocumentNumber(documentNumber);
        this.givenNames = new Names(givenNames);
        this.surnames = new Names(surnames);
    }

    public String getDocumentType() {
        return this.documentType.value();
    }

    public String getGivenNames() {
        return this.givenNames.value();
    }

    public String getSurnames() {
        return this.surnames.value();
    }

    public String getEmail() {
        return this.email.value();
    }

    public String getDocumentNumber() {
        return this.documentNumber.value();
    }

    public String getPhoneNumber() {
        return this.phoneNumber.value();
    }
    public String getCustomerId() {return this.customerId;}
}
