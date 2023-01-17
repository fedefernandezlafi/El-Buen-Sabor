package com.example.elbuensabor.Entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ArticuloManufacturado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="tiempo_estimado_cocina", nullable = false)
    private int tiempoEstimadoCocina;
    @Column(name ="denominacion", nullable = false)
    private String denominacion;

    @Column(name ="precio_venta", nullable = false)
    private double precioVenta;
    @Column(name ="imagen", nullable = false)
    private String imagen;

}