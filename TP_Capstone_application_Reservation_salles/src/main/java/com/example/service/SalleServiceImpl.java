package com.example.service;

import com.example.model.Salle;
import com.example.repository.SalleRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class SalleServiceImpl implements SalleService {

    private EntityManager em;
    private SalleRepository salleRepository;

    public SalleServiceImpl(EntityManager em, SalleRepository salleRepository) {
        this.em = em;
        this.salleRepository = salleRepository;
    }

    @Override
    public void addSalle(Salle salle) {
        salleRepository.save(salle);
    }

    @Override
    public void updateSalle(Salle salle) {
        salleRepository.update(salle);
    }

    @Override
    public void deleteSalle(Salle salle) {
        salleRepository.delete(salle);
    }

    @Override
    public Salle getSalleById(Long id) {
        return salleRepository.findById(id);
    }

    @Override
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }
}
