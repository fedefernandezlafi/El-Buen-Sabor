package com.example.elbuensabor.Servicios;

import com.example.elbuensabor.DTOs.UsuarioDTO;
import com.example.elbuensabor.Entidades.Usuario;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.UsuarioMapper;
import com.example.elbuensabor.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio repo;
    @Autowired
    private UsuarioMapper mapper;

    public UsuarioDTO crearUsuario(UsuarioDTO dto){
        Usuario usuario = mapper.DTOaEntidad(dto);
        repo.save(usuario);
        UsuarioDTO usuarioCreada =  mapper.entidadADTO(usuario);
        return usuarioCreada;
    }

    public UsuarioDTO actualizarUsuario(UsuarioDTO dto, Long id) throws ErrorServicio {
        Optional<Usuario> usuario= repo.findById(id);
        if(usuario.isPresent()){
            Usuario usuarioActualizado = usuario.get();
            usuarioActualizado = mapper.DTOaEntidad(dto);
            UsuarioDTO usuarioActualizadoDTO = mapper.entidadADTO(usuarioActualizado);
            return usuarioActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<UsuarioDTO> listarUsuarios(){
        List<Usuario> usuarios = repo.findAll();
        List<UsuarioDTO> usuariosDTO = mapper.entidadesADTO(usuarios);
        return usuariosDTO;
    }
}
