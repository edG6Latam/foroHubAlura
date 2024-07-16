package com.foroAlura.foroAlura.infra.error;

import org.springframework.validation.FieldError;

public record DatosError(String login , String clave) {
    public DatosError(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
