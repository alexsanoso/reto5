package com.reto5.modelo;

// Importaciones

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Sánchez Osorio
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {
    /**
     * Atributo id Message
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idMessage;

    /**
     * Atributo messageText
     */
    @Column(name = "messageText")
    private String messageText;

    /**
     * Relación muchos a uno tabla machine
     */
    @ManyToOne
    @JoinColumn(name = "idM")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Machine machine;

    /**
     * Relación muchos a uno tabla client
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    /**
     * getter idMessage
     *
     * @return
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**
     * setter idMessage
     *
     * @param idMessage
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * getter messageText
     *
     * @return
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * setter messageText
     *
     * @param messageText
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * getter machine message
     *
     * @return
     */
    public Machine getMachine() {
        return machine;
    }

    /**
     * setter machine message
     *
     * @param machine
     */
    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    /**
     * getter client message
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     * setter client message
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }
}

