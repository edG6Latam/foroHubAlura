package com.foroAlura.foroAlura.domain.model.usuario;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DatosUsuario(
       @NotNull String login,
        @NotNull String clave,
        @JsonAlias("rol")
        RoleEnum roleEnum
) {
}
