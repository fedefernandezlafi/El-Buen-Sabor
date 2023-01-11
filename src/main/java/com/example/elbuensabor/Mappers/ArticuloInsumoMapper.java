package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.DTOs.ArticuloInsumoDTO;
import com.example.elbuensabor.Entidades.ArticuloInsumo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ArticuloInsumoMapper {

    private ModelMapper mapper = new ModelMapper();
    public List <ArticuloInsumoDTO> entidadesADTO(List <ArticuloInsumo> entidades ){

        return entidades.stream().map(articulos -> mapper.map(articulos,ArticuloInsumoDTO.class)).collect(Collectors.toList());

    }

    public List <ArticuloInsumo> DTOaEntidades(List <ArticuloInsumoDTO> dtos){

        return dtos.stream().map(entidades -> mapper.map(entidades,ArticuloInsumo.class)).collect(Collectors.toList());
    }

    public ArticuloInsumoDTO entidadADTO (ArticuloInsumo entidad){

        return ArticuloInsumoDTO.builder()
                .denominacion(entidad.getDenominacion())
                .precioCompra(entidad.getPrecioCompra())
                .precioVenta(entidad.getPrecioVenta())
                .stockActual(entidad.getStockActual())
                .stockMinimo(entidad.getStockMinimo())
                .unidadMedida(entidad.getUnidadMedida())
                .esInsumo(entidad.isEsInsumo())
                .build();
    }


    public ArticuloInsumo DTOaEntidad (ArticuloInsumoDTO dto){

        return ArticuloInsumo.builder()
                .denominacion(dto.getDenominacion())
                .precioCompra(dto.getPrecioCompra())
                .precioVenta(dto.getPrecioVenta())
                .stockActual(dto.getStockActual())
                .stockMinimo(dto.getStockMinimo())
                .unidadMedida(dto.getUnidadMedida())
                .esInsumo(dto.isEsInsumo())
                .build();
    }
}
