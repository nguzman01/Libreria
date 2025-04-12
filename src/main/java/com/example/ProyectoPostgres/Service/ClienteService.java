package com.example.ProyectoPostgres.Service;
import com.example.ProyectoPostgres.Model.Cliente;
import com.example.ProyectoPostgres.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para manejar operaciones relacionadas con la entidad Cliente.
 * Este servicio proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los clientes.
 */
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Obtiene una lista de todos los clientes.
     *
     * @return List<Cliente> - lista de todos los clientes en la base de datos.
     */
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param id - ID del cliente a buscar.
     * @return Cliente - cliente encontrado o null si no existe.
     */
    public Cliente findById(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo cliente o actualiza uno existente.
     *
     * @param cliente - cliente a guardar o actualizar.
     * @return Cliente - cliente guardado o actualizado.
     */
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Elimina un cliente por su ID.
     *
     * @param id - ID del cliente a eliminar.
     */
    public void deleteById(int id) {
        clienteRepository.deleteById(id);
    }
}
