package com.example.elbuensabor.DTOs;

import com.example.elbuensabor.Entidades.DetallePedido;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
public class PedidoDTO {
    private LocalDate fecha;
    private String estado;
    private LocalDate horaEstimadaFin;
    @NotNull(message = "El tipo de envio no puede ser nulo")
    @NotEmpty(message = "El tipo de envio no puede estar vacio")
    private String tipoEnvio;
    private DetallePedido detallePedido;
}
