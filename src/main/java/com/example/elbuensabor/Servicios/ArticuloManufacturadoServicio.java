package com.example.elbuensabor.Servicios;


import com.example.elbuensabor.DTOs.ArticuloManufacturadoDTO;
import com.example.elbuensabor.Entidades.ArticuloManufacturado;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.ArticuloManufacturadoMapper;
import com.example.elbuensabor.Repositorios.ArticuloManufacturadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloManufacturadoServicio {

    @Autowired
    private ArticuloManufacturadoRepositorio repo;
    @Autowired
    private ArticuloManufacturadoMapper mapper;

    public ArticuloManufacturadoDTO crearArticuloManufacturado(ArticuloManufacturadoDTO dto){
        ArticuloManufacturado articuloManufacturado = mapper.DTOaEntidad(dto);
        repo.save(articuloManufacturado); //
        ArticuloManufacturadoDTO articuloCreado =  mapper.entidadADTO(articuloManufacturado);
        return articuloCreado;
    }

    public ArticuloManufacturadoDTO actualizarArticuloManufacturado(ArticuloManufacturadoDTO dto, Long id) throws ErrorServicio {
        Optional<ArticuloManufacturado> articuloManufacturado= repo.findById(id);
        if(articuloManufacturado.isPresent()){
            ArticuloManufacturado articuloManufacturadoActualizado = articuloManufacturado.get();
            articuloManufacturadoActualizado = mapper.DTOaEntidad(dto);
            repo.save(articuloManufacturadoActualizado);
            ArticuloManufacturadoDTO articuloActualizadoDTO = mapper.entidadADTO(articuloManufacturadoActualizado);
            return articuloActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<ArticuloManufacturadoDTO> listarArticuloManufacturado(){

        List<ArticuloManufacturado> articulos = repo.findAll();
        List<ArticuloManufacturadoDTO> articulosDTO = mapper.entidadesADTO(articulos);
        return articulosDTO;
    }
}
