package com.digitalwallet.movementreactiveservice.domain.value_objects;

public record UUID(String value) {
    public UUID(String value){
        this.value = value;
        this.ensureIsValid(value);
    }
    private void ensureIsValid(String value){
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("El valor UUID no puede ser nulo ni vacío");
        }
    }

}
