package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.DTOs.UsuarioDTO;
import com.example.elbuensabor.Entidades.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    private ModelMapper mapper = new ModelMapper();

    public Usuario DTOaEntidad (UsuarioDTO dto) {
        return Usuario.builder()
                .usuario(dto.getUsuario())
                .clave(dto.getClave())
                .build();
    }

    public UsuarioDTO entidadADTO (Usuario entidad){
        return UsuarioDTO.builder()
                .usuario(entidad.getUsuario())
                .clave(entidad.getClave())
                .build();
    }

    public List<Usuario> DTOaEntidades( List<UsuarioDTO> dtos) {
        return dtos.stream().map(entidades -> mapper.map(dtos, Usuario.class))
                .collect(Collectors.toList());
    }

    public List <UsuarioDTO> entidadesADTO (List<Usuario> entidades) {
        return entidades.stream().map(dtos -> mapper.map(entidades, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

}