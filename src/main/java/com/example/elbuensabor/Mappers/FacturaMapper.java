package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.DTOs.FacturaDTO;
import com.example.elbuensabor.Entidades.Factura;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacturaMapper {
    private ModelMapper mapper = new ModelMapper();

    public Factura DTOaEntidad (FacturaDTO dto) {
        return Factura.builder()
                .fecha(dto.getFecha())
                .formaPago(dto.getFormaPago())
                .numero(dto.getNumero())
                .nroTarjeta(dto.getNroTarjeta())
                .montoDescuento(dto.getMontoDescuento())
                .totalCosto(dto.getTotalCosto())
                .totalVenta(dto.getTotalVenta())
                .build();
    }

    public FacturaDTO entidadADTO (Factura factura) {
        return FacturaDTO.builder()
                .fecha(factura.getFecha())
                .formaPago(factura.getFormaPago())
                .numero(factura.getNumero())
                .nroTarjeta(factura.getNroTarjeta())
                .montoDescuento(factura.getMontoDescuento())
                .totalCosto(factura.getTotalCosto())
                .totalVenta(factura.getTotalVenta())
                .build();
    }

    public List <Factura> DTOaEntidades (List<FacturaDTO> dtos) {
        return dtos.stream().map(entidades -> mapper.map(entidades, Factura.class))
                .collect(Collectors.toList());
    }

    public List<FacturaDTO> entidadesADTO (List<Factura> entidades) {
        return entidades.stream().map(dtos -> mapper.map(dtos, FacturaDTO.class))
                .collect(Collectors.toList());
    }

}
