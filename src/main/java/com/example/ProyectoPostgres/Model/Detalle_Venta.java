package com.example.ProyectoPostgres.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Detalle_Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle;
    private int cantidad;
    private double precio_unitario; // Cambiado a double para representar el precio unitario

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

}
