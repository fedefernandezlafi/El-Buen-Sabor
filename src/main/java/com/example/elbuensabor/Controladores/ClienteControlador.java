package com.example.elbuensabor.Controladores;

import com.example.elbuensabor.DTOs.ClienteDTO;
import com.example.elbuensabor.DTOs.ProductoDTO;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Servicios.ClienteServicio;
import com.example.elbuensabor.Servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/clientes")
public class ClienteControlador {
    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes () {
        return ResponseEntity.ok(clienteServicio.listarClientes());

    }

    @PostMapping("/crear")
    public ResponseEntity<ClienteDTO> crear (@Valid @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteServicio.crearCliente(clienteDTO));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ClienteDTO> actualizar (@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable long id) throws ErrorServicio {
        if(clienteServicio.actualizarCliente(clienteDTO, id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteServicio.actualizarCliente(clienteDTO,id));
    }


    @GetMapping ("/productos")
    public ResponseEntity<List<ProductoDTO>> verProductos () {
        return ResponseEntity.ok(productoServicio.crearListaProductos());
    }
}
