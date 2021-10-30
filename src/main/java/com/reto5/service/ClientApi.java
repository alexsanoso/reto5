package com.reto5.service;

import com.reto5.modelo.Client;
import com.reto5.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander
 */
@Service
public class ClientApi {

    /**
     * Atributo autowired client
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     * método para obtener todos los client
     *
     * @return
     */
    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    /**
     * método para obtener client por id
     *
     * @param id
     * @return
     */
    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    /**
     * método save para client
     *
     * @param client
     * @return
     */
    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> evt = clientRepository.getClient(client.getIdClient());
            if (evt.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    /**
     * método para actualizar un cliente
     *
     * @param client
     * @return
     */
    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> actualizar = clientRepository.getClient(client.getIdClient());
            if (!actualizar.isEmpty()) {
                if (client.getName() != null) {
                    actualizar.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    actualizar.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    actualizar.get().setPassword(client.getPassword());
                }
                clientRepository.save(actualizar.get());
                return actualizar.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    /**
     * método para borrar un cliente
     *
     * @param clientId
     * @return
     */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
