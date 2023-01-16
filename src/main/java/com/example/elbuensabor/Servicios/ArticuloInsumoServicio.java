package com.example.elbuensabor.Servicios;


import com.example.elbuensabor.DTOs.ArticuloInsumoDTO;
import com.example.elbuensabor.Entidades.ArticuloInsumo;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.ArticuloInsumoMapper;
import com.example.elbuensabor.Repositorios.ArticuloInsumoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloInsumoServicio {

    @Autowired
    private ArticuloInsumoRepositorio repo;
    @Autowired
    private ArticuloInsumoMapper mapper;

    public ArticuloInsumoDTO crearArticuloInsumo(ArticuloInsumoDTO dto){
        ArticuloInsumo articuloInsumo = mapper.DTOaEntidad(dto); // crea articulo insumo, convierte el dto en entidad
        repo.save(articuloInsumo); // Guardamos la entidad en la base de datos
        ArticuloInsumoDTO articuloCreado =  mapper.entidadADTO(articuloInsumo); // Agarramos la entidad y la transformamos en dto para mostrarla
        return articuloCreado;
    }

    public ArticuloInsumoDTO actualizarArticuloInsumo(ArticuloInsumoDTO dto, Long id) throws ErrorServicio {
        Optional<ArticuloInsumo> articuloInsumo = repo.findById(id);
        if(articuloInsumo.isPresent()){
            ArticuloInsumo articuloInsumoActualizado = articuloInsumo.get();// Instaciamos un articulo insumo nuevo y le ponemos los datos del que trajimos en la DB
            articuloInsumoActualizado = mapper.DTOaEntidad(dto);
            ArticuloInsumoDTO articuloActualizadoDTO = mapper.entidadADTO(articuloInsumoActualizado);// creamos un DTO con los datos actualizados para mostrarlo
            return articuloActualizadoDTO;
        }
                throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<ArticuloInsumoDTO> listarArticuloInsumo(){

        List<ArticuloInsumo> articulos = repo.findAll();
        List<ArticuloInsumoDTO> articulosDTO = mapper.entidadesADTO(articulos);
        return articulosDTO;
    }



}
