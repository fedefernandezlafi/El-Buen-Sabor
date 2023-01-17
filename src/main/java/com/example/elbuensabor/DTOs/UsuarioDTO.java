package com.example.elbuensabor.DTOs;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UsuarioDTO {

    @NotNull(message = "El usuario no puede ser nulo")
    @NotEmpty(message = "El usuario no puede estar vacio")
    private String usuario;

    @NotNull(message = "La clave no puede ser nula")
    @NotEmpty(message = "La clave no puede estar vacia")
    private String clave;

    @NotNull(message = "El rol no puede ser nulo")
    @NotEmpty(message = "El rol no puede estar vacio")
    private String rol;
}
