package com.example.ProyectoPostgres.Repository;

import com.example.ProyectoPostgres.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT p FROM Producto p WHERE p.proveedor.id_proveedor = ?1")
    List<Producto> findProductosByProveedorId(int proveedorId);
}