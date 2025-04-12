package com.example.ProyectoPostgres.Service;

import com.example.ProyectoPostgres.Model.Empleado;
import com.example.ProyectoPostgres.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para manejar operaciones relacionadas con la entidad Empleado.
 */
@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    /**
     * Obtiene una lista de todos los empleados.
     *
     * @return List<Empleado> - lista de empleados.
     */
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    /**
     * Busca un empleado por su ID.
     *
     * @param id - ID del empleado a buscar.
     * @return Empleado - empleado encontrado o null si no existe.
     */
    public Empleado findById(int id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo empleado o actualiza uno existente.
     *
     * @param empleado - empleado a guardar.
     * @return Empleado - empleado guardado.
     */
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    /**
     * Elimina un empleado por su ID.
     *
     * @param id - ID del empleado a eliminar.
     */
    public void deleteById(int id) {
        empleadoRepository.deleteById(id);
    }
}
