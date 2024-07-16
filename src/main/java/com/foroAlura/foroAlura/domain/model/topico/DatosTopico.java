package com.foroAlura.foroAlura.domain.model.topico;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotNull;

public record DatosTopico(
        @NotNull String título,
        @NotNull String mensaje,
        @NotNull @JsonAlias("creado") String fechaCreacion,
        @JsonAlias("estado") @NotNull Status status,
        @NotNull String autor,
        @NotNull String curso,
        String respuesta
) {
}
