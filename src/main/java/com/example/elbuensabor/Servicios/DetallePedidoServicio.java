package com.example.elbuensabor.Servicios;


import com.example.elbuensabor.DTOs.DetallePedidoDTO;
import com.example.elbuensabor.Entidades.DetallePedido;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.DetallePedidoMapper;
import com.example.elbuensabor.Repositorios.DetallePedidoRepositorio;
import com.example.elbuensabor.Repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class DetallePedidoServicio {

    @Autowired
    private DetallePedidoRepositorio repo;
    @Autowired
    private DetallePedidoMapper mapper;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    /* una vez realizado los controles de stock de insumos para crear los manufacturados acomodar esta parte*/
    public DetallePedido crearDetallePedido(long idPedido){
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setPedido(pedidoRepositorio.findById(idPedido).get());
        detallePedido.setInsumos(new ArrayList<>());
        detallePedido.setManufacturados(new ArrayList<>());
        repo.save(detallePedido);
        DetallePedidoDTO detallePedidoCreado = mapper.entidadADTO(detallePedido);
        return detallePedido;
    }

    public DetallePedidoDTO actualizarDetallePedido(DetallePedidoDTO dto, Long id) throws ErrorServicio {
        Optional<DetallePedido> detallePedido= repo.findById(id);
        if(detallePedido.isPresent()){
            DetallePedido detallePedidoActualizado = detallePedido.get();
            detallePedidoActualizado = mapper.DTOaEntidad(dto);
            repo.save(detallePedidoActualizado);
            DetallePedidoDTO detallePedidoActualizadoDTO = mapper.entidadADTO(detallePedidoActualizado);
            return detallePedidoActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<DetallePedidoDTO> listarPedidosDetalle(){

        List<DetallePedido> pedidos = repo.findAll();
        List<DetallePedidoDTO> pedidosDTO = mapper.entidadesADTO(pedidos);
        return pedidosDTO;
    }
}
