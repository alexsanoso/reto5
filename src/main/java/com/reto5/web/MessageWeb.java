package com.reto5.web;

import com.reto5.modelo.Message;
import com.reto5.service.MessageApi;
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
@RequestMapping("/api/Message/")
public class MessageWeb {
    /**
     * atributo autowired message
     */
    @Autowired
    private MessageApi messageApi;

    /**
     * método para obtener todos los mensajes
     *
     * @return
     */
    @GetMapping("all")
    public List<Message> getAll() {
        return messageApi.getAll();
    }

    /**
     * método para obtener mensajes por id
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id) {
        return messageApi.getMessage(id);
    }

    /**
     * método para guardar los mensajes
     *
     * @param message
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return messageApi.save(message);
    }

    /**
     * método para actualizar cada mensaje
     *
     * @param message
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return messageApi.update(message);
    }

    /**
     * método para borrar un mensaje por id
     *
     * @param messageId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return messageApi.deleteMessage(messageId);
    }
}


