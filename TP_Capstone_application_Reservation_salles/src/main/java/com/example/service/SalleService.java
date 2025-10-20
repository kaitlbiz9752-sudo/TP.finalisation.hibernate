package com.example.service;

import com.example.model.Salle;
import java.util.List;

public interface SalleService {
    void addSalle(Salle salle);
    void updateSalle(Salle salle);
    void deleteSalle(Salle salle);
    Salle getSalleById(Long id);
    List<Salle> getAllSalles();
}
