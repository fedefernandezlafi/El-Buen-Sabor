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
    private final RubroGeneralRepositorio rubroGeneralRepositorio;

    public RubroGeneralMapper(RubroGeneralRepositorio rubroGeneralRepositorio) {
        this.rubroGeneralRepositorio = rubroGeneralRepositorio;
    }

    public RubroGeneral dtoAEntidad(RubroGeneralDTO dto){
        return RubroGeneral.builder()
                .denominacion(dto.getDenominacion())
                .build();
    }

    public RubroGeneralDTO entidadADTO (RubroGeneral entidad) {
        return RubroGeneralDTO.builder()
                .denominacion(entidad.getDenominacion())
                .build();
    }

    public List<RubroGeneral> dtosAEntidades (List<RubroGeneralDTO> dtos) {
        return dtos.stream().map(entidades -> mapper.map(dtos, RubroGeneral.class))
                .collect(Collectors.toList());
    }

    public List<RubroGeneralDTO> entidadesadtos(List<RubroGeneral> entidades) {
        return entidades.stream().map(dtos -> mapper.map(entidades, RubroGeneralDTO.class))
                .collect(Collectors.toList());
    }

    public List<RubroGeneral> dtosAEntidades (List<RubroGeneralDTO> dtos) {
        return (dtos.stream().map(entidades -> mapper.map(dtos, RubroGeneral.class))
                .collect(Collectors.toList()));
    }
}
