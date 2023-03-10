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

public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="cantidad", nullable = false)
    private int cantidad;
    @Column(name ="subtotal", nullable = false)
    private double subTotal;
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @OneToMany(mappedBy = "detallePedido")
    private List<ArticuloInsumo> insumos;
    @OneToMany(mappedBy = "detallePedido")
    private List<ArticuloManufacturado> manufacturados;

}