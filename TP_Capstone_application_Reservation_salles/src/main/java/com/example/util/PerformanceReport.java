package com.example.util;

import com.example.model.Salle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PerformanceReport {

    private EntityManagerFactory emf;

    public PerformanceReport(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void runPerformanceTests() {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("=== RAPPORT DE PERFORMANCE ===");

            // Test 1: Recherche de salles
            long start = System.currentTimeMillis();
            List<Salle> salles = em.createQuery("FROM Salle", Salle.class).getResultList();
            long end = System.currentTimeMillis();
            System.out.println("Test: Recherche de salles disponibles");
            System.out.println("Temps d'exécution: " + (end - start) + "ms");
            System.out.println("Nombre d'entités chargées: " + salles.size());
            System.out.println("----------------------------------");

            // Test 2: Accès répété pour tester cache
            start = System.currentTimeMillis();
            salles = em.createQuery("FROM Salle", Salle.class).getResultList();
            end = System.currentTimeMillis();
            System.out.println("Test: Accès répété avec cache");
            System.out.println("Temps d'exécution: " + (end - start) + "ms");
            System.out.println("Nombre d'entités chargées: " + salles.size());
            System.out.println("----------------------------------");

            System.out.println("=== RECOMMANDATIONS ===");
            System.out.println("1. Vérifier la configuration du cache de second niveau");
            System.out.println("2. Surveiller régulièrement les performances");
            System.out.println("3. Considérer un pool de connexions optimisé");

        } finally {
            em.close();
        }
    }
}
