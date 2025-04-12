package com.example.ProyectoPostgres.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_empleado;
    private String nombre;
    private String cargo;
    private String telefono;


    public void setId_empleado(int id) {
    }
}
