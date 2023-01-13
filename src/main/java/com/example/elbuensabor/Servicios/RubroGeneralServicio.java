package com.example.elbuensabor.Servicios;

import com.example.elbuensabor.DTOs.RubroGeneralDTO;
import com.example.elbuensabor.Entidades.RubroGeneral;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.RubroGeneralMapper;
import com.example.elbuensabor.Repositorios.RubroGeneralRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RubroGeneralServicio {

    @Autowired
    private RubroGeneralRepositorio repo;
    @Autowired
    private RubroGeneralMapper mapper;

    public RubroGeneralDTO crearRubroGeneral(RubroGeneralDTO dto){
        RubroGeneral rubroGeneral = mapper.DTOaEntidad(dto);
        repo.save(rubroGeneral);
        RubroGeneralDTO rubroGeneralCreada =  mapper.entidadADTO(rubroGeneral);
        return rubroGeneralCreada;
    }

    public RubroGeneralDTO actualizarRubroGeneral(RubroGeneralDTO dto, Long id) throws ErrorServicio {
        Optional<RubroGeneral> rubroGeneral= repo.findById(id);
        if(rubroGeneral.isPresent()){
            RubroGeneral rubroGeneralActualizado = rubroGeneral.get();
            rubroGeneralActualizado = mapper.DTOaEntidad(dto);
            RubroGeneralDTO rubroGeneralActualizadoDTO = mapper.entidadADTO(rubroGeneralActualizado);
            return rubroGeneralActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<RubroGeneralDTO> listarRubroGenerals(){
        List<RubroGeneral> rubroGenerals = repo.findAll();
        List<RubroGeneralDTO> rubroGeneralsDTO = mapper.entidadesADTO(rubroGenerals);
        return rubroGeneralsDTO;
    }
}

