package com.example.elbuensabor.DTOs;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetallePedidoDTO {

    private int cantidad;
    private double subTotal;
}
