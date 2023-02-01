package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.DTOs.PedidoDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/pedidos")
public class PedidoControlador {
    @Autowired
    private PedidoServicio pedidoServicio;


    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos () {
        return ResponseEntity.ok(pedidoServicio.listarPedidos());

    }

    @PostMapping("/crear")
    public ResponseEntity<PedidoDTO> crear (@Valid @RequestBody PedidoDTO pedidoDTO, @PathVariable long idCliente) {
        return ResponseEntity.ok(pedidoServicio.crearPedido(pedidoDTO, idCliente));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PedidoDTO> actualizar (@Valid @RequestBody PedidoDTO pedidoDTO, @PathVariable long id) throws ErrorServicio {
        if(pedidoServicio.actualizarPedido(pedidoDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedidoServicio.actualizarPedido(pedidoDTO,id));
    }
}
