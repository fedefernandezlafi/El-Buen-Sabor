package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.DTOs.RubroArticuloDTO;
import com.example.elbuensabor.Entidades.RubroArticulo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class RubroArticuloMapper {
    private ModelMapper mapper = new ModelMapper();

    public RubroArticulo DTOaEntidad (RubroArticuloDTO dto) {
        return RubroArticulo.builder()
                .denominacion(dto.getDenominacion())
                .build();
    }

    public RubroArticuloDTO entidadADTO (RubroArticulo entidad) {
        return RubroArticuloDTO.builder()
                .denominacion(entidad.getDenominacion())
                .build();
    }

    public List<RubroArticulo> DTOaEntidades (List <RubroArticuloDTO> dtos) {
        return dtos.stream().map(entidades -> mapper.map(dtos, RubroArticulo.class))
                .collect(Collectors.toList());
    }

    public List<RubroArticuloDTO> entidadesADTO (List <RubroArticulo> entidades) {
        return entidades.stream().map(dto -> mapper.map(entidades, RubroArticuloDTO.class))
                .collect(Collectors.toList());
    }
}
