package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.RubroGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroGeneralRepositorio extends JpaRepository <RubroGeneral, Long> {
}
