package com.example.ProyectoPostgres.Controller;

import com.example.ProyectoPostgres.Model.Detalle_Venta;
import com.example.ProyectoPostgres.Service.Detalle_VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


 // Controlador para manejar las solicitudes relacionadas con la entidad Detalle_Venta.

@RestController
@RequestMapping("/api/detalle-ventas")

public class Detalle_VentaController {

    @Autowired
    private Detalle_VentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<Detalle_Venta>> getAllDetalleVentas() {
        List<Detalle_Venta> detalles = detalleVentaService.findAll();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle_Venta> getDetalleVentaById(@PathVariable int id) {
        Detalle_Venta detalleVenta = detalleVentaService.findById(id);
        if (detalleVenta != null) {
            return new ResponseEntity<>(detalleVenta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Detalle_Venta> createDetalleVenta(@RequestBody Detalle_Venta detalleVenta) {
        Detalle_Venta nuevoDetalle = detalleVentaService.save(detalleVenta);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle_Venta> updateDetalleVenta(@PathVariable int id, @RequestBody Detalle_Venta detalleVenta) {
        Detalle_Venta detalleExistente = detalleVentaService.findById(id);
        if (detalleExistente != null) {
            detalleVenta.setId_detalle(id);
            Detalle_Venta detalleActualizado = detalleVentaService.save(detalleVenta);
            return new ResponseEntity<>(detalleActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleVenta(@PathVariable int id) {
        if (detalleVentaService.findById(id) != null) {
            detalleVentaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Nueva ruta para obtener detalles de ventas por empleado y cliente
    @GetMapping("/empleado/{empleadoId}/cliente/{clienteId}")
    public ResponseEntity<List<Detalle_Venta>> getDetallesByEmpleadoAndCliente(@PathVariable int empleadoId, @PathVariable int clienteId) {
        List<Detalle_Venta> detalles = detalleVentaService.findDetallesByEmpleadoAndCliente(empleadoId, clienteId);
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

}