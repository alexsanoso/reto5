package com.reto5.repository;

// Importaciones

import com.reto5.modelo.Client;
import com.reto5.modelo.Reservation;
import com.reto5.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexander Sánchez Osorio
 */
@Repository
public class ReservationRepository {
    /**
     * Atributo autowired para reservation
     */
    @Autowired
    private ReservationCrudRepository reservationRepository;

    /**
     * método para obtener todos los reservation
     *
     * @return
     */
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    /**
     * método para obtener reservation por id
     *
     * @param id
     * @return
     */
    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.findById(id);
    }

    /**
     * método save para reservation
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     * método para borrar una reservación
     *
     * @param reservation
     */
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

}