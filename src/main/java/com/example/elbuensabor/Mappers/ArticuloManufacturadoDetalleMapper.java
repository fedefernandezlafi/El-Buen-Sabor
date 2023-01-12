package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.DTOs.ArticuloManufacturadoDetalleDTO;
import com.example.elbuensabor.Entidades.ArticuloManufacturadoDetalle;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticuloManufacturadoDetalleMapper {


    private ModelMapper mapper = new ModelMapper();

    public List<ArticuloManufacturadoDetalleDTO> entidadesADTO(List<ArticuloManufacturadoDetalle> entidades){
        return entidades.stream().map(articulos -> mapper.map(articulos, ArticuloManufacturadoDetalleDTO.class)).collect(Collectors.toList());
    }

    public List<ArticuloManufacturadoDetalle> DTOaEntidades(List<ArticuloManufacturadoDetalleDTO> entidades){
        return entidades.stream().map(articulos -> mapper.map(articulos, ArticuloManufacturadoDetalle.class)).collect(Collectors.toList());
    }

    public ArticuloManufacturadoDetalleDTO entidadADTO(ArticuloManufacturadoDetalle entidad){

        return ArticuloManufacturadoDetalleDTO.builder()
                .cantidad(entidad.getCantidad())
                .unidadMedida(entidad.getUnidadMedida())
                .build();

    }

    public ArticuloManufacturadoDetalle DTOaEntidad(ArticuloManufacturadoDetalleDTO dto){

        return ArticuloManufacturadoDetalle.builder()
                .cantidad(dto.getCantidad())
                .unidadMedida(dto.getUnidadMedida())
                .build();

    }
}
