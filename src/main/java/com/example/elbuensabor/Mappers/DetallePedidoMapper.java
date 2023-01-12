package com.example.elbuensabor.Mappers;


import com.example.elbuensabor.DTOs.DetallePedidoDTO;
import com.example.elbuensabor.Entidades.DetallePedido;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class DetallePedidoMapper {


    private ModelMapper mapper = new ModelMapper();
    public List<DetallePedidoDTO> entidadesADTO(List <DetallePedido> entidades ){

        return entidades.stream().map(pedidos -> mapper.map(pedidos,DetallePedidoDTO.class)).collect(Collectors.toList());

    }

    public List <DetallePedido> DTOaEntidades(List <DetallePedidoDTO> dtos){

        return dtos.stream().map(entidades -> mapper.map(entidades,DetallePedido.class)).collect(Collectors.toList());
    }

    public DetallePedidoDTO entidadADTO (DetallePedido entidad){

        return DetallePedidoDTO.builder()
                .cantidad(entidad.getCantidad())
                .subTotal(entidad.getSubTotal())
                .build();
    }


    public DetallePedido DTOaEntidad (DetallePedidoDTO dto){

        return DetallePedido.builder()
                .cantidad(dto.getCantidad())
                .subTotal(dto.getSubTotal())
                .build();
    }
}
