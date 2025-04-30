package com.example.ftn_entities.securite;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import com.example.ftn_entities.contenu.HeroSlide;
import com.example.ftn_entities.contenu.NewsItem;
import com.example.ftn_entities.membres.Utilisateur;
import com.example.ftn_entities.evenements.Event;
import com.example.ftn_entities.membres_reservations.ReservationPiste;



/**
 * Entité représentant un administrateur du système.
 * Hérite de Utilisateur.
 */
@Entity
@DiscriminatorValue("ADMIN") // Valeur pour cette sous-classe dans la colonne user_type
@Data
@EqualsAndHashCode(callSuper = true) // Inclut les champs de la superclasse dans equals/hashCode
@NoArgsConstructor
public class Admin extends Utilisateur {

    // Les attributs spécifiques à Admin pourraient être ajoutés ici si nécessaire.

    // Relations gérées par l'Admin (inverse de @ManyToOne)
    @OneToMany(mappedBy = "auteur")
    private Set<NewsItem> newsItemsRediges = new HashSet<>();

    @OneToMany(mappedBy = "gestionnaire")
    private Set<HeroSlide> slidesGeres = new HashSet<>();

    @OneToMany(mappedBy = "createur")
    private Set<Event> eventsCrees = new HashSet<>();

    @OneToMany(mappedBy = "gestionnaireReservation")
    private Set<ReservationPiste> reservationsGerees = new HashSet<>();

    // Les méthodes métier (creerUtilisateur, etc.) sont dans les services, pas l'entité.
}

