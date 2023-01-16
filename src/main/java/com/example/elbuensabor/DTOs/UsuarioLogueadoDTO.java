package com.example.elbuensabor.DTOs;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UsuarioLogueadoDTO {
    private String usuario;
    private String clave;




}
