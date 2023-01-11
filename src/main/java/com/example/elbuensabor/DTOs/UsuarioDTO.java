package com.example.elbuensabor.DTOs;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {

    private String usuario;
    private String clave;
    private String rol;
}
