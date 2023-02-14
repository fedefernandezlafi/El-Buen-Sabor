package com.example.elbuensabor.DTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RubroGeneralDTO {

    @NotNull(message = "La denominacion no puede ser nula")
    @NotEmpty(message = "La denominacion no puede estar vacia")
    private String denominacion;
}
