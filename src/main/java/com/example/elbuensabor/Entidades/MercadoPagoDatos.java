package com.example.elbuensabor.Entidades;

import javax.persistence.*;


@Entity
public class MercadoPagoDatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

}