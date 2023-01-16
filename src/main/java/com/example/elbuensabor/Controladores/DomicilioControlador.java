package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.DTOs.DomicilioDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.DomicilioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/domicilios")
public class DomicilioControlador {

    @Autowired
    private DomicilioServicio domicilioServicio;


    @GetMapping
    public ResponseEntity<List<DomicilioDTO>> listarDomicilios () {
        return ResponseEntity.ok(domicilioServicio.listarDomicilios());

    }

    @PostMapping("/crear")
    public ResponseEntity<DomicilioDTO> crear (@Valid @RequestBody DomicilioDTO domicilioDTO) {
        return ResponseEntity.ok(domicilioServicio.crearDomicilio(domicilioDTO));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<DomicilioDTO> actualizar (@Valid @RequestBody DomicilioDTO domicilioDTO, @PathVariable long id) throws ErrorServicio {
        if(domicilioServicio.actualizarDomicilio(domicilioDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(domicilioServicio.actualizarDomicilio(domicilioDTO,id));


    }

}
