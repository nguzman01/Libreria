package com.example.ProyectoPostgres.Service;

import com.example.ProyectoPostgres.Model.Detalle_Venta;
import com.example.ProyectoPostgres.Repository.Detalle_VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


 //Servicio para manejar operaciones relacionadas con la entidad Detalle_Venta.

@Service
public class Detalle_VentaService {

    @Autowired
    private Detalle_VentaRepository detalleVentaRepository;

     //Obtiene una lista de todos los detalles de venta.
     //@return List<Detalle_Venta> - lista de detalles de venta.

    public List<Detalle_Venta> findAll() {
        return detalleVentaRepository.findAll();
    }

     // Busca un detalle de venta por su ID.
     //@param id - ID del detalle de venta a buscar.
    //@return Detalle_Venta - detalle de venta encontrado o null si no existe.

    public Detalle_Venta findById(int id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

     //Guarda un nuevo detalle de venta o actualiza uno existente.
     //@param detalleVenta - detalle de venta a guardar.
     //@return Detalle_Venta - detalle de venta guardado.

    public Detalle_Venta save(Detalle_Venta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

     //Elimina un detalle de venta por su ID.
     //@param id - ID del detalle de venta a eliminar.

    public void deleteById(int id) {
        detalleVentaRepository.deleteById(id);
    }
    // Lógica para obtener detalles de ventas por empleado y cliente
    public List<Detalle_Venta> findDetallesByEmpleadoAndCliente(int empleadoId, int clienteId) {
        return detalleVentaRepository.findDetallesByEmpleadoAndCliente(empleadoId, clienteId);
    }

}