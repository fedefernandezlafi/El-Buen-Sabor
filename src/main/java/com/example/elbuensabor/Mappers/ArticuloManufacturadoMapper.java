package com.example.elbuensabor.Mappers;



import com.example.elbuensabor.DTOs.ArticuloManufacturadoDTO;

import com.example.elbuensabor.Entidades.ArticuloManufacturado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticuloManufacturadoMapper {

    private ModelMapper mapper = new ModelMapper();

    public List<ArticuloManufacturadoDTO> entidadesADTO(List <ArticuloManufacturado> entidades ){

        return entidades.stream().map(articulos -> mapper.map(articulos,ArticuloManufacturadoDTO.class)).collect(Collectors.toList());

    }

    public List <ArticuloManufacturado> DTOaEntidades(List <ArticuloManufacturadoDTO> dtos){

        return dtos.stream().map(entidades -> mapper.map(entidades,ArticuloManufacturado.class)).collect(Collectors.toList());
    }

    public ArticuloManufacturadoDTO entidadADTO (ArticuloManufacturado entidad){

        return ArticuloManufacturadoDTO.builder()
                .tiempoEstimadoCocina(entidad.getTiempoEstimadoCocina())
                .denominacion(entidad.getDenominacion())
                .precioVenta(entidad.getPrecioVenta())
                .imagen(entidad.getImagen())
                .build();
    }


    public ArticuloManufacturado DTOaEntidad (ArticuloManufacturadoDTO dto){

        return ArticuloManufacturado.builder()
                .tiempoEstimadoCocina(dto.getTiempoEstimadoCocina())
                .denominacion(dto.getDenominacion())
                .precioVenta(dto.getPrecioVenta())
                .imagen(dto.getImagen())
                .build();
    }

}
