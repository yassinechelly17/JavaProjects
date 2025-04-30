package com.example.ftn_entities.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class EquipeNationale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipeId;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(length = 50) // Ex: Senior, Junior
    private String categorie;

    // Relations
    @ManyToMany
    @JoinTable(
            name = "equipe_athlete",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id")
    )
    private Set<Athlete> athletesSelectionnes = new HashSet<>();

    @OneToMany(mappedBy = "equipeNationale")
    private Set<CritereSelection> criteresSelection = new HashSet<>();
}

