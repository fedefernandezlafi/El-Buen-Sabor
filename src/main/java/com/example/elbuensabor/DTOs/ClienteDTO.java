package com.example.elbuensabor.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
