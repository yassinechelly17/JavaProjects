package com.example.ftn_entities.membres;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.ftn_entities.performance.RecordNational;
import com.example.ftn_entities.performance.Resultat;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Entité représentant un athlète.
 * Hérite de Utilisateur et contient les informations spécifiques au profil athlète.
 */
@Entity
@DiscriminatorValue("ATHLETE")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Athlete extends Utilisateur {

    @Column(nullable = true) // Peut être null si non applicable immédiatement
    private LocalDate dateNaissance;

    @Column(length = 10) // Ex: HOMME, FEMME
    private String genre;

    @Column(unique = true, length = 50) // Licence unique
    private String numeroLicence;

    @Lob // Pour les textes longs
    private String biographie;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "athlete")
    private Set<Resultat> resultats = new HashSet<>();

    @OneToMany(mappedBy = "detenteur")
    private Set<RecordNational> recordsDetenus = new HashSet<>();

    @ManyToMany(mappedBy = "athletesSelectionnes")
    private Set<EquipeNationale> equipesNationales = new HashSet<>();

    // Relation pour l'inscription aux événements (si gérée via entité)
    // @ManyToMany
    // @JoinTable(...)
    // private Set<Event> eventsInscrits = new HashSet<>();

    // Les méthodes métier (sinscrireEvent, etc.) sont dans les services.
}

