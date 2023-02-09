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

public class ArticuloInsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "denominacion", nullable = false)
    private String denominacion;

    @Column(name = "precio_compra", nullable = false)
    private double precioCompra;
    @Column(name = "precio_venta", nullable = false)
    private double precioVenta;
    @Column(name = "stock_actual", nullable = false)
    private double stockActual;
    @Column(name = "stock_minimo", nullable = false)
    private double stockMinimo;
    @Column(name = "unidad_medida", nullable = false)
    private String unidadMedida;
    @Column(name = "es_insumo", nullable = false)
    private boolean esInsumo;
    @Column(name = "imagen", nullable = true)
    private String imagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle", nullable = true)
    private ArticuloManufacturadoDetalle detalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubro_articulo", nullable = true)
    private RubroArticulo rubroArticulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubro_general", nullable = true)
    private RubroGeneral rubroGeneral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle_pedido", nullable = true)
    private DetallePedido detallePedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle_factura", nullable = true)
    private DetalleFactura detalleFactura;




}