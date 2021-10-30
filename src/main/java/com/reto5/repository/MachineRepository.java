package com.reto5.repository;

// Importaciones

import com.reto5.modelo.Machine;
import com.reto5.repository.crud.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander Sánchez Osorio
 */
@Repository
public class MachineRepository {
    /**
     * Atributo autowired machine
     */
    @Autowired
    private MachineCrudRepository machineCrudRepository;

    /**
     * método para obtener todos los machine
     *
     * @return
     */
    public List<Machine> getAll() {
        return (List<Machine>) machineCrudRepository.findAll();
    }

    /**
     * método para obtener un machine por id
     *
     * @param id
     * @return
     */
    public Optional<Machine> getMachine(int id) {
        return machineCrudRepository.findById(id);
    }

    /**
     * metodo save para machine
     *
     * @param machine
     * @return
     */
    public Machine save(Machine machine) {
        return machineCrudRepository.save(machine);
    }

    /**
     * método para borrar una maquina
     *
     * @param machine
     */
    public void delete(Machine machine) {
        machineCrudRepository.delete(machine);
    }
}