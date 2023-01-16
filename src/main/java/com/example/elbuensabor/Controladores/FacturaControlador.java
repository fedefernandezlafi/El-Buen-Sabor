package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.DTOs.FacturaDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/facturas")
public class FacturaControlador {
    @Autowired
    private FacturaServicio facturaServicio;


    @GetMapping
    public ResponseEntity<List<FacturaDTO>> listarFacturas () {
        return ResponseEntity.ok(facturaServicio.listarFacturas());

    }

    @PostMapping("/crear")
    public ResponseEntity<FacturaDTO> crear (@Valid @RequestBody FacturaDTO facturaDTO) {
        return ResponseEntity.ok(facturaServicio.crearFactura(facturaDTO));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<FacturaDTO> actualizar (@Valid @RequestBody FacturaDTO facturaDTO, @PathVariable long id) throws ErrorServicio {
        if(facturaServicio.actualizarFactura(facturaDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaServicio.actualizarFactura(facturaDTO,id));
    }
}
