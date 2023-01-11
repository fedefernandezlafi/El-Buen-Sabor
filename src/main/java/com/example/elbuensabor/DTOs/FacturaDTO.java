package com.example.elbuensabor.DTOs;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FacturaDTO {

    private LocalDate fecha;
    private int numero;
    private double montoDescuento;
    private String formaPago;
    private String nroTarjeta;
    private double totalVenta;
    private double totalCosto;
}
