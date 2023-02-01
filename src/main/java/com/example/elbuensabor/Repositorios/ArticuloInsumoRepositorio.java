package com.example.elbuensabor.Repositorios;

import com.example.elbuensabor.Entidades.ArticuloInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticuloInsumoRepositorio extends JpaRepository<ArticuloInsumo , Long> {
    @Query(value = "SELECT * FROM articulo_insumo WHERE es_insumo = false", nativeQuery = true)
    public List<ArticuloInsumo> getByEsInsumoFalse ();

}
