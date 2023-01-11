package com.example.elbuensabor.DTOs;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DomicilioDTO {

    private String calle;
    private int numero;
    private String localidad;
}
