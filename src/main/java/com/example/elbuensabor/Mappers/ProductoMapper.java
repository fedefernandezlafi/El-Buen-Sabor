package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.Entidades.ArticuloInsumo;
import com.example.elbuensabor.Entidades.ArticuloManufacturado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.example.elbuensabor.DTOs.ProductoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductoMapper {
    private ModelMapper mapper = new ModelMapper();

    public List<ProductoDTO> insumosADTO (List<ArticuloInsumo> listaInsumos) {
        List<ProductoDTO> lista = new ArrayList<>();
        listaInsumos.stream().forEach(insumo ->
                lista.add(ProductoDTO.builder()
                        .denominacion(insumo.getDenominacion())
                        .precioVenta(insumo.getPrecioVenta())
                        .build()));
        return lista;

    }

    public List<ProductoDTO> manufacturadosADTO (List<ArticuloManufacturado> listaManufacturados) {
        List<ProductoDTO> lista = new ArrayList<>();
        listaManufacturados.stream().forEach(manufacturado ->
                lista.add(ProductoDTO.builder()
                        .denominacion(manufacturado.getDenominacion())
                        .imagen(manufacturado.getImagen())
                        .precioVenta(manufacturado.getPrecioVenta())
                        .build()));
        return lista;
    }

}
