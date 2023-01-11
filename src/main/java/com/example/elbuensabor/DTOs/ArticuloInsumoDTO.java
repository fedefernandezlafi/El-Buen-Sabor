package com.example.elbuensabor.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticuloInsumoDTO {

    private String denominacion;
    private double precioCompra;
    private double precioVenta;
    private double stockActual;
    private double stockMinimo;
    private String unidadMedida;
    private boolean esInsumo;
}
