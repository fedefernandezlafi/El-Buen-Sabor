package com.example.elbuensabor.Servicios;


import com.example.elbuensabor.DTOs.DetalleFacturaDTO;
import com.example.elbuensabor.Entidades.DetalleFactura;
import com.example.elbuensabor.Excepciones.ErrorServicio;

import com.example.elbuensabor.Mappers.DetalleFacturaMapper;
import com.example.elbuensabor.Repositorios.DetalleFacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaServicio {

    @Autowired
    private DetalleFacturaRepositorio repo;
    @Autowired
    private DetalleFacturaMapper mapper;

    public DetalleFacturaDTO crearDetalleFactura(DetalleFacturaDTO dto){
        DetalleFactura detalleFactura = mapper.DTOaEntidad(dto);
        repo.save(detalleFactura);
        DetalleFacturaDTO detalleFacturaCreado =  mapper.entidadADTO(detalleFactura);
        return detalleFacturaCreado;
    }

    public DetalleFacturaDTO actualizarDetalleFactura(DetalleFacturaDTO dto, Long id) throws ErrorServicio {
        Optional<DetalleFactura> detalleFactura= repo.findById(id);
        if(detalleFactura.isPresent()){
            DetalleFactura detalleFacturaActualizado = detalleFactura.get();
            detalleFacturaActualizado = mapper.DTOaEntidad(dto);
            repo.save(detalleFacturaActualizado);
            DetalleFacturaDTO detalleFacturaActualizadoDTO = mapper.entidadADTO(detalleFacturaActualizado);
            return detalleFacturaActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<DetalleFacturaDTO> listarDetalleFacturas(){

        List<DetalleFactura> facturas = repo.findAll();
        List<DetalleFacturaDTO> facturasDTO = mapper.entidadesADTO(facturas);
        return facturasDTO;
    }
}
