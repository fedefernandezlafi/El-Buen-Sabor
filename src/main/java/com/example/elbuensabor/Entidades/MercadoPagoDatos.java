package com.example.elbuensabor.Entidades;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class MercadoPagoDatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "indentificador_pago", nullable = false)
    private long identificadorPago;
    @CreationTimestamp
    @Column (name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;
    @UpdateTimestamp
    @Column (name = "fecha_aprobacion", nullable = false)
    private LocalDate fechaAprobacion;
    @Column (name = "forma_pago", nullable = false)
    private String formaPago;
    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @Column(name = "nro_tarjeta", nullable = false)
    private String nroTarjeta;
    @Column(name = "estado", nullable = false)
    private String estado;

}