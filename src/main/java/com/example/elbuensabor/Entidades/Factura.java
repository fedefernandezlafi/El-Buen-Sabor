package com.example.elbuensabor.Entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column (name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column (name = "numero", nullable = false)
    private int numero;
    @Column (name = "monto_descuento", nullable = false)
    private double montoDescuento;
    @Column (name = "forma_pago", nullable = false)
    private String formaPago;
    @Column (name = "nro_Tarjeta", nullable = false)
    private String nroTarjeta;
    @Column (name = "total_Venta", nullable = false)
    private double totalVenta;
    @Column (name = "total_Costo", nullable = false)
    private double totalCosto;

}