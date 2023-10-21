package com.digitalwallet.authenticationservice.domain;

import com.digitalwallet.authenticationservice.domain.value_objects.DocumentNumber;
import com.digitalwallet.authenticationservice.domain.value_objects.LoginType;
import com.digitalwallet.authenticationservice.domain.value_objects.PhoneNumber;

public class Login {
    private LoginType loginType;
    private DocumentNumber documentNumber;
    private PhoneNumber phoneNumber;

    public Login(String loginType, String documentNumber, String phoneNumber) {
        this.loginType = new LoginType(loginType);
        this.documentNumber = new DocumentNumber(documentNumber);
        this.phoneNumber = new PhoneNumber(phoneNumber);
    }

    public String getLoginType() {
        return loginType.value();
    }

    public String getDocumentNumber() {
        return documentNumber.value();
    }

    public String getPhoneNumber() {
        return phoneNumber.value();
    }
}
