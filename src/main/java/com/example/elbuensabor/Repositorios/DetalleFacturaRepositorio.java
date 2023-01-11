package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepositorio extends JpaRepository <DetalleFactura, Long> {
}
