package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.DTOs.DetallePedidoDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.DetallePedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/detallepedido")
public class DetallePedidoControlador {
    @Autowired
    private DetallePedidoServicio detallePedidoServicio;


    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> listarDetallePedidos () {
        return ResponseEntity.ok(detallePedidoServicio.listarPedidosDetalle());

    }
/*
    @PostMapping("/crear")
    public ResponseEntity<DetallePedidoDTO> crear (@Valid @RequestBody DetallePedidoDTO detallePedidoDTO) {
        return ResponseEntity.ok(detallePedidoServicio.crearDetallePedido(detallePedidoDTO));
    }
*/
    @PutMapping("/actualizar")
    public ResponseEntity<DetallePedidoDTO> actualizar (@Valid @RequestBody DetallePedidoDTO detallePedidoDTO, @PathVariable long id) throws ErrorServicio {
        if(detallePedidoServicio.actualizarDetallePedido(detallePedidoDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detallePedidoServicio.actualizarDetallePedido(detallePedidoDTO,id));


    }
    
}
