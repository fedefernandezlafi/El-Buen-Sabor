package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.ArticuloManufacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticuloManufacturadoRepositorio extends JpaRepository<ArticuloManufacturado, Long> {
}
