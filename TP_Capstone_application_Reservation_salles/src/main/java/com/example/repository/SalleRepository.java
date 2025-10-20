package com.example.repository;

import com.example.model.Salle;
import java.util.List;

public interface SalleRepository {
    void save(Salle salle);
    void update(Salle salle);
    void delete(Salle salle);
    Salle findById(Long id);
    List<Salle> findAll();
}
