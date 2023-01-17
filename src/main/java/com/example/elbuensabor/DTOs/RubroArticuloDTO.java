package com.example.elbuensabor.DTOs;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class RubroArticuloDTO {

    @NotNull(message = "La denominacion no puede ser nula")
    @NotEmpty(message = "La denominacion no puede estar vacia")
    private String denominacion;
}
