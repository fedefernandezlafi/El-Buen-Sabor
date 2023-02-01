package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepositorio extends JpaRepository <Pedido, Long>{
    @Query(value = "SELECT * FROM pedidos WHERE id_cliente = :idCliente", nativeQuery = true)
    public List<Pedido> getHistorico(long idCliente);
}
