package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.DTOs.DetalleFacturaDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.DetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/detallefactura")
public class DetalleFacturaControlador {
    @Autowired
    private DetalleFacturaServicio detalleFacturaServicio;


    @GetMapping
    public ResponseEntity<List<DetalleFacturaDTO>> listarDetalleFacturas () {
        return ResponseEntity.ok(detalleFacturaServicio
                .listarDetalleFacturas());

    }

    @PostMapping("/crear")
    public ResponseEntity<DetalleFacturaDTO> crear (@Valid @RequestBody DetalleFacturaDTO detalleFacturaDTO) {
        return ResponseEntity.ok(detalleFacturaServicio.crearDetalleFactura(detalleFacturaDTO));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<DetalleFacturaDTO> actualizar (@Valid @RequestBody DetalleFacturaDTO detalleFacturaDTO, @PathVariable long id) throws ErrorServicio {
        if(detalleFacturaServicio.actualizarDetalleFactura(detalleFacturaDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detalleFacturaServicio.actualizarDetalleFactura(detalleFacturaDTO,id));


    }
}
