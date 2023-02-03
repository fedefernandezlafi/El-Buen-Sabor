package com.example.elbuensabor.Servicios;





import com.example.elbuensabor.DTOs.ClienteDTO;
import com.example.elbuensabor.Entidades.Cliente;
import com.example.elbuensabor.Entidades.Pedido;
import com.example.elbuensabor.Excepciones.ErrorServicio;
import com.example.elbuensabor.Mappers.ClienteMapper;
import com.example.elbuensabor.Repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio repo;
    @Autowired
    private ClienteMapper mapper;

    public ClienteDTO crearCliente(ClienteDTO dto){
        Cliente cliente = mapper.DTOaEntidad(dto);
        repo.save(cliente); //
        ClienteDTO clienteCreado =  mapper.entidadADTO(cliente);
        return clienteCreado;
    }

    public ClienteDTO actualizarCliente(ClienteDTO dto, Long id) throws ErrorServicio {
        Optional<Cliente> cliente= repo.findById(id);
        if(cliente.isPresent()){
            Cliente clienteActualizado = cliente.get();
            clienteActualizado = mapper.DTOaEntidad(dto);
            repo.save(clienteActualizado);
            ClienteDTO clienteActualizadoDTO = mapper.entidadADTO(clienteActualizado);
            return clienteActualizadoDTO;
        }
        throw  new ErrorServicio("No se encuentra el Id mencionado");

    }

    public List<ClienteDTO> listarClientes(){

        List<Cliente> clientes = repo.findAll();
        List<ClienteDTO> clientesDTO = mapper.entidadesADTO(clientes);
        return clientesDTO;
    }



}
