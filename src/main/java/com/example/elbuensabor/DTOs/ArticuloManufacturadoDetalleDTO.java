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
public class ArticuloManufacturadoDetalleDTO {

    @NotNull(message = "La cantidad no puede ser nula")
    @NotEmpty(message = "La cantidad no puede estar vacia")
    @Size(min = 0, message = "La cantidad no puede ser menor que 0")
    private double cantidad;
    @NotNull(message = "La unidad de medida no puede ser nula")
    @NotEmpty(message = "La unidad de medida no puede estar vacia")
    private String unidadMedida;
}
