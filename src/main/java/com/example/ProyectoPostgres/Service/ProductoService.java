package com.example.ProyectoPostgres.Service;
import com.example.ProyectoPostgres.Model.Producto;
import com.example.ProyectoPostgres.Model.Proveedor;
import com.example.ProyectoPostgres.Repository.ProductoRepository;
import com.example.ProyectoPostgres.Repository.ProveedorRepository;  // Agregar la importación del ProveedorRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Servicio para manejar operaciones relacionadas con la entidad Producto.
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;  // Cambiar a ProveedorRepository

    // Obtiene una lista de todos los productos.
    // @return List<Producto> - lista de productos.
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    // Busca un producto por su ID.
    // @param id - ID del producto a buscar.
    // @return Producto - producto encontrado o null si no existe.
    public Producto findById(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    // Guarda un nuevo producto o actualiza uno existente.
    // @param producto - producto a guardar.
    // @return Producto - producto guardado.
    public Producto save(Producto producto) {

        // Verificar si el proveedor existe
        Proveedor proveedor = proveedorRepository.findById(producto.getProveedor().getId_proveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        // Asignar el proveedor al producto
        producto.setProveedor(proveedor);

        return productoRepository.save(producto);
    }

    // Elimina un producto por su ID.
    // @param id - ID del producto a eliminar.
    public void deleteById(int id) {
        productoRepository.deleteById(id);
    }

    // Lógica para listar productos por proveedor
    public List<Producto> findProductosByProveedorId(int proveedorId) {
        return productoRepository.findProductosByProveedorId(proveedorId);
    }
}