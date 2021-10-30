package com.reto5.service;

import com.reto5.modelo.Machine;
import com.reto5.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander
 */
@Service
public class MachineApi {

    /**
     * Atributo autowired machine
     */
    @Autowired
    private MachineRepository machineRepository;

    /**
     * método para obtener todos los machine
     *
     * @return
     */
    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    /**
     * método para obtener machine por id
     *
     * @param id
     * @return
     */
    public Optional<Machine> getMachine(int id) {
        return machineRepository.getMachine(id);
    }

    /**
     * método save para machine
     *
     * @param machine
     * @return
     */
    public Machine save(Machine machine) {
        if (machine.getId() == null) {
            return machineRepository.save(machine);
        } else {
            Optional<Machine> evt = machineRepository.getMachine(machine.getId());
            if (evt.isEmpty()) {
                return machineRepository.save(machine);
            } else {
                return machine;
            }
        }
    }

    /**
     * método para actualiza una maquina
     *
     * @param machine
     * @return
     */
    public Machine update(Machine machine) {
        if (machine.getId() != null) {
            Optional<Machine> actualizar = machineRepository.getMachine(machine.getId());
            if (!actualizar.isEmpty()) {
                if (machine.getName() != null) {
                    actualizar.get().setName(machine.getName());
                }
                if (machine.getBrand() != null) {
                    actualizar.get().setBrand(machine.getBrand());
                }
                if (machine.getYear() != null) {
                    actualizar.get().setYear(machine.getYear());
                }
                if (machine.getDescription() != null) {
                    actualizar.get().setDescription(machine.getDescription());
                }

                machineRepository.save(actualizar.get());
                return actualizar.get();
            } else {
                return machine;
            }
        } else {
            return machine;
        }
    }

    /**
     * método para borrar una maquina
     *
     * @param machineId
     * @return
     */
    public boolean deleteMachine(int machineId) {
        Boolean aBoolean = getMachine(machineId).map(machine -> {
            machineRepository.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

