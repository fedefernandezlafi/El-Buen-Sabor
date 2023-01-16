package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.DTOs.RubroGeneralDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.RubroGeneralServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/rubrogeneral")
public class RubroGeneralControlador {
    @Autowired
    private RubroGeneralServicio rubroGeneralServicio;


    @GetMapping
    public ResponseEntity<List<RubroGeneralDTO>> listarRubroGenerals () {
        return ResponseEntity.ok(rubroGeneralServicio.listarRubroGenerals());

    }

    @PostMapping("/crear")
    public ResponseEntity<RubroGeneralDTO> crear (@Valid @RequestBody RubroGeneralDTO rubroGeneralDTO) {
        return ResponseEntity.ok(rubroGeneralServicio.crearRubroGeneral(rubroGeneralDTO));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<RubroGeneralDTO> actualizar (@Valid @RequestBody RubroGeneralDTO rubroGeneralDTO, @PathVariable long id) throws ErrorServicio {
        if(rubroGeneralServicio.actualizarRubroGeneral(rubroGeneralDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rubroGeneralServicio.actualizarRubroGeneral(rubroGeneralDTO,id));


    }
}
