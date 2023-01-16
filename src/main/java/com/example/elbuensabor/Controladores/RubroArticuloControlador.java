package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.DTOs.RubroArticuloDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.RubroArticuloServicio;
import com.example.elbuensabor.Servicios.RubroGeneralServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/rubroarticulo")
public class RubroArticuloControlador {
    @Autowired
    private RubroArticuloServicio rubroArticuloServicio;


    @GetMapping
    public ResponseEntity<List<RubroArticuloDTO>> listarRubroArticulos () {
        return ResponseEntity.ok(rubroArticuloServicio.listarRubroArticulos());

    }

    @PostMapping("/crear")
    public ResponseEntity<RubroArticuloDTO> crear (@Valid @RequestBody RubroArticuloDTO rubroArticuloDTO) {
        return ResponseEntity.ok(rubroArticuloServicio.crearRubroArticulo(rubroArticuloDTO));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<RubroArticuloDTO> actualizar (@Valid @RequestBody RubroArticuloDTO rubroArticuloDTO, @PathVariable long id) throws ErrorServicio {
        if(rubroArticuloServicio.actualizarRubroArticulo(rubroArticuloDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rubroArticuloServicio.actualizarRubroArticulo(rubroArticuloDTO,id));
    }
}
