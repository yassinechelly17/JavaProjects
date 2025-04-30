package com.example.ftn_entities.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(nullable = false, length = 150)
    private String nom;

    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Column(length = 100)
    private String lieu;

    @Lob
    private String description;

    @Column(length = 20) // Ex: A_VENIR, EN_COURS, TERMINE
    private String statut;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Discipline discipline;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createur_id", nullable = false)
    private Admin createur;

    @OneToMany(mappedBy = "event")
    private Set<Resultat> resultats = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "event_documents",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "media_file_id")
    )
    private Set<MediaFile> documents = new HashSet<>(); // Meet package, etc.
}

