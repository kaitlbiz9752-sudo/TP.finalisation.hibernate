package com.example.repository;

import com.example.model.Reservation;

import javax.persistence.EntityManager;
import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {

    private EntityManager em;

    public ReservationRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Reservation reservation) {
        em.getTransaction().begin();
        em.persist(reservation);
        em.getTransaction().commit();
    }

    @Override
    public void update(Reservation reservation) {
        em.getTransaction().begin();
        em.merge(reservation);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Reservation reservation) {
        em.getTransaction().begin();
        em.remove(em.contains(reservation) ? reservation : em.merge(reservation));
        em.getTransaction().commit();
    }

    @Override
    public Reservation findById(Long id) {
        return em.find(Reservation.class, id);
    }

    @Override
    public List<Reservation> findAll() {
        return em.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
    }
}
