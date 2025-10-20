package com.example.util;

import com.example.model.Equipement;
import com.example.model.Reservation;
import com.example.model.Salle;
import com.example.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;

public class DataInitializer {

    private EntityManagerFactory emf;

    public DataInitializer(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void initializeData() {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // --- Utilisateurs ---
            Utilisateur user1 = new Utilisateur("Dupont", "Jean", "jean.dupont@test.com", "0600000000", "Informatique");
            Utilisateur user2 = new Utilisateur("Martin", "Claire", "claire.martin@test.com", "0611111111", "Maths");
            em.persist(user1);
            em.persist(user2);

            // --- Équipements ---
            Equipement e1 = new Equipement("Projecteur", "HD");
            Equipement e2 = new Equipement("Tableau Blanc", "Magnétique");
            Equipement e3 = new Equipement("Microphone", "Sans fil");
            em.persist(e1);
            em.persist(e2);
            em.persist(e3);

            // --- Salles ---
            Salle salle1 = new Salle("Salle A", 20, "Salle informatique", "Bâtiment 1", 1, "101");
            Salle salle2 = new Salle("Salle B", 15, "Salle de réunion", "Bâtiment 2", 2, "201");

            // Association Salle ↔ Equipement
            salle1.getEquipements().add(e1);
            salle1.getEquipements().add(e2);
            salle2.getEquipements().add(e2);
            salle2.getEquipements().add(e3);

            // Mise à jour relation inverse
            e1.getSalles().add(salle1);
            e2.getSalles().add(salle1);
            e2.getSalles().add(salle2);
            e3.getSalles().add(salle2);

            em.persist(salle1);
            em.persist(salle2);

            // --- Réservations ---
            Reservation r1 = new Reservation(LocalDateTime.now(), LocalDateTime.now().plusHours(2), user1, salle1);
            Reservation r2 = new Reservation(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(3), user2, salle2);
            em.persist(r1);
            em.persist(r2);

            em.getTransaction().commit();
            System.out.println("✅ Données initialisées avec succès !");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }
}
