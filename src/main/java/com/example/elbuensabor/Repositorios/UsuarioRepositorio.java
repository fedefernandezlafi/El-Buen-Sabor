package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.DTOs.UsuarioDTO;
import com.example.elbuensabor.Entidades.Usuario;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long>{

    @Query(value = "SELECT * FROM USUARIO", nativeQuery = true)
    public List<Usuario> getUsuarios();
}
