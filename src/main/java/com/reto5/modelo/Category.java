package com.reto5.modelo;

// importaciones

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Alexander Sánchez Osorio
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    /**
     * Atributo Id category
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idC", nullable = false)
    private Integer id;
    /**
     * Atributo name category
     */
    @Column(name = "name")
    private String name;

    /**
     * Atributo description category
     */
    @Column(name = "description")
    private String description;

    /**
     * Relacion uno a muchos tabla machines
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Machine> machines;

    /**
     * getter id category
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter id category
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getter name category
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter name category
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter description category
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter description category
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter machines category
     *
     * @return
     */
    public List<Machine> getMachines() {
        return machines;
    }

    /**
     * setter machines category
     *
     * @param machines
     */
    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }
}

