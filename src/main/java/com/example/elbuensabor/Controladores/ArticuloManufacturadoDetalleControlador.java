package com.example.elbuensabor.Controladores;


import com.example.elbuensabor.DTOs.ArticuloManufacturadoDetalleDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.ArticuloManufacturadoDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/articuManufacturadoDetalle")
public class ArticuloManufacturadoDetalleControlador {

    @Autowired
    private ArticuloManufacturadoDetalleServicio articuloManufacturadoDetalleServicio;


    @GetMapping
    public ResponseEntity<List<ArticuloManufacturadoDetalleDTO>> listarArticuloManufacturadoDetalle () {
        return ResponseEntity.ok(articuloManufacturadoDetalleServicio.listarArticuloManufacturadoDetalle());

    }

    @PostMapping("/registro")
    public ResponseEntity<ArticuloManufacturadoDetalleDTO> registro (@Valid @RequestBody ArticuloManufacturadoDetalleDTO articuloManufacturadoDetalleDTO) {
        return ResponseEntity.ok(articuloManufacturadoDetalleServicio.crearArticuloManufacturadoDetalle(articuloManufacturadoDetalleDTO));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ArticuloManufacturadoDetalleDTO> actualizar (@Valid @RequestBody ArticuloManufacturadoDetalleDTO articuloManufacturadoDetalleDTO, @PathVariable long id) throws ErrorServicio {
        if(articuloManufacturadoDetalleServicio.actualizarArticuloManufacturadoDetalle(articuloManufacturadoDetalleDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(articuloManufacturadoDetalleServicio.actualizarArticuloManufacturadoDetalle(articuloManufacturadoDetalleDTO,id));

        // chupa pinga
    }
}
