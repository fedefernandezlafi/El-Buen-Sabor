package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.DTOs.RubroGeneralDTO;
import com.example.elbuensabor.Entidades.RubroGeneral;
import com.example.elbuensabor.Repositorios.RubroGeneralRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RubroGeneralMapper {

    private ModelMapper mapper = new ModelMapper();
    private RubroGeneralRepositorio rubroGeneralRepositorio;


    public RubroGeneral DTOaEntidad(RubroGeneralDTO dto){
        return RubroGeneral.builder()
                .denominacion(dto.getDenominacion())
                .build();
    }

    public RubroGeneralDTO entidadADTO (RubroGeneral entidad) {
        return RubroGeneralDTO.builder()
                .denominacion(entidad.getDenominacion())
                .build();
    }


    public List<RubroGeneralDTO> entidadesADTO(List<RubroGeneral> entidades) {
        return entidades.stream().map(dtos -> mapper.map(entidades, RubroGeneralDTO.class))
                .collect(Collectors.toList());
    }

    public List<RubroGeneral> DTOaEntidades (List<RubroGeneralDTO> dtos) {
        return (dtos.stream().map(entidades -> mapper.map(dtos, RubroGeneral.class))
                .collect(Collectors.toList()));
    }
}
