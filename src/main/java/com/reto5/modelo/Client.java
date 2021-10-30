package com.reto5.modelo;

// Importaciones

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Alexander Sánchez Osorio
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {
    /**
     * Atributo id client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idClient;
    /**
     * Atributo email client
     */
    @Column(name = "email")
    private String email;
    /**
     * Atributo password client
     */
    @Column(name = "password")
    private String password;
    /**
     * Atributo name client
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo age client
     */
    @Column(name = "age")
    private int age;

    /**
     * Relación uno a muchos message
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;

    /**
     * Relación uno a muchos reservations
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

    /**
     * getter id client
     *
     * @return
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * setter id client
     *
     * @param idClient
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * getter name client
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter name client
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter email client
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter email client
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter age client
     *
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     * setter age client
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * getter password client
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter password client
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter messages client
     *
     * @return
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * setter messages client
     *
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * getter reservations client
     *
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * setter reservations client
     *
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
