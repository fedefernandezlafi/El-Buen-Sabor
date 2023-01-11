package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.ArticuloManufacturadoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloManufacturadoDetalleRepositorio extends JpaRepository<ArticuloManufacturadoDetalle, Long> {
}
