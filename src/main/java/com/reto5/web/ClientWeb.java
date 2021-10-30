package com.reto5.web;

import com.reto5.modelo.Client;
import com.reto5.service.ClientApi;
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
@RequestMapping("/api/Client/")
public class ClientWeb {
    /**
     * Atributo autowired client
     */
    @Autowired
    private ClientApi clientApi;

    /**
     * método para obtener todos los clientes
     *
     * @return
     */
    @GetMapping("all")
    public List<Client> getAll() {
        return clientApi.getAll();
    }

    /**
     * método para obtener cada cliente por id
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Client> getClient(@PathVariable("id") int id) {
        return clientApi.getClient(id);
    }

    /**
     * método para guardar los clientes
     *
     * @param client
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return clientApi.save(client);
    }

    /**
     * método para actualizar cada cliente
     *
     * @param client
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return clientApi.update(client);
    }

    /**
     * método para borrar cada cliente por id
     *
     * @param clientId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return clientApi.deleteClient(clientId);
    }
}


