package com.example.ProyectoPostgres.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;
    private String nombre;
    private String descripcion; // a String
    private double precio; //
    private int stock;

   /* @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;*/

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
    public void setId_producto(int id) {
    }

    @OneToMany(mappedBy = "producto") //
  private List<Detalle_Venta> detalles; // va a List<Detalle_Venta>

    public void setProveedor(Proveedor proveedor) {
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
}


// controladores con respon contiti