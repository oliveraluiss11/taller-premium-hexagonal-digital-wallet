package com.digitalwallet.movementservice.domain.value_objects;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public record Money(BigDecimal value) {
    public Money(BigDecimal value){
        this.value = value;
        this.ensureIsValid(value);
    }

    private void ensureIsValid(BigDecimal value){
        if (value == null) {
            throw new IllegalArgumentException("El valor no puede ser nulo");
        }
        String valueStr = value.toString();
        // Utilizamos una expresión regular para verificar que el valor tenga dos decimales
        if (!Pattern.matches("^-?\\d+\\.\\d{2}$", valueStr)) {
            throw new IllegalArgumentException("El valor debe ser un número con dos decimales");
        }
    }
}
