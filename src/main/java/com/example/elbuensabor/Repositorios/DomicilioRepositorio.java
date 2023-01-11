package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepositorio extends JpaRepository <Domicilio, Long> {
}
