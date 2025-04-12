package com.example.ProyectoPostgres.Repository;

import com.example.ProyectoPostgres.Model.Detalle_Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Detalle_VentaRepository extends JpaRepository<Detalle_Venta, Integer> {

    @Query("SELECT dv FROM Detalle_Venta dv JOIN dv.venta v WHERE v.empleado.id_empleado = ?1 AND v.cliente.id_cliente = ?2")
    List<Detalle_Venta> findDetallesByEmpleadoAndCliente(int empleadoId, int clienteId);
}