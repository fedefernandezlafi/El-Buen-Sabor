package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
}
