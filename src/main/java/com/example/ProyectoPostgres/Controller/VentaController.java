package com.example.ProyectoPostgres.Controller;

import com.example.ProyectoPostgres.Model.Venta;
import com.example.ProyectoPostgres.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para manejar las solicitudes relacionadas con la entidad Venta.
 */
@RestController
@RequestMapping("/api/ventas")

public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = ventaService.findAll();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable int id) {
        Venta venta = ventaService.findById(id);
        if (venta != null) {
            return new ResponseEntity<>(venta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.save(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable int id, @RequestBody Venta venta) {
        Venta ventaExistente = ventaService.findById(id);
        if (ventaExistente != null) {
            venta.setId_venta(id);
            Venta ventaActualizada = ventaService.save(venta);
            return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable int id) {
        if (ventaService.findById(id) != null) {
            ventaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Nueva ruta para listar ventas por empleado
    @GetMapping("/empleado/{empleadoId}")
    public ResponseEntity<List<Venta>> getVentasByEmpleadoId(@PathVariable int empleadoId) {
        List<Venta> ventas = ventaService.findVentasByEmpleadoId(empleadoId);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    // Nueva ruta para listar ventas por empleado y cliente
    @GetMapping("/empleado/{empleadoId}/cliente/{clienteId}")
    public ResponseEntity<List<Venta>> getVentasByEmpleadoAndClienteId(@PathVariable int empleadoId, @PathVariable int clienteId) {
        List<Venta> ventas = ventaService.findVentasByEmpleadoAndClienteId(empleadoId, clienteId);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }
}