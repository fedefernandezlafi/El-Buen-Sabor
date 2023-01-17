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

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column (name = "usuario", nullable = false)
    private String usuario;
    @Column (name = "clave", nullable = false)
    private String clave;
    @Column (name = "rol", nullable = false)
    private String rol;


}