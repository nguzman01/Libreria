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
@Entity //@Entity-->  indica que la clase es una entidad JPA.

public class Proveedor {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_proveedor;
private String nombre;
private String telefono;
private String Correo;
private String direccion;


    public void setId_proveedor(int id) {
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public Proveedor orElseThrow(Object proveedorNoEncontrado) {
        return null;
    }
}
