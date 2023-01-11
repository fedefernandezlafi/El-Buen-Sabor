package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.ArticuloInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticuloInsumoRepositorio extends JpaRepository<ArticuloInsumo , Long> {
}
