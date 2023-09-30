package com.digitalwallet.movementservice.domain.value_objects;

import java.util.List;

public record Currency(String value) {
    public Currency(String value){
        this.value = value;
        this.ensureIsValid(value);
    }

    private void ensureIsValid(String value){
        List<String> currencyList = List.of("USD","PEN");
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("El valor de la moneda no puede ser nulo ni vacío");
        }
        if (!currencyList.contains(value)){
            throw new IllegalArgumentException("El valor de la moneda de transaction no es válida");
        }
    }
}
