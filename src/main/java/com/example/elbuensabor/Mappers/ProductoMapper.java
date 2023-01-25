package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.Entidades.ArticuloInsumo;
import com.example.elbuensabor.Entidades.ArticuloManufacturado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.example.elbuensabor.DTOs.ProductoDTO;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductoMapper {
    private ModelMapper mapper = new ModelMapper();

    public List<ProductoDTO> insumosADTO (List<ArticuloInsumo> listaInsumos) {
        return listaInsumos.stream().map(prod -> mapper.map(listaInsumos, ProductoDTO.class)).
                collect(Collectors.toList());

    }

    public List<ProductoDTO> manufacturadosADTO (List<ArticuloManufacturado> listaManufacturados) {
        return listaManufacturados.stream().map(prod -> mapper.map(listaManufacturados, ProductoDTO.class)).
                collect(Collectors.toList());
    }
}
