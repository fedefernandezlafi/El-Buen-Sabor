package com.example.elbuensabor.DTOs;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioNoIdentificadoDTO {
    private boolean login = false;
    private String mensaje;
}
