package com.example.elbuensabor.Mappers;

import com.example.elbuensabor.DTOs.PedidoDTO;
import com.example.elbuensabor.Entidades.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    private ModelMapper mapper = new ModelMapper ();
    public Pedido DTOaEntidad (PedidoDTO dto) {
        return Pedido.builder()
                .fecha(dto.getFecha())
                .numero(dto.getNumero())
                .estado(dto.getEstado())
                .horaEstimadaFin(dto.getHoraEstimadaFin())
                .tipoEnvio(dto.getTipoEnvio())
                .build();
    }

    public PedidoDTO entidadADTO (Pedido pedido) {
        return PedidoDTO.builder()
                .estado(pedido.getEstado())
                .fecha(pedido.getFecha())
                .horaEstimadaFin(pedido.getHoraEstimadaFin())
                .tipoEnvio(pedido.getTipoEnvio())
                .numero(pedido.getNumero())
                .build() ;
    }

    public List<Pedido> DTOaEntidades (List<PedidoDTO> dtos) {
        return dtos.stream().map(entidades -> mapper.map(dtos, Pedido.class))
                .collect(Collectors.toList());
    }

    public List<PedidoDTO> entidadesADTO (List<Pedido> entidades) {
        return entidades.stream().map(dtos -> mapper.map(entidades, PedidoDTO.class))
                .collect(Collectors.toList());
    }
}
