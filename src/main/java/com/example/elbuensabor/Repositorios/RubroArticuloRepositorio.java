package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.RubroArticulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroArticuloRepositorio extends JpaRepository <RubroArticulo, Long> {
}
