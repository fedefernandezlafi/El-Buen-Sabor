package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.DTOs.ArticuloInsumoDTO;
import com.example.elbuensabor.DTOs.DomicilioDTO;
import com.example.elbuensabor.Entidades.Domicilio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DomicilioMapper {

    private ModelMapper mapper = new ModelMapper();

    public Domicilio DTOaEntidad(DomicilioDTO dto) {
        return Domicilio.builder()
                .calle(dto.getCalle())
                .numero(dto.getNumero())
                .localidad(dto.getLocalidad())
                .build();
    }

    public DomicilioDTO entidadADTO(Domicilio domicilio) {
        return DomicilioDTO.builder()
                .calle(domicilio.getCalle())
                .numero(domicilio.getNumero())
                .localidad(domicilio.getLocalidad())
                .build();
    }

    public List<Domicilio> DTOaEntidades(List<DomicilioDTO> dtos) {
        return dtos.stream().map(entidades -> mapper.map(entidades, Domicilio.class))
                .collect(Collectors.toList());
    }

    public List<DomicilioDTO> entidadesADTO(List<Domicilio> entidades) {
        return entidades.stream().map(dtos -> mapper.map(dtos, DomicilioDTO.class))
                .collect(Collectors.toList());
    }
}