package com.example.elbuensabor.Servicios;


import com.example.elbuensabor.DTOs.DetallePedidoDTO;
import com.example.elbuensabor.Entidades.DetallePedido;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.DetallePedidoMapper;
import com.example.elbuensabor.Repositorios.DetallePedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class DetallePedidoServicio {

    @Autowired
    private DetallePedidoRepositorio repo;
    @Autowired
    private DetallePedidoMapper mapper;

    public DetallePedidoDTO crearDetallePedido(DetallePedidoDTO dto){
        DetallePedido detallePedido = mapper.DTOaEntidad(dto);
        repo.save(detallePedido);
        DetallePedidoDTO detallePedidoCreado =  mapper.entidadADTO(detallePedido);
        return detallePedidoCreado;
    }

    public DetallePedidoDTO actualizarDetallePedido(DetallePedidoDTO dto, Long id) throws ErrorServicio {
        Optional<DetallePedido> detallePedido= repo.findById(id);
        if(detallePedido.isPresent()){
            DetallePedido detallePedidoActualizado = detallePedido.get();
            detallePedidoActualizado = mapper.DTOaEntidad(dto);
            DetallePedidoDTO detallePedidoActualizadoDTO = mapper.entidadADTO(detallePedidoActualizado);
            return detallePedidoActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<DetallePedidoDTO> listarPedidos(){

        List<DetallePedido> pedidos = repo.findAll();
        List<DetallePedidoDTO> pedidosDTO = mapper.entidadesADTO(pedidos);
        return pedidosDTO;
    }
}
