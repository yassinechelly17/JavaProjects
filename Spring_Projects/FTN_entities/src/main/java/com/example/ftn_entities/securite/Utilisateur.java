package com.example.ftn_entities.securite;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Classe de base abstraite pour tous les utilisateurs du système.
 * Gère les informations communes et les crédentiels de connexion.
 * Utilise une stratégie d'héritage JOINED (chaque sous-classe a sa propre table).
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type") // Colonne pour distinguer les types d'utilisateurs
@Data // Génère getters, setters, toString, equals, hashCode
@NoArgsConstructor // Constructeur sans arguments pour JPA
public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long utilisateurId;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(nullable = false, length = 50)
    private String nomFamille;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 50)
    private String nomUtilisateur;

    @Column(nullable = false) // Longueur dépend du hash
    private String motDePasseHash;

    @Column(nullable = false)
    private boolean estActif = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Role rolePrincipal;

    // Méthodes métier (seConnecter, aRole, etc.) seraient dans les services
}

