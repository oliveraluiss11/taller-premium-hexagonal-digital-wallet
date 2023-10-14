package com.digitalwallet.movementservice.domain.value_objects;

import java.util.List;

public record TypeTransaction(String value) {
    public TypeTransaction(String value){
        this.value = value;
        this.ensureIsValid(value);
    }

    private void ensureIsValid(String value){
        List<String> typeTransactionList = List.of("TRANSFER");
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("El valor del tipo de transaction no puede ser nulo ni vacío");
        }
        if (!typeTransactionList.contains(value)){
            throw new IllegalArgumentException("El valor del tipo de transaction no es válida");
        }
    }
}
