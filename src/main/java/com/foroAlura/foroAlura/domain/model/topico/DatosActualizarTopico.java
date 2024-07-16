package com.foroAlura.foroAlura.domain.model.topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        String título,
        String mensaje,
        @JsonAlias("creado") String fechaCreacion,
        @JsonAlias("estado") Status status,
       String autor,
        String curso,
        String respuesta
) {
}
