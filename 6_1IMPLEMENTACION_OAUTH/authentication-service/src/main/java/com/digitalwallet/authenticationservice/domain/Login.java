package com.digitalwallet.authenticationservice.domain;

import com.digitalwallet.authenticationservice.domain.value_objects.Credential;
import com.digitalwallet.authenticationservice.domain.value_objects.Pin;

public class Login {
    private Credential credential;
    private Pin pin;

    public Login(String credential, String pin) {
        this.credential = new Credential(credential);
        this.pin = new Pin(pin);
    }

    public String getCredential() {
        return credential.value();
    }

    public String getPin() {
        return this.pin.value();
    }
}
