package com.example.elbuensabor.Entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RubroArticulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column (name = "denominacion", nullable = false)
    private String denominacion;

    @OneToMany(mappedBy = "rubroArticulo")
    private List<ArticuloManufacturado> articulos;

    @OneToMany(mappedBy = "rubroArticulo")
    private List<ArticuloInsumo> insumos;


}