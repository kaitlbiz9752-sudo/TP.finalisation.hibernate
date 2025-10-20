package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipements")
@Cacheable
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nom;

    @Column(length = 500)
    private String description;

    @ManyToMany(mappedBy = "equipements")
    private Set<Salle> salles = new HashSet<>();

    @Version
    private Long version;

    public Equipement() { this.salles = new HashSet<>(); }

    public Equipement(String nom) {
        this.nom = nom;
        this.salles = new HashSet<>();
    }

    public Equipement(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.salles = new HashSet<>();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<Salle> getSalles() { return salles; }
    public void setSalles(Set<Salle> salles) { this.salles = salles; }
}
