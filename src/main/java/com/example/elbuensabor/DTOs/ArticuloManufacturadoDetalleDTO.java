package com.example.elbuensabor.DTOs;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticuloManufacturadoDetalleDTO {

    private double cantidad;
    private String unidadMedida;
}
