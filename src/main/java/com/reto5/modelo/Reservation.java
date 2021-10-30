package com.reto5.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Alexander Sánchez Osorio
 */
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    /**
     * Atributo idReservation
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idReservation;

    /**
     * Atributo startDate reservation
     */
    @Column(name = "startDate")
    private Date startDate;

    /**
     * Atributo devolutionDate reservation
     */
    @Column(name = "devolutionDate")
    private Date devolutionDate;

    /**
     * Atributo status reservation
     */
    @Column(name = "status")
    private String status = "created";

    /**
     * Relación muchos a uno tabla machine
     */
    @ManyToOne
    @JoinColumn(name = "idReservation")
    @JsonIgnoreProperties("reservations")
    private Machine machine;

    /**
     * Relación muchos a uno tabla client
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    /**
     * Atributo score reservation
     */
    @Column(name = "score")
    private Integer score;

    /**
     * getter idReservation
     *
     * @return
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * setter idReservation
     *
     * @param idReservation
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     * getter startDate reservation
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * setter startDate reservation
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * getter devolutionDate reservation
     *
     * @return
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * setter devolutionDate reservation
     *
     * @param devolutionDate
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * getter status Reservation
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter status reservation
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * getter machine reservation
     *
     * @return
     */
    public Machine getMachine() {
        return machine;
    }

    /**
     * setter machine reservation
     *
     * @param machine
     */
    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    /**
     * getter client
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     * setter client reservation
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * getter score reservation
     *
     * @return
     */
    public Integer getScore() {
        return score;
    }

    /**
     * setter score reservation
     *
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}