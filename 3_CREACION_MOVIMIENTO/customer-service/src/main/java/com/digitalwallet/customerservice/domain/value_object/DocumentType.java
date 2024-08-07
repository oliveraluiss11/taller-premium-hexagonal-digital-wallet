package com.digitalwallet.customerservice.domain.value_object;

import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public record DocumentType(String value) {
    public DocumentType(String value){
        this.value = value;
        this.ensureIsValidTypeDocument(value);
    }
    private void ensureIsValidTypeDocument(String value){
        List<String> typeDocumentList = Arrays.asList("DNI");
        if (!typeDocumentList.contains(value)){
            throw new DigitalWalletGenericClientException("Document type is invalid"
                    , HttpStatus.BAD_REQUEST);
        }
    }
}
