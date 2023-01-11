package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepositorio extends JpaRepository <Pedido, Long>{
}
