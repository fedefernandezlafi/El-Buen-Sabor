package com.example.elbuensabor.DTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioDTO {

    @NotNull(message = "La calle no puede ser nula")
    @NotEmpty(message = "La calle no puede estar vacia")
    private String calle;

    @NotNull(message = "La numeración no puede ser nula")
    @NotEmpty(message = "La numeración no puede estar vacia")
    @Size(min = 0, message = "La numeración no puede ser menor que 0")
    private int numero;

    @NotNull(message = "La localidad no puede ser nula")
    @NotEmpty(message = "La localidad no puede estar vacia")
    private String localidad;
}
