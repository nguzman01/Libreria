package com.example.ProyectoPostgres.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import jdk.jfr.events.CertificateId;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_cliente;
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;


    public void setId_cliente(int id) {
    }
}
