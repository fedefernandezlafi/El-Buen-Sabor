package com.example.elbuensabor.Entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column (name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column (name = "estado", nullable = false)
    private String estado;
    @UpdateTimestamp
    @Column (name = "hora_estimada_fin", nullable = false)
    private LocalDate horaEstimadaFin;
    @Column (name = "tipo_envio", nullable = false)
    private String tipoEnvio;
    @OneToOne (mappedBy = "pedido")
    private DetallePedido detallePedido;
    @OneToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;
}