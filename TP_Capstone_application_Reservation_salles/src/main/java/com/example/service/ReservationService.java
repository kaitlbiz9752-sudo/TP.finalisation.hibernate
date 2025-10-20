package com.example.service;

import com.example.model.Reservation;
import java.util.List;

public interface ReservationService {
    void addReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
}
