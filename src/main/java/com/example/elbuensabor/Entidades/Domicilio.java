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

public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "calle", nullable = false)
    private String calle;
    @Column(name = "numero", nullable = false)
    private int numero;
    @Column(name = "localidad", nullable = false)
    private String localidad;

}