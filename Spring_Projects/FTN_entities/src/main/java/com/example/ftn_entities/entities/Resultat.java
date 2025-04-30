package com.example.ftn_entities.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Resultat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultatId;

    @Column(length = 20) // Format HH:MM:SS.ms ou similaire
    private String tempsNage;

    private Integer place;

    @Column(length = 500) // Stockage JSON ou texte pour les splits
    private String tempsIntermediaires;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete;

    // Relation inverse (optionnelle) vers Classement si nécessaire
    // @ManyToOne
    // @JoinColumn(name = "classement_id")
    // private Classement classement;
}
