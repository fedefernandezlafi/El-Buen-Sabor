package com.example.elbuensabor.Servicios;


import com.example.elbuensabor.DTOs.DomicilioDTO;
import com.example.elbuensabor.Entidades.Domicilio;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.DomicilioMapper;
import com.example.elbuensabor.Repositorios.DomicilioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class DomicilioServicio {


    @Autowired
    private DomicilioRepositorio repo;
    @Autowired
    private DomicilioMapper mapper;

    public DomicilioDTO crearDomicilio(DomicilioDTO dto){
        Domicilio domicilio = mapper.DTOaEntidad(dto);
        repo.save(domicilio);
        DomicilioDTO domicilioCreado =  mapper.entidadADTO(domicilio);
        return domicilioCreado;
    }

    public DomicilioDTO actualizarDomicilio(DomicilioDTO dto, Long id) throws ErrorServicio {
        Optional<Domicilio> domicilio= repo.findById(id);
        if(domicilio.isPresent()){
            Domicilio domicilioActualizado = domicilio.get();
            domicilioActualizado = mapper.DTOaEntidad(dto);
            DomicilioDTO domicilioActualizadoDTO = mapper.entidadADTO(domicilioActualizado);
            return domicilioActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<DomicilioDTO> listarDomicilios(){

        List<Domicilio> domicilios = repo.findAll();
        List<DomicilioDTO> domiciliosDTO = mapper.entidadesADTO(domicilios);
        return domiciliosDTO;
    }
}
