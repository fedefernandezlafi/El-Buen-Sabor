package com.example.elbuensabor.Entidades;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class MercadoPagoDatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private long identificadorPago;
    private LocalDate fechaCreacion;
    private LocalDate fechaAprobacion;
    private String formaPago;
    private String metodoPago;
    private String nroTarjeta;

    private String estado;

}