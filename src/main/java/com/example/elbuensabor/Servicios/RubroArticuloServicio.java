package com.example.elbuensabor.Servicios;

import com.example.elbuensabor.DTOs.RubroArticuloDTO;
import com.example.elbuensabor.Entidades.RubroArticulo;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.RubroArticuloMapper;
import com.example.elbuensabor.Repositorios.RubroArticuloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RubroArticuloServicio {

    @Autowired
    private RubroArticuloRepositorio repo;
    @Autowired
    private RubroArticuloMapper mapper;

    public RubroArticuloDTO crearRubroArticulo(RubroArticuloDTO dto){
        RubroArticulo rubroArticulo = mapper.DTOaEntidad(dto);
        repo.save(rubroArticulo);
        RubroArticuloDTO rubroArticuloCreada =  mapper.entidadADTO(rubroArticulo);
        return rubroArticuloCreada;
    }

    public RubroArticuloDTO actualizarRubroArticulo(RubroArticuloDTO dto, Long id) throws ErrorServicio {
        Optional<RubroArticulo> rubroArticulo= repo.findById(id);
        if(rubroArticulo.isPresent()){
            RubroArticulo rubroArticuloActualizado = rubroArticulo.get();
            rubroArticuloActualizado = mapper.DTOaEntidad(dto);
            RubroArticuloDTO rubroArticuloActualizadoDTO = mapper.entidadADTO(rubroArticuloActualizado);
            return rubroArticuloActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<RubroArticuloDTO> listarRubroArticulos(){
        List<RubroArticulo> rubroArticulos = repo.findAll();
        List<RubroArticuloDTO> rubroArticulosDTO = mapper.entidadesADTO(rubroArticulos);
        return rubroArticulosDTO;
    }
}
