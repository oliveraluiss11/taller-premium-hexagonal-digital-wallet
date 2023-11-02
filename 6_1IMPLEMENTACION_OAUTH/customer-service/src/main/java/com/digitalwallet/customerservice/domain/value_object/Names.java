package com.digitalwallet.customerservice.domain.value_object;

import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

import java.util.Objects;

public record Names(String value) {
    public Names(String value) {
        this.value = value;
        CustomerUtils.ensureIsNotNullOrBlank("Names or Surnames",value);
        this.ensureIsValidName(value);
    }



    private void ensureIsValidName(String value) {
        if (!value.matches("^[A-Za-záéíóúÁÉÍÓÚüÜñÑ'\\s]+([A-Za-záéíóúÁÉÍÓÚüÜñÑ'\\s]+)*$"))
            throw new DigitalWalletGenericClientException("Names is invalid"
                    , HttpStatus.BAD_REQUEST);
    }
}
