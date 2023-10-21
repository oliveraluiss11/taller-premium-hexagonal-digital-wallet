package com.digitalwallet.authenticationservice.domain.value_objects;

import com.digitalwallet.authenticationservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public record LoginType(String value) {
    public LoginType(String value) {
        this.value = value;
        CustomerUtils.ensureIsNotNullOrBlank("Document type", value);
        this.ensureIsValidLoginType(value);
    }

    private void ensureIsValidLoginType(String value) {
        List<String> typeDocumentList = Arrays.asList("DNI", "PHONE");
        if (!typeDocumentList.contains(value)) {
            throw new DigitalWalletGenericClientException(String.format("Login type %s is invalid", value)
                    , HttpStatus.BAD_REQUEST);
        }
    }
}
