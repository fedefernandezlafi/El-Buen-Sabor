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

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name ="nombre", nullable = false)
    private String nombre;
    @Column(name ="apellido", nullable = false)
    private String apellido;
    @Column(name ="telefono", nullable = false)
    private String telefono;
    @Column(name ="email", nullable = false)
    private String email;



}