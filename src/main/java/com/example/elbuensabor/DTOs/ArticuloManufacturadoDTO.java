package com.example.elbuensabor.DTOs;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class ArticuloManufacturadoDTO {

    @NotNull(message = "El tiempo estimado de cocina no puede ser nulo")
    @NotEmpty(message = "El tiempo estimado de cocina no puede estar vacio")
    @Size(min = 0, message = "El tiempo estimado de cocina no puede ser menor que 0")
    private int tiempoEstimadoCocina;

    @NotNull (message = "La denominacion no puede ser nula")
    @NotEmpty (message = "La denominacion no puede estar vacia")
    private String denominacion;
    @NotNull (message = "El precio de venta no puede ser nulo")
    @NotEmpty (message = "El precio de venta no puede estar vacio")
    @Size(min = 0, message = "El precio de compra no puede ser menor que 0")
    private double precioVenta;

    @NotNull(message = "La imagen no puede ser nula")
    @NotEmpty(message = "La imagen no puede estar vacia")
    private String imagen;
}
