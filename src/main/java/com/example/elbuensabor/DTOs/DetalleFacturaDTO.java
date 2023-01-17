package com.example.elbuensabor.DTOs;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class DetalleFacturaDTO {

    @NotNull(message = "La cantidad no puede ser nula")
    @NotEmpty(message = "La cantidad no puede estar vacia")
    @Size(min = 0, message = "La cantidad no puede ser menor que 0")
    private int cantidad;

    @NotNull(message = "El subtotal no puede ser nulo")
    @NotEmpty(message = "El subtotal no puede estar vacio")
    @Size(min = 0, message = "El subtotal no puede ser menor que 0")
    private double subTotal;
}
