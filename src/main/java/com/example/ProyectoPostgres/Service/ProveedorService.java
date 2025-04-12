package com.example.ProyectoPostgres.Service;

import com.example.ProyectoPostgres.Model.Proveedor;
import com.example.ProyectoPostgres.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para manejar operaciones relacionadas con la entidad Proveedor.
 */
@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    /**
     * Obtiene una lista de todos los proveedores.
     *
     * @return List<Proveedor> - lista de proveedores.
     */
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    /**
     * Busca un proveedor por su ID.
     *
     * @param id - ID del proveedor a buscar.
     * @return Proveedor - proveedor encontrado o null si no existe.
     */
    public Proveedor findById(int id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo proveedor o actualiza uno existente.
     *
     * @param proveedor - proveedor a guardar.
     * @return Proveedor - proveedor guardado.
     */
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    /**
     * Elimina un proveedor por su ID.
     *
     * @param id - ID del proveedor a eliminar.
     */
    public void deleteById(int id) {
        proveedorRepository.deleteById(id);
    }
}
