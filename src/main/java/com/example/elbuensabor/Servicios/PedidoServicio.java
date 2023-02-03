package com.example.elbuensabor.Servicios;

import com.example.elbuensabor.DTOs.PedidoDTO;
import com.example.elbuensabor.Entidades.DetallePedido;
import com.example.elbuensabor.Entidades.Pedido;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.PedidoMapper;
import com.example.elbuensabor.Repositorios.ClienteRepositorio;
import com.example.elbuensabor.Repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {
    @Autowired
    private PedidoRepositorio repo;
    @Autowired
    private PedidoMapper mapper;
    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Autowired
    DetallePedidoServicio detallePedidoServicio;

    public PedidoDTO crearPedido(PedidoDTO dto, long idCliente){
        Pedido pedido = mapper.DTOaEntidad(dto);
        repo.save(pedido);
        pedido.setDetallePedido(detallePedidoServicio.crearDetallePedido(pedido.getId()));
        pedido.setFecha(LocalDate.now());
        pedido.setEstado("RECIBIDO");
        pedido.setCliente(clienteRepositorio.findById(idCliente).get());
        repo.save(pedido);
        PedidoDTO pedidoCreado =  mapper.entidadADTO(pedido);
        return pedidoCreado;
    }

    public PedidoDTO actualizarPedido(PedidoDTO dto, Long id) throws ErrorServicio {
        Optional<Pedido> pedido= repo.findById(id);
        if(pedido.isPresent()){
            Pedido pedidoActualizado = pedido.get();
            pedidoActualizado = mapper.DTOaEntidad(dto);
            repo.save(pedidoActualizado);
            PedidoDTO pedidoActualizadoDTO = mapper.entidadADTO(pedidoActualizado);
            return pedidoActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<PedidoDTO> listarPedidos(){
        List<Pedido> pedidos = repo.findAll();
        List<PedidoDTO> pedidosDTO = mapper.entidadesADTO(pedidos);
        return pedidosDTO;
    }

    public List<PedidoDTO> obtenerHistorico (long idCliente){
        List<Pedido> listaHistorico = repo.getHistorico(idCliente);
        List<PedidoDTO> listaDTO = mapper.entidadesADTO(listaHistorico);
        return listaDTO;
    }
}
