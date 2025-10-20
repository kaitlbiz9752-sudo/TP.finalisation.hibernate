package com.example.repository;

import com.example.model.Salle;

import javax.persistence.EntityManager;
import java.util.List;

public class SalleRepositoryImpl implements SalleRepository {

    private EntityManager em;

    public SalleRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Salle salle) {
        em.getTransaction().begin();
        em.persist(salle);
        em.getTransaction().commit();
    }

    @Override
    public void update(Salle salle) {
        em.getTransaction().begin();
        em.merge(salle);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Salle salle) {
        em.getTransaction().begin();
        em.remove(em.contains(salle) ? salle : em.merge(salle));
        em.getTransaction().commit();
    }

    @Override
    public Salle findById(Long id) {
        return em.find(Salle.class, id);
    }

    @Override
    public List<Salle> findAll() {
        return em.createQuery("SELECT s FROM Salle s", Salle.class).getResultList();
    }
}
