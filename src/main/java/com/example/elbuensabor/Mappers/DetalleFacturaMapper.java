package com.example.elbuensabor.Mappers;


import com.example.elbuensabor.DTOs.DetalleFacturaDTO;
import com.example.elbuensabor.Entidades.DetalleFactura;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DetalleFacturaMapper {

    private ModelMapper mapper = new ModelMapper();
    public List<DetalleFacturaDTO> entidadesADTO(List <DetalleFactura> entidades ){

        return entidades.stream().map(facturas -> mapper.map(facturas,DetalleFacturaDTO.class)).collect(Collectors.toList());

    }

    public List <DetalleFactura> DTOaEntidades(List <DetalleFacturaDTO> dtos){

        return dtos.stream().map(entidades -> mapper.map(entidades,DetalleFactura.class)).collect(Collectors.toList());
    }

    public DetalleFacturaDTO entidadADTO (DetalleFactura entidad){

        return DetalleFacturaDTO.builder()
                .cantidad(entidad.getCantidad())
                .subTotal(entidad.getSubTotal())
                .build();
    }


    public DetalleFactura DTOaEntidad (DetalleFacturaDTO dto){

        return DetalleFactura.builder()
                .cantidad(dto.getCantidad())
                .subTotal(dto.getSubTotal())
                .build();
    }
}
