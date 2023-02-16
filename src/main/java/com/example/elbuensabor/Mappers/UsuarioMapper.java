package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.DTOs.ProductoDTO;
import com.example.elbuensabor.DTOs.UsuarioDTO;
import com.example.elbuensabor.Entidades.Usuario;
import com.example.elbuensabor.Repositorios.RolRepositorio;
import com.example.elbuensabor.Repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    private ModelMapper mapper = new ModelMapper();
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private RolRepositorio rolRepositorio;

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
                .rolId(entidad.getRol().getId())
                .build();
    }

    public List<Usuario> DTOaEntidades( List<UsuarioDTO> dtos) {
        List<Usuario> lista = new ArrayList<>();
        dtos.stream().forEach(dto ->
            lista.add(Usuario.builder()
                    .usuario(dto.getUsuario())
                    .clave(dto.getClave())
                    .rol(rolRepositorio.findById(dto.getRolId()).get())
                    .build()));
        return lista;
    }

    public List <UsuarioDTO> entidadesADTO (List<Usuario> entidades) {
        List<UsuarioDTO> lista = new ArrayList<>();
        entidades.stream().forEach(usuario ->
                lista.add(UsuarioDTO.builder()
                        .usuario(usuario.getUsuario())
                        .clave(usuario.getClave())
                                .rolId(usuario.getRol().getId())
                        .build()));
        return lista;

    }

}