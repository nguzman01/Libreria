package com.example.ProyectoPostgres.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// dara fecha colocar locald
// metodos deben usar --  gardar, eliminar, buscar por id, actualizar,
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Venta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;
    private long fecha; //  long para representar la fecha como timestamp

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    public void setId_venta(int id) {
    }

    @OneToMany(mappedBy = "venta") // "venta" para que coincida con el nombre de la propiedad
    private List<Detalle_Venta> detalles;
}



