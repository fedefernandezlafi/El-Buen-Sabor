package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long>{
}
