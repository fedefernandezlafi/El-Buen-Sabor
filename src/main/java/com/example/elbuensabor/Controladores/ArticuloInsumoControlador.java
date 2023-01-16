package com.example.elbuensabor.Controladores;


import com.example.elbuensabor.DTOs.ArticuloInsumoDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.ArticuloInsumoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/articuloInsumo")
public class ArticuloInsumoControlador {

    @Autowired
    private ArticuloInsumoServicio articuloInsumoServicio;


    @GetMapping
    public ResponseEntity<List<ArticuloInsumoDTO>> listarArticuloInsumo () {
        return ResponseEntity.ok(articuloInsumoServicio.listarArticuloInsumo());

    }

    @PostMapping("/registro")
    public ResponseEntity<ArticuloInsumoDTO> registro (@Valid @RequestBody ArticuloInsumoDTO articuloInsumoDTO) {
        return ResponseEntity.ok(articuloInsumoServicio.crearArticuloInsumo(articuloInsumoDTO));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ArticuloInsumoDTO> actualizar (@Valid @RequestBody ArticuloInsumoDTO articuloInsumoDTO, @PathVariable long id) throws ErrorServicio {
        if(articuloInsumoServicio.actualizarArticuloInsumo(articuloInsumoDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(articuloInsumoServicio.actualizarArticuloInsumo(articuloInsumoDTO,id));

        // chupa pinga
    }
}
