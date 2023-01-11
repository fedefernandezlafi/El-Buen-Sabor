package com.example.elbuensabor.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticuloManufacturadoDTO {

    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private String imagen;
}
