package com.example.elbuensabor.DTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDTO {

    @NotNull(message = "La fecha no puede ser nula")
    @NotEmpty(message = "La fecha no puede estar vacia")
    private LocalDate fecha;
    @NotNull(message = "La numeración no puede ser nula")
    @NotEmpty(message = "La numeración no puede estar vacia")
    private int numero;


    private double montoDescuento;

    @NotNull(message = "La forma de pago no puede ser nula")
    @NotEmpty(message = "La forma de pago no puede estar vacia")
    private String formaPago;

    @NotNull(message = "El numero de tarjeta no puede ser nulo")
    @NotEmpty(message = "El numero de tarjeta no puede estar vacio")
    private String nroTarjeta;

    @NotNull(message = "El total de la venta no puede ser nulo")
    @NotEmpty(message = "El total de la venta no puede estar vacio")
    @Size(min = 0, message = "El total de la venta no puede ser menor que 0")
    private double totalVenta;

    @NotNull(message = "El costo total no puede ser nulo")
    @NotEmpty(message = "El costo total no puede estar vacio")
    @Size(min = 0, message = "El costo total no puede ser menor que 0")
    private double totalCosto;
}
