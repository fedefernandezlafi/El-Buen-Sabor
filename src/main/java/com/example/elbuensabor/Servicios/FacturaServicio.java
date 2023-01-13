package com.example.elbuensabor.Servicios;

import com.example.elbuensabor.DTOs.FacturaDTO;
import com.example.elbuensabor.Entidades.Factura;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.FacturaMapper;
import com.example.elbuensabor.Repositorios.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio repo;
    @Autowired
    private FacturaMapper mapper;

    public FacturaDTO crearFactura(FacturaDTO dto){
        Factura factura = mapper.DTOaEntidad(dto);
        repo.save(factura);
        FacturaDTO facturaCreada =  mapper.entidadADTO(factura);
        return facturaCreada;
    }

    public FacturaDTO actualizarFactura(FacturaDTO dto, Long id) throws ErrorServicio {
        Optional<Factura> factura= repo.findById(id);
        if(factura.isPresent()){
            Factura facturaActualizado = factura.get();
            facturaActualizado = mapper.DTOaEntidad(dto);
            FacturaDTO facturaActualizadoDTO = mapper.entidadADTO(facturaActualizado);
            return facturaActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<FacturaDTO> listarFacturas(){
        List<Factura> facturas = repo.findAll();
        List<FacturaDTO> facturasDTO = mapper.entidadesADTO(facturas);
        return facturasDTO;
    }
}
