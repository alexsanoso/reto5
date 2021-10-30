package com.reto5.service;

import com.reto5.modelo.Client;
import com.reto5.modelo.Reservation;
import com.reto5.repository.ClientRepository;
import com.reto5.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @author Alexander
 */
@Service
public class ReservationApi {
    /**
     * inciamos el repositorio de reservation
     */
    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * iniciamos el repositorio cliente
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     * método para obtener todos los reservation
     *
     * @return
     */
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    /**
     * método para obtener reservation por id
     *
     * @param idReserva
     * @return
     */
    public Optional<Reservation> getReservation(int idReserva) {
        return reservationRepository.getReservation(idReserva);
    }

    /**
     * método save para reservation
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> evt = reservationRepository.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * método para actualizar una reservación
     *
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> actualizar = reservationRepository.getReservation(reservation.getIdReservation());
            if (!actualizar.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    actualizar.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    actualizar.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    actualizar.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(actualizar.get());
                return actualizar.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * método para borrar una reservación
     *
     * @param reservationId
     * @return
     */
    public boolean deleteReservation(int reservationId) {
        return getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
    }


    public ArrayList<Reservation> getByDate(Date from, Date until) {

        List<Reservation> reservations = reservationRepository.getAll();
        ArrayList<Reservation> dateReservation = new ArrayList<>();
        int count = 0;

        for (Reservation reservation : reservations) {
            if(from.compareTo(until) < 0) {
                if (reservation.getDevolutionDate().compareTo(from) > 0 && reservation.getStartDate().compareTo(until) < 0) {
                    if ((reservation.getStartDate().compareTo(from) <= 0 || reservation.getStartDate().compareTo(from) >= 0) &&
                            reservation.getDevolutionDate().compareTo(until) <= 0 || reservation.getDevolutionDate().compareTo(until) >= 0) {
                        count++;
                        dateReservation.add(reservation);

                        System.out.println(dateReservation.size());
                    }
                }
            }
        }

        return dateReservation;
    }

    /**
     * Método para obtener la cantidad de reservas completadas y canceladas
     * @return
     */
    public LinkedHashMap<String, Integer> getVs(){
        List<Reservation> reservations = reservationRepository.getAll();
        LinkedHashMap<String, Integer> status = new LinkedHashMap<>();
        int completed = 0;
        int cancelled = 0;
        for (Reservation reservation : reservations){
            if ("completed".equals(reservation.getStatus().toLowerCase())){
                completed++;
            }else if ("cancelled".equals(reservation.getStatus().toLowerCase())){
                cancelled++;
            }
        }
        status.put("completed", completed);
        status.put("cancelled", cancelled);
        return  status;
    }

    /**
     * Método para obtener la cantidad de reservas completadas de un cliente
     * @return
     */
    public List<Object> getClientReport(){
        List<Client> clients = clientRepository.getAll();
        LinkedHashMap<String,Object> reportClient = new LinkedHashMap<>();
        List<Object> countClients = new ArrayList<>();
        for (Client client: clients){
            Integer total = 0;
            for (Reservation reservation : client.getReservations()) {
                total++;
            }
            reportClient.put("total", total);
            reportClient.put("client",client);
            countClients.add(reportClient.clone());
            System.out.println(countClients);
            System.out.println(reportClient);
        }
        return countClients;
    }
}
