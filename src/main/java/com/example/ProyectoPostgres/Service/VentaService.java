package com.example.ProyectoPostgres.Service;

import com.example.ProyectoPostgres.Model.Venta;
import com.example.ProyectoPostgres.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para manejar operaciones relacionadas con la entidad Venta.
 */
@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    /**
     * Obtiene una lista de todas las ventas.
     */
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    /**
     * Busca una venta por su ID.
     *
     * @param id - ID de la venta a buscar.
     * @return Venta - venta encontrada o null si no existe.
     */
    public Venta findById(int id) {
        return ventaRepository.findById(id).orElse(null);
    }


     //Guarda una nueva venta o actualiza una existente.
     // @param venta - venta a guardar.
     // @return Venta - venta guardada.

    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }


     // Elimina una venta por su ID.
     // @param id - ID de la venta a eliminar.

    public void deleteById(int id) {
        ventaRepository.deleteById(id);
    }

    //Logica para listar ventas por empleado
    public List<Venta> findVentasByEmpleadoId(int empleadoId) {
        return ventaRepository.findVentasByEmpleadoId(empleadoId);
    }

    // Lógica para listar ventas por empleado y cliente
    public List<Venta> findVentasByEmpleadoAndClienteId(int empleadoId, int clienteId) {
        return ventaRepository.findVentasByEmpleadoAndClienteId(empleadoId, clienteId);
    }
}