package com.reto5.repository;

// Importaciones

import com.reto5.modelo.Message;
import com.reto5.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander Sánchez Osorio
 */
@Repository
public class MessageRepository {
    /***
     * Atributo autowired message
     */
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    /**
     * Método para obtener todos los message
     *
     * @return
     */
    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    /**
     * método para obtener message por id
     *
     * @param id
     * @return
     */
    public Optional<Message> getMessage(int id) {
        return messageCrudRepository.findById(id);
    }

    /**
     * método save para message
     *
     * @param message
     * @return
     */
    public Message save(Message message) {
        return messageCrudRepository.save(message);
    }

    /**
     * método para borrar un mensaje
     *
     * @param message
     */
    public void delete(Message message) {
        messageCrudRepository.delete(message);
    }
}

