package com.example.test;

import com.example.model.Salle;
import com.example.model.Reservation;
import com.example.model.Utilisateur;
import com.example.service.ReservationService;
import com.example.service.SalleService;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;

public class TestScenarios {

    private EntityManagerFactory emf;
    private SalleService salleService;
    private ReservationService reservationService;

    public TestScenarios(EntityManagerFactory emf, SalleService salleService, ReservationService reservationService) {
        this.emf = emf;
        this.salleService = salleService;
        this.reservationService = reservationService;
    }

    public void runAllTests() {
        System.out.println("=== Exécution des tests de réservation ===");

        // Création d'une salle
        Salle salle = new Salle("Salle Test", 20, "Description Test", "Bâtiment A", 1, "101");
        salleService.addSalle(salle);

        // Création d'un utilisateur
        Utilisateur utilisateur = new Utilisateur("Dupont", "Jean", "jean.dupont@test.com", "0600000000", "Informatique");

        // Création d'une réservation
        Reservation reservation = new Reservation(LocalDateTime.now(), LocalDateTime.now().plusHours(2), utilisateur, salle);
        reservationService.addReservation(reservation);

        System.out.println("Salle créée : " + salle.getNom());
        System.out.println("Réservation créée pour utilisateur : " + utilisateur.getNom() + " dans la salle : " + reservation.getSalle().getNom());
    }
}
