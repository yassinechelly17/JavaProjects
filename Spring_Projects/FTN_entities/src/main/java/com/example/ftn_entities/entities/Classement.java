package com.example.ftn_entities.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Classement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classementId;

    @Column(nullable = false, length = 20) // Ex: "2024-2025"
    private String saison;

    @Column(length = 100) // Ex: "100m Nage Libre Hommes 17+"
    private String typeEpreuve; // Combinaison d'infos

    @Column(length = 20) // Optionnel si inclus dans typeEpreuve
    private String groupeAge;

    @Column(length = 10) // Optionnel si inclus dans typeEpreuve
    private String genre;

    @Column(length = 10) // Optionnel si inclus dans typeEpreuve. Ex: SC, LC
    private String typeBassin;

    // Relation (Conceptuelle - les résultats ne sont pas forcément stockés ici)
    // Si on stocke un snapshot, on pourrait avoir une relation @OneToMany vers Resultat
    // ou une structure dénormalisée.
}


