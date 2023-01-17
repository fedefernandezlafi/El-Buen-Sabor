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

public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="cantidad", nullable = false)
    private int cantidad;
    @Column(name ="subtotal", nullable = false)
    private double subTotal;
    @OneToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;
}