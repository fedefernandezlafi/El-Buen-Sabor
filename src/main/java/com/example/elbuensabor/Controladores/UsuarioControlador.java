package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.Entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/usuarios")
public class UsuarioControlador {


@GetMapping
    public ResponseEntity<Usuario> listarUsuarios () {
    return ResponseEntity.ok(new Usuario());
}

}
