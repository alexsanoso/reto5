package com.reto5.service;

import com.reto5.modelo.Message;
import com.reto5.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander
 */
@Service
public class MessageApi {
    /**
     * Atributo autowired message
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * método para obtener todos los message
     *
     * @return
     */
    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    /**
     * método para obtener message por id
     *
     * @param id
     * @return
     */
    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    /**
     * método save para message
     *
     * @param message
     * @return
     */
    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> evt = messageRepository.getMessage(message.getIdMessage());
            if (evt.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    /**
     * método para actualziar un mensaje
     *
     * @param message
     * @return
     */
    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> actualizar = messageRepository.getMessage(message.getIdMessage());
            if (!actualizar.isEmpty()) {
                if (message.getMessageText() != null) {
                    actualizar.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(actualizar.get());
                return actualizar.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    /**
     * método para borrar un mensaje
     *
     * @param messageId
     * @return
     */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
