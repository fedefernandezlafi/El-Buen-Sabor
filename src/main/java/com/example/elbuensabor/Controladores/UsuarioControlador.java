package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.DTOs.UsuarioDTO;
import com.example.elbuensabor.Entidades.Usuario;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping ("/usuarios")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;


    @GetMapping
    public ResponseEntity<List<UsuarioDTO> > listarUsuarios () throws Exception {
    return ResponseEntity.ok(usuarioServicio.listarUsuarios());

}
    @GetMapping ("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorID (@PathVariable long id) throws Exception {
        return ResponseEntity.ok(usuarioServicio.getById(id));
    }

   @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> registro (@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioServicio.crearUsuario(usuarioDTO));
   }

   @PutMapping("/actualizar")
    public ResponseEntity<UsuarioDTO> actualizar (@Valid @RequestBody UsuarioDTO usuarioDTO, @PathVariable long id) throws ErrorServicio {
        if(usuarioServicio.actualizarUsuario(usuarioDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioServicio.actualizarUsuario(usuarioDTO,id));


   }


}
