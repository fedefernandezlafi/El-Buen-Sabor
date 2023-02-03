package com.example.elbuensabor.Servicios;



import com.example.elbuensabor.DTOs.ArticuloManufacturadoDetalleDTO;
import com.example.elbuensabor.Entidades.ArticuloManufacturadoDetalle;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.ArticuloManufacturadoDetalleMapper;
import com.example.elbuensabor.Repositorios.ArticuloManufacturadoDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloManufacturadoDetalleServicio {


    @Autowired
    private ArticuloManufacturadoDetalleRepositorio repo;
    @Autowired
    private ArticuloManufacturadoDetalleMapper mapper;

    public ArticuloManufacturadoDetalleDTO crearArticuloManufacturadoDetalle(ArticuloManufacturadoDetalleDTO dto){
        ArticuloManufacturadoDetalle articuloManufacturadoDetalle = mapper.DTOaEntidad(dto);
        repo.save(articuloManufacturadoDetalle);
        ArticuloManufacturadoDetalleDTO articuloCreado =  mapper.entidadADTO(articuloManufacturadoDetalle);
        return articuloCreado;
    }
    // Aca controlar si no funciona bien, crear una nueva entidad e igualar al save de del actualizado. y devolver
    // el un dto del actualizado.
    public ArticuloManufacturadoDetalleDTO actualizarArticuloManufacturadoDetalle(ArticuloManufacturadoDetalleDTO dto, Long id) throws ErrorServicio {
        Optional<ArticuloManufacturadoDetalle> articuloManufacturadoDetalle= repo.findById(id);
        if(articuloManufacturadoDetalle.isPresent()){
            ArticuloManufacturadoDetalle articuloManufacturadoDetalleActualizado = articuloManufacturadoDetalle.get();
            articuloManufacturadoDetalleActualizado = mapper.DTOaEntidad(dto);
            repo.save(articuloManufacturadoDetalleActualizado);
            ArticuloManufacturadoDetalleDTO articuloActualizadoDTO = mapper.entidadADTO(articuloManufacturadoDetalleActualizado);
            return articuloActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");
    }
    public List<ArticuloManufacturadoDetalleDTO> listarArticuloManufacturadoDetalle(){
        List<ArticuloManufacturadoDetalle> articulos = repo.findAll();
        List<ArticuloManufacturadoDetalleDTO> articulosDTO = mapper.entidadesADTO(articulos);
        return articulosDTO;
    }
}
