package com.example.elbuensabor.DTOs;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PedidoDTO {

    private LocalDate fecha;
    private int numero;
    private String estado;

    private LocalDate horaEstimadaFin;

    private String tipoEnvio;
}
