package com.digitalwallet.authenticationservice.domain.value_objects;

import com.digitalwallet.authenticationservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

import java.util.Objects;

public class CustomerUtils {
    public static void ensureIsNotNullOrBlank(String attribute, String value) {
        if (Objects.isNull(value) || value.isBlank())
            throw new DigitalWalletGenericClientException(attribute.concat(" value must not be null or empty "
            ), HttpStatus.BAD_REQUEST);
    }
}
