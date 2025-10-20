package com.example.repository;

import com.example.model.Reservation;
import java.util.List;

public interface ReservationRepository {
    void save(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);
    Reservation findById(Long id);
    List<Reservation> findAll();
}
