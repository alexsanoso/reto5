package com.reto5.modelo;

// Importaciones

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
//probando
/**
 * @author Alexander Sánchez Osorio
 */
@Entity
@Table(name = "machine")
public class Machine implements Serializable {
    /**
     * Atributo Id machine
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idM", nullable = false)
    private Integer id;
    /**
     * Atributo name machine
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo brand machine
     */
    @Column(name = "brand")
    private String brand;
    /**
     * Atributo year machine
     */
    @Column(name = "year")
    private Integer year;
    /**
     * Atributo description machine
     */
    @Column(name = "description")
    private String description;

    /**
     * Relación muchos a uno tabla category
     */
    @ManyToOne
    @JoinColumn(name = "idC")
    @JsonIgnoreProperties("machines")
    private Category category;
    /**
     * Relación uno a muchos tabla message
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties({"machine", "client"})
    private List<Message> messages;
    /**
     * Relación uno a muchos tabla reservations
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties("machine")
    private List<Reservation> reservations;

    // getters y setters

    /**
     * Getter id machine
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter id machine
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getter name machine
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter name machine
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter brand machine
     *
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * setter brand machine
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * getter year machine
     *
     * @return
     */
    public Integer getYear() {
        return year;
    }

    /**
     * setter year machine
     *
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * getter description machine
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter description machine
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter category machine
     *
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * setter category machine
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * getter message machine
     *
     * @return
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * setter message machine
     *
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * getter reservation machine
     *
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * setter reservation machine
     *
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}