package com.example.service;

import com.example.model.Reservation;
import com.example.repository.ReservationRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private EntityManager em;
    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(EntityManager em, ReservationRepository reservationRepository) {
        this.em = em;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        reservationRepository.update(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
