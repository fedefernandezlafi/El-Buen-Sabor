package com.example.elbuensabor.DTOs;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ClienteDTO {

    @NotNull(message = "El nombre no puede ser nulo")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotNull(message = "El apellido no puede ser nulo")
    @NotEmpty(message = "El apellido no puede estar vacio")
    private String apellido;

    @NotNull(message = "El telefono no puede ser nulo")
    @NotEmpty(message = "El telefono no puede estar vacio")
    private String telefono;

    @NotNull(message = "El email no puede ser nulo")
    @NotEmpty(message = "El email no puede estar vacio")
    @Email(message = "Formato de e-mail invalido")
    private String email;
}
