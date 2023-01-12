package com.example.elbuensabor.Mappers;



import com.example.elbuensabor.DTOs.ClienteDTO;
import com.example.elbuensabor.Entidades.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {


    private ModelMapper mapper = new ModelMapper();
    public List<ClienteDTO> entidadesADTO(List <Cliente> entidades ){

        return entidades.stream().map(clientes -> mapper.map(clientes,ClienteDTO.class)).collect(Collectors.toList());

    }

    public List <Cliente> DTOaEntidades(List <ClienteDTO> dtos){

        return dtos.stream().map(entidades -> mapper.map(entidades,Cliente.class)).collect(Collectors.toList());
    }

    public ClienteDTO entidadADTO (Cliente entidad){

        return ClienteDTO.builder()
                .nombre(entidad.getNombre())
                .apellido(entidad.getApellido())
                .telefono(entidad.getTelefono())
                .email(entidad.getEmail())
                .build();
    }


    public Cliente DTOaEntidad (ClienteDTO dto){

        return Cliente.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .build();
    }
}
