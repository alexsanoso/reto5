package com.reto5.web;

import com.reto5.modelo.Reservation;
import com.reto5.service.ReservationApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexander
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Reservation/")
public class ReservationWeb {
    /**
     * atriuto autowired reservation
     */
    @Autowired
    private ReservationApi reservationApi;

    /**
     * método para obtener todos los reservation
     *
     * @return
     */
    @GetMapping("all")
    public List<Reservation> getAll() {
        return reservationApi.getAll();
    }

    /**
     * método para obtener cada reservation por id
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return reservationApi.getReservation(id);
    }

    /**
     * método para guardar cada reservation
     *
     * @param reservation
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationApi.save(reservation);
    }

    /**
     * método para actualziar una reservación
     *
     * @param reservation
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationApi.update(reservation);
    }

    /**
     * método para borrar una reservación por id
     *
     * @param reservationId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservationApi.deleteReservation(reservationId);
    }

    @GetMapping("report-dates/{from}/{to}")
    public List<Reservation> getByDate(@PathVariable("from") String sFrom, @PathVariable("to") String sTo){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date from = null;
        Date to = null;
        try {
            from = formato.parse(sFrom);
            to = formato.parse(sTo);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return reservationApi.getByDate(from, to);
    }

    /**
     * Método para obtener el conteo las reservas completas de cada cliente
     * @return
     */
    @GetMapping("report-clients")
    public List<Object> getClientReport(){
        return reservationApi.getClientReport();
    }

    /**
     * Método para obtener el mapeo para retornar el conteo de reservas completas vs canceladas
     * @return
     */
    @GetMapping("report-status")
    public LinkedHashMap<String, Integer> getVs(){
        return reservationApi.getVs();
    }
}

