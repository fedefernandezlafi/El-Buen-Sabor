package com.example.elbuensabor.DTOs;

import com.example.elbuensabor.Entidades.ArticuloManufacturadoDetalle;
import com.example.elbuensabor.Entidades.DetalleFactura;
import com.example.elbuensabor.Entidades.DetallePedido;
import com.example.elbuensabor.Entidades.RubroArticulo;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
public class ArticuloInsumoDTO {

    @NotNull (message = "La denominacion no puede ser nula")
    @NotEmpty (message = "La denominacion no puede estar vacia")
    private String denominacion;
    @NotNull (message = "El Precio de compra no puede ser nulo")
    @NotEmpty (message = "El Predio de compra no puede estar vacio")
    @Size(min = 0, message = "El precio no puede ser menor que 0")
    private double precioCompra;
    @NotNull (message = "El precio de venta no puede ser nulo")
    @NotEmpty (message = "El precio de venta no puede estar vacio")
    @Size(min = 0, message = "El precio de compra no puede ser menor que 0")
    private double precioVenta;
    @NotNull (message = "El stock actual no puede ser nulo")
    @NotEmpty (message = "El stock actual no puede estar vacio")
    @Size(min = 0, message = "El stock actual no puede ser menor que 0")
    private double stockActual;
    @NotNull (message = "El Stock minimo no puede ser nulo")
    @NotEmpty (message = "El stock minimo no puede estar vacio")
    @Size(min = 0, message = "El stock minimo no puede ser menor que 0")
    private double stockMinimo;
    @NotNull (message = "La unidad de medida no puede ser nula")
    @NotEmpty (message = "La unidad de medida no puede estar vacia")
    private String unidadMedida;
    private boolean esInsumo;
}
