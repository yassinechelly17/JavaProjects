package com.example.ftn_entities.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class RecordNational {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @Column(nullable = false, length = 100) // Ex: "100m Nage Libre Hommes 15-16 ans LC"
    private String typeEpreuve; // Combinaison d'infos pour unicité? Ou champs séparés?

    @Column(length = 20) // Optionnel si inclus dans typeEpreuve
    private String groupeAge;

    @Column(length = 10) // Optionnel si inclus dans typeEpreuve
    private String genre;

    @Column(length = 10) // Optionnel si inclus dans typeEpreuve. Ex: SC, LC
    private String typeBassin;

    @Column(nullable = false, length = 20)
    private String temps;

    private LocalDate dateEtablissement;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY) // Un record est pour une discipline
    @JoinColumn(name = "discipline", nullable = false)
    private Discipline discipline; // Utilisation de l'Enum

    @ManyToOne(fetch = FetchType.LAZY) // Le détenteur actuel (peut être null)
    @JoinColumn(name = "athlete_id")
    private Athlete detenteur;
}

