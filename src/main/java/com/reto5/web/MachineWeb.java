package com.reto5.web;

import com.reto5.modelo.Machine;
import com.reto5.service.MachineApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Machine/")
public class MachineWeb {
    /**
     * atributo autowired machine
     */
    @Autowired
    private MachineApi machineApi;

    /**
     * método para obtener todos los machine
     *
     * @return
     */
    @GetMapping("all")
    public List<Machine> getMachine() {
        return machineApi.getAll();
    }

    /**
     * método para obtener cada machine por id
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Machine> getMachine(@PathVariable("id") int id) {
        return machineApi.getMachine(id);
    }

    /**
     * método para guardar cada machine
     *
     * @param machine
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine machine) {
        return machineApi.save(machine);
    }

    /**
     * método para actualizar cada maquina
     *
     * @param machine
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine) {
        return machineApi.update(machine);
    }

    /**
     * método para borrar cada cliente por id
     *
     * @param machineId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int machineId) {
        return machineApi.deleteMachine(machineId);
    }
}

