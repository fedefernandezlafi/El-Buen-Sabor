package com.example.elbuensabor.DTOs;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
public class PedidoDTO {
    @NotNull(message = "La fecha no puede ser nula")
    @NotEmpty(message = "La fecha no puede estar vacia")
    private LocalDate fecha;

    @NotNull(message = "La numeración no puede ser nula")
    @NotEmpty(message = "La numeración no puede estar vacia")
    @Size(min = 0, message = "La numeración no puede ser menor que 0")
    private int numero;

    @NotNull(message = "El estado no puede ser nulo")
    @NotEmpty(message = "El estado no puede estar vacio")
    private String estado;

    @NotNull(message = "La hora estimada de finalizacion no puede ser nula")
    @NotEmpty(message = "La hora estimada de finalizacion no puede estar vacia")
    private LocalDate horaEstimadaFin;
    @NotNull(message = "El tipo de envio no puede ser nulo")
    @NotEmpty(message = "El tipo de envio no puede estar vacio")
    private String tipoEnvio;
}
