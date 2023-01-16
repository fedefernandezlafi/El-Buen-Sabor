package com.example.elbuensabor.Controladores;


import com.example.elbuensabor.DTOs.ArticuloManufacturadoDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.ArticuloManufacturadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/articuloManufacturado")
public class ArticuloManufacturadoControlador {

    @Autowired
    private ArticuloManufacturadoServicio articuloManufacturadoServicio;


    @GetMapping
    public ResponseEntity<List<ArticuloManufacturadoDTO>> listarArticuloManufacturados () {
        return ResponseEntity.ok(articuloManufacturadoServicio.listarArticuloManufacturado());

    }

    @PostMapping("/registro")
    public ResponseEntity<ArticuloManufacturadoDTO> registro (@Valid @RequestBody ArticuloManufacturadoDTO articuloManufacturadoDTO) {
        return ResponseEntity.ok(articuloManufacturadoServicio.crearArticuloManufacturado(articuloManufacturadoDTO));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ArticuloManufacturadoDTO> actualizar (@Valid @RequestBody ArticuloManufacturadoDTO articuloManufacturadoDTO, @PathVariable long id) throws ErrorServicio {
        if(articuloManufacturadoServicio.actualizarArticuloManufacturado(articuloManufacturadoDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(articuloManufacturadoServicio.actualizarArticuloManufacturado(articuloManufacturadoDTO,id));


    }
}
