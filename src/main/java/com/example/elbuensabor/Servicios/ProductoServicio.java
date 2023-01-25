package com.example.elbuensabor.Servicios;

import com.example.elbuensabor.DTOs.ProductoDTO;
import com.example.elbuensabor.Entidades.ArticuloInsumo;
import com.example.elbuensabor.Entidades.ArticuloManufacturado;
import com.example.elbuensabor.Mappers.ProductoMapper;
import com.example.elbuensabor.Repositorios.ArticuloInsumoRepositorio;
import com.example.elbuensabor.Repositorios.ArticuloManufacturadoRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServicio {

    private ArticuloManufacturadoRepositorio articuloManufacturadoRepositorio;

    private ArticuloInsumoRepositorio articuloInsumoRepositorio;

    private ProductoMapper mapper = new ProductoMapper();

    public List<ProductoDTO> crearListaProductos () {

        List<ProductoDTO> lista = new ArrayList<>();
        List<ArticuloManufacturado> listaManufacturado = articuloInsumoRepositorio.findAll();
        List<ArticuloInsumo> listaInsumos = articuloInsumoRepositorio.findByEsInsumo(false);
        lista.addAll(mapper.insumosADTO(listaInsumos));
        lista.addAll(mapper.manufacturadosADTO(listaManufacturado));
        return lista;
    }
}