package com.example.ProyectoPostgres.Repository;

import com.example.ProyectoPostgres.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query("SELECT v FROM Venta v WHERE v.empleado.id_empleado = ?1")
    List<Venta> findVentasByEmpleadoId(int empleadoId);

    @Query("SELECT v FROM Venta v WHERE v.empleado.id_empleado = ?1 AND v.cliente.id_cliente = ?2")
    List<Venta> findVentasByEmpleadoAndClienteId(int empleadoId, int clienteId);
}