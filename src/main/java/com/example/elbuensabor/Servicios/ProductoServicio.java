package com.example.elbuensabor.Servicios;

import com.example.elbuensabor.DTOs.ProductoDTO;
import com.example.elbuensabor.Entidades.ArticuloInsumo;
import com.example.elbuensabor.Entidades.ArticuloManufacturado;
import com.example.elbuensabor.Mappers.ProductoMapper;
import com.example.elbuensabor.Repositorios.ArticuloInsumoRepositorio;
import com.example.elbuensabor.Repositorios.ArticuloManufacturadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ArticuloManufacturadoRepositorio articuloManufacturadoRepositorio;

    @Autowired
    private ArticuloInsumoRepositorio articuloInsumoRepositorio;


    private ProductoMapper mapper = new ProductoMapper();


    public List<ProductoDTO> crearListaProductos () {

        List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
        List<ArticuloManufacturado> listaManufacturado = articuloManufacturadoRepositorio.findAll();
        List<ArticuloInsumo> listaInsumos = articuloInsumoRepositorio.getByEsInsumoFalse();
        lista.addAll(mapper.insumosADTO(listaInsumos));
        lista.addAll(mapper.manufacturadosADTO(listaManufacturado));
        return lista;
    }

}
